package scenario;

import control.ControlCreerClient;
import control.ControlReserverTable;
import frontiere.BoundaryCreerClient;
import frontiere.BoundaryReserverTable;
import model.CarnetClientele;
import model.Client;
import model.Restaurant;


public class scenario {
	public static void main(String[] args) {
		Restaurant restaurant;
		restaurant = new Restaurant();
		CarnetClientele carnetClientele = new CarnetClientele();
		ControlCreerClient controlCreerClient = new ControlCreerClient(carnetClientele);
		BoundaryCreerClient boundaryCreerClient = new BoundaryCreerClient(controlCreerClient);
		
		ControlReserverTable controlReserverTable = new ControlReserverTable(restaurant,carnetClientele);
		BoundaryReserverTable boundaryReserverTable = new BoundaryReserverTable(controlReserverTable);
	
		restaurant.ajouterTable(2);
		restaurant.ajouterTable(3);
		restaurant.ajouterTable(2);
		restaurant.ajouterTable(3);
		restaurant.ajouterTable(10);
		restaurant.ajouterTable(3);
		boundaryCreerClient.creerClient();
		boundaryReserverTable.reserverTable(0);
		Client client = carnetClientele.getClient(0);
		System.out.println(client.getReservations());
	}
}
