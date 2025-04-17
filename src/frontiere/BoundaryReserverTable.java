package frontiere;

import java.util.Scanner;

import control.ControlReserverTable;

public class BoundaryReserverTable {
	private ControlReserverTable controlReserverTable;
	private Scanner scanner = new Scanner(System.in);
	
	public BoundaryReserverTable( ControlReserverTable controlReserverTable) {
		this.controlReserverTable = controlReserverTable;
	}

	public void reserverTable(int numClient) {
		int[] possibilites;
		System.out.println("Quand souhaitez vous reserver ?");
		System.out.println("Pour quel mois ? ( en chiffres)");
		String mois = scanner.next();
		System.out.println("Pour quel jour ?");
		String jour = scanner.next();
		System.out.println("Pour combien de personnes ?");
		String nombrePersonnes = scanner.next();
		System.out.println("Pour quel service ?");
		String numService = scanner.next();
		int j = Integer.parseInt(jour);
		int m = Integer.parseInt(mois);
		int nbP =Integer.parseInt(nombrePersonnes);
		int numS =Integer.parseInt(numService);

		possibilites = controlReserverTable.trouverPossibilite(j, m, nbP, numS);
		boolean tableDispo = false;
		for (int i = 1; i< possibilites.length; i++) {
			if (possibilites[i]>0) {
				System.out.println("numero de table: " + possibilites[i]);
				tableDispo = true;
			}
		}
		if (tableDispo) {
			System.out.println("Choississez votre table ");
			String numTable = scanner.next();
			int numT = Integer.parseInt(numTable);
			controlReserverTable.reserver(numClient,numT,possibilites[0]);
			System.out.println("La table " + numTable + " a bien été reservée le "+ jour  + "/"+ mois);
		}
		else {
			System.out.println("Désolé, aucune table n'est disponible.");
		}
	}
}
