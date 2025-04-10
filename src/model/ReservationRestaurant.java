package model;

public class ReservationRestaurant extends Reservation{
	int num_service;
	int num_table;
	
	ReservationRestaurant(int jour, int mois, int num_service, int num_table) {
		super(jour,mois);
		this.num_service = num_service;
		this.num_table = num_table;
	}
	
	public String toString() {
		String service = "";
		if (num_service == 1) service = "premier";
		if (num_service == 2) service = "deuxième";
		return("Le " + jour + "/" + mois + "\nTable " + num_table + " pour le "+ service +" service.");
	}
}
