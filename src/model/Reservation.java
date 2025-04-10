package model;

public abstract class Reservation {
	int jour;
	int mois;
	
	Reservation(int jour, int mois) {
		this.jour = jour;
		this.mois = mois;
	}
	
	public abstract String toString();
}