package sprint_1;

import java.util.ArrayList;

public class expenses{

	String datePurchased;
	int amount;
	String name;
	String catagory;
	String[] catagories = {"Groceries" , "Electronics" , "Bed and Bath" ,"Bills", "Miscellaneous"};
	double tax = .07;
	
	
	
	public expenses() {
		datePurchased = null;
		amount = 0;
		name = null;
		catagory = null;
	}



	public expenses(String datePurchased, int amount, String name, String catagory) {
		super();
		this.datePurchased = datePurchased;
		this.amount = amount;
		this.name = name;
		this.catagory = catagory;
	}
	
	
	
}
