package week9lab1;

public class VehicleTest {

	public static void main(String[] args) {
	
		Car c = new Car ( "Saloon", 4, 4);
		
		Hgv h = new Hgv (3200, 8, 1);
		
		RoadVehicle [] rv = new RoadVehicle[2];
		
		rv [0] = c;
		rv[1] = h;
		for(RoadVehicle r:rv)System.out.println(r);
		
		

	}

}
