package week9lab1;

public class LibraryPOS {

	public static void main(String[] args) {
		
		Book b = new Book ("Pearson ", "Java Programming", 200 );
		
		CD c = new CD ( "J-Cole", " ColeWorld - The Sideline Story", 16);
		
		LibraryItem[] items = new LibraryItem[2];
		
		items[0] = b;
		items[1] = c;
		
		for(LibraryItem i: items)System.out.println(i);
		
		double totalLoanPrice = 0;
		
		for (LibraryItem x: items) totalLoanPrice += x.calculatePrice();
		System.out.println("Total Price:" + totalLoanPrice);
		

	}

}
