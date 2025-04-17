package model;

public class Table extends EntiteReservable<FormulaireRestaurant> {
    private int nbChaises;
    private CalendrierAnnuel calendrierDeuxiemeService;

    public Table(int nbChaises) {
        super();
        this.nbChaises = nbChaises;
        this.calendrierDeuxiemeService = new CalendrierAnnuel();
    }

    @Override
    public boolean compatible(FormulaireRestaurant formulaire) {
        return ((nbChaises == formulaire.getNombrePersonnes() || nbChaises == formulaire.getNombrePersonnes()+1) && estLibre(formulaire));
    }

    @Override
    public boolean estLibre(FormulaireRestaurant formulaire) {
        int service = formulaire.getNumService();
        int jour = formulaire.getJour();
        int mois = formulaire.getMois();

        if (service == 1) {
            return super.estLibre(formulaire);
        } else {
            return calendrierDeuxiemeService.estLibre(mois, jour);
        }
    }

    @Override
    public Reservation reserver(FormulaireRestaurant formulaire) {
        int service = formulaire.getNumService();
        int jour = formulaire.getJour();
        int mois = formulaire.getMois();

        boolean succes;
        if (service == 1) {
            succes = super.estLibre(formulaire);
            if (succes) {
                new CalendrierAnnuel().reserver(mois, jour); // <-- Correction ci-dessous
            }
        } else {
            succes = calendrierDeuxiemeService.estLibre(mois, jour);
            if (succes) {
                calendrierDeuxiemeService.reserver(mois, jour);
            }
        }

        if (!succes) return null;

        return new ReservationRestaurant(jour,mois,service,formulaire.getIdentificationEntite());
    }
}
