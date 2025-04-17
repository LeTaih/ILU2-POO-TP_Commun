package model;

public class CentraleReservation<E extends EntiteReservable<F>, F extends Formulaire> {
    private E[] entites;
    private int nbEntite;

    @SuppressWarnings("unchecked")
	public CentraleReservation() {
        this.entites = (E[]) new EntiteReservable[100];
        this.nbEntite = 0;
    }

    public int ajouterEntite(E entite) {
        entite.setId(nbEntite+1); 
        entites[nbEntite] = entite;
        nbEntite++;
        return entite.getId();
    }

    public int[] donnerPossibilites(F formulaire) {
        int[] possibilites = new int[nbEntite];
        for (int i = 0; i < nbEntite; i++) {
            if (entites[i].estLibre(formulaire) && entites[i].compatible(formulaire)) {
                possibilites[i] = entites[i].getId();
            } else {
                possibilites[i] = 0;
            }
        }
        return possibilites;
    }

    public Reservation reserver(int numEntite, F formulaire) {
        if (numEntite < 0 || numEntite >= nbEntite) {
            throw new IllegalArgumentException("Numéro d'entité invalide : " + numEntite);
        }
        E entite = entites[numEntite];
        formulaire.setIdentificationEntite(entite.getId());
        return entite.reserver(formulaire);
    }

}
