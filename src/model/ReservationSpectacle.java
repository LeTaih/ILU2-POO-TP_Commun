package model;

public class ReservationSpectacle extends Reservation{
	int num_zone;
	int num_chaise;
	
	ReservationSpectacle(int jour, int mois, int num_zone, int num_chaise) {
		super(jour,mois);
		this.num_zone = num_zone;
		this.num_chaise = num_chaise;
	}
	
	public String toString() {
		return("Le " + jour + "/" + mois + "\nZone " + num_zone + " chaise "+ num_chaise + ".");
	}
}
