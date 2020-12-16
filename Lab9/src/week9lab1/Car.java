package week9lab1;

public class Car extends RoadVehicle {
	private String carType;
	 
	public Car() {
	 	this("", 0, 0);
	 	}
 
	public Car(String c, int w, int p) { 
		super(w, p);
		setType(c);
	}
 
	public void setType(String t)  {
		carType = t;
	}
 
	public String getType() {
		return carType;
	}
	
	public double calculateDuty() {
		return ImportDuty.CARTAXRATE;
	}

	@Override
	public String toString() {
		return "Car [carType=" + carType + ", calculateDuty()=" + calculateDuty() + "]";
	}

}
