package week9lab1;

public class RoadVehicle extends Object implements ImportDuty{
	private int wheels;	    //How many wheels it has
	private int passengers; //How many passengers it can carry
 
	public RoadVehicle() {
 		this(0,0);	
	}
 
	public RoadVehicle(int w, int p) { 
		setWheels(w);
		setPass(p);
	}
 
	public void setWheels(int num) {
		wheels = num;
		}
 
	public int getWheels() {
		return wheels;
		}
 
	public void setPass(int num) {
		passengers = num;
		}
 
	public int getPass() {
		return passengers;
		}
	
	public double calculateDuty() {
		return 0.0;
	}

	@Override
	public String toString() {
		return "RoadVehicle [wheels=" + wheels + ", passengers=" + passengers + "]";
	}
	
	

	
}