package model;

public class CalendrierAnnuel {
	private class Mois {
		String nom;
		boolean[] jours;
		
		Mois(String nom, int nbjours) {
			this.nom = nom;
			this.jours = new boolean[nbjours];
		}
		
		private boolean estLibre(int jour) {
			return (!(jours[jour]));
		}
		
		private boolean reserver(int jour) {
			if (estLibre(jour)) {
				jours[jour] = true;
				return true;
			}
			return false;
		}
	}
	
	private Mois[] calendrier = new Mois[12];
	
	public CalendrierAnnuel() {
	    calendrier[0] = new Mois("Janvier", 31);
	    calendrier[1] = new Mois("Février", 28);
	    calendrier[2] = new Mois("Mars", 31);
	    calendrier[3] = new Mois("Avril", 30);
	    calendrier[4] = new Mois("Mai", 31);
	    calendrier[5] = new Mois("Juin", 30);
	    calendrier[6] = new Mois("Juillet", 31);
	    calendrier[7] = new Mois("Août", 31);
	    calendrier[8] = new Mois("Septembre", 30);
	    calendrier[9] = new Mois("Octobre", 31);
	    calendrier[10] = new Mois("Novembre", 30);
	    calendrier[11] = new Mois("Décembre", 31);
	}

	
	public boolean estLibre(int jour, int mois) {
		if (mois < 0 || mois  > 12) {
			throw new IllegalStateException("Mois invalide");
		}
		return calendrier[mois-1].estLibre(jour-1);
	}
	
	public boolean reserver(int jour, int mois) {
		if (mois < 0 || mois  > 12) {
			throw new IllegalStateException("Mois invalide");
		}
		return(calendrier[mois-1].reserver(jour-1));
	}
}
