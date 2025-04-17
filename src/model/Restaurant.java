package model;

public class Restaurant implements IEtablissement<FormulaireRestaurant> {
    private CentraleReservation<Table, FormulaireRestaurant> centrale;

    public Restaurant() {
        centrale = new CentraleReservation<>();
    }

    public int ajouterTable(int nbChaises) {
        Table table = new Table(nbChaises);
        return centrale.ajouterEntite(table);
    }

    @Override
    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        return centrale.donnerPossibilites(formulaire);
    }

    @Override
    public Reservation reserver(int numEntite, FormulaireRestaurant formulaire) {
        return centrale.reserver(numEntite, formulaire);
    }
}
