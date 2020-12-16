package week9lab1;

public class Book extends LibraryItem {
	
	private String author;
	private String title;
	private int numPages;
	

	public Book(String author, String title, int numPages) {
		super();
		setAuthor(author);
		setTitle(title);
		setNumPages(numPages);
	}


	


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getNumPages() {
		return numPages;
	}


	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}


	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 1.50;
	}





	@Override
	public String toString() {
		return "Book [author=" + author + ", title=" + title + ", numPages=" + numPages + ", calculateprice()="
				+ calculatePrice() + "]";
	}

}
