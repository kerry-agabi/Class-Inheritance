package week9lab1;

public class Hgv extends RoadVehicle {
	private int cargo;

	public Hgv(){ 	
		this(0,0,0);	
	}

	public Hgv(int c, int w, int p){ 
		super(w, p);
		setCargo(c);
	}

	public void setCargo(int size){
		cargo = size;
		}

	public int getCargo(){
		return cargo;
		}	
	
	public double calculateDuty() {
		return ImportDuty.HGVTAXRATE;
	}

	@Override
	public String toString() {
		return "Hgv [cargo=" + cargo + ", calculateDuty()=" + calculateDuty() + "]";
	}
}


