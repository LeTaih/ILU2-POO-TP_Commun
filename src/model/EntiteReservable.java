package model;

public abstract class EntiteReservable <F extends Formulaire> {
	private CalendrierAnnuel calendrier;
	private int id;
	
	public EntiteReservable() {
		calendrier = new CalendrierAnnuel();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean estLibre(F formulaire) {
		return calendrier.estLibre(formulaire.getMois(), formulaire.getJour());
	}
	
	public abstract boolean compatible(F formulaire);
	public abstract Reservation reserver(F formulaire);
	
}