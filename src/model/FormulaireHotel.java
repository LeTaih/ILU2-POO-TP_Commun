public class FormulaireHotel extends Formulaire {
    private int nbLitsSimples;
    private int nbLitsDoubles;

    public FormulaireHotel(int jour, int mois, int numeroChambre, int nbLitsSimples, int nbLitsDoubles) {
        super(jour, mois, numeroChambre);
        this.nbLitsSimples = nbLitsSimples;
        this.nbLitsDoubles = nbLitsDoubles;
    }

    @Override
    public void afficher() {
        System.out.println("Hôtel : " + jour + "/" + mois +
            " - Chambre " + numeroEntite +
            " avec " + nbLitsSimples + " lit(s) simple(s) et " +
            nbLitsDoubles + " lit(s) double(s).");
    }
}
