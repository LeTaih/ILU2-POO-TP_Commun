package model;

public class ReservationHotel extends Reservation{
	int nb_simple;
	int nb_double;
	int num_chambre;
	
	ReservationHotel(int jour, int mois, int nb_simple, int nb_double, int num_chambre) {
		super(jour,mois);
		this.nb_simple = nb_simple;
		this.nb_double = nb_double;
		this.num_chambre = num_chambre;
	}
	
	public String toString() {
		return("Le " + jour + "/" + mois + "\nChambre " + num_chambre + " avec "+ nb_simple +" lits simple et " + nb_double + " lits doubles.");
	}
}
