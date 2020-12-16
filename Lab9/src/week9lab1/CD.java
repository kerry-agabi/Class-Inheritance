package week9lab1;

public class CD extends LibraryItem {
	
	private String band;
	private String title;
	private int numTracks;
	
	public CD(String band, String title, int numTracks) {
		super();
		setBand(band);
		setTitle(title);
		setNumTracks(numTracks);
	}


    public String getBand() {
		return band;
	}






	public void setBand(String band) {
		this.band = band;
	}






	public String getTitle() {
		return title;
	}






	public void setTitle(String title) {
		this.title = title;
	}






	public int getNumTracks() {
		return numTracks;
	}






	public void setNumTracks(int numTracks) {
		this.numTracks = numTracks;
	}






	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 2.0;
	}


	@Override
	public String toString() {
		return "CD [band=" + band + ", title=" + title + ", numTracks=" + numTracks + ", calculateprice()="
				+ calculatePrice() + "]";
	}
	 


	

}
