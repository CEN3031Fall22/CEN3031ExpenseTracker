package sprint_1;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class expenses extends user{

	String datePurchased;
	double amount;
	String nameOfProduct;
	String catagory;
	String[] catagories = {"Groceries" , "Electronics" , "Bed and Bath" ,"Bills", "Miscellaneous"};
	double tax = .07;
	int index;
	
	
	
	public expenses() {
		datePurchased = null;
		amount = 0;
		nameOfProduct = null;
		catagory = null;
	}



	public expenses(double amount, String name) {
		//super();
		
		this.amount = amount;
		this.nameOfProduct = name;
		
	}
	
	public void loadExpenses(user u) {
		expensesArray = new ArrayList<expenses>();
		Scanner s = new Scanner(System.in);
		try {
			s = new Scanner(new FileInputStream(createTextFileName(u.username)));//txt file with user info
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		s.useDelimiter(",\\s*|\r\n|\n");//user data is seperated by a coma ","
		int i = 0;
		
		while(s.hasNext()) {
			
			//creates new user object and adds it to the user arraylist
			expenses exp = new expenses();
			expensesArray.add(exp);
			//fils the user object with different information
			expensesArray.get(i).nameOfProduct = s.next();
			expensesArray.get(i).amount = s.nextInt();
			expensesArray.get(i).index = i;
			
			System.out.println("");
			i++;
		}

		s.close();
	}
	
	public void reWriteExpenses(user u) {
		try {
			//creating buffered writer and filewriter object to re write info from txt file
			BufferedWriter writer = new BufferedWriter(new FileWriter(createTextFileName(u.username)));
			
			//writing information for the first user account in the txt file
			writer.write( u.expensesArray.get(0).nameOfProduct + "," + u.expensesArray.get(0).amount );
			
			//writing inforamtion for all of the other user accounts int the txt file
			for(int i = 1; i < u.userArray.size(); i++) {
				writer.write("," + u.expensesArray.get(0).nameOfProduct + "," + u.expensesArray.get(0).amount);
			}
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
public void listExpenses(ArrayList<expenses> u) {
		
		//goes through arraylist and prints out user object information to the console
		for(int j = 0; j < u.size();j++) {
			System.out.println("here is the username: " + u.get(j).nameOfProduct);
			System.out.println("here is password: " + u.get(j).amount);
			System.out.println("");
		}
	}
public void addExpense(String name, double amount,user u) {
	expenses exp = new expenses(amount, name);
	expensesArray.add(exp);
	reWriteExpenses(u);
}
	
	public String createTextFileName(String username) {
		String textFileName = username + ".txt";
		
		return textFileName;
	}
	
	
}
