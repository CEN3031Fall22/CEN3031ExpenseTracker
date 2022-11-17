package sprint_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class user {

	//integer for the switch statment
	int input = 0;
	String username;
	String password;
	double incomeMonth;
	double incomeYear;
	int index;
	

	ArrayList<user> userArray;
	ArrayList<expenses> expensesArray;
	
	//Parameterized constructor
	public user(String username, String password, double incomeMonth, double incomeYear) {
//		super();
		this.username = username;
		this.password = password;
		this.incomeMonth = incomeMonth;
		this.incomeYear = incomeYear;
		
	}

	//constructor
	public user() {
		username = " username";
		password = "password";
		incomeMonth = 0;
		incomeYear = 0;
		
		//arraylist of user objects only needs to be intitalized in default parameters
		//all other user objects that program will create do not need to create an
		//arraylist
		userArray = new ArrayList<user>();
	}
	
	public void loadExpenses() {
		expensesArray = new ArrayList<expenses>();
		
	}
	
	public void addExpense(String datePurchased, int amount, String name, String catagory) {
		
		expenses newExpense = new expenses(datePurchased,amount,name,catagory);
		expensesArray.add(newExpense);
		
		
	}
	public int getUserIndex( ArrayList<user> u, String username) {
		int index = 0;
		for(int i = 0; i < u.size(); i++) {
			if(u.get(i).username.equals(username)) {
				index = i;
				return index;
			}
		}
		return index;
	}

	
	public void reWriteUserDoc(ArrayList<user> u) {
		
		try {
			//creating buffered writer and filewriter object to re write info from txt file
			BufferedWriter writer = new BufferedWriter(new FileWriter("fin.txt"));
			
			//writing information for the first user account in the txt file
			writer.write( u.get(0).username + "," + u.get(0).password + "," + u.get(0).incomeMonth );
			
			//writing inforamtion for all of the other user accounts int the txt file
			for(int i = 1; i < u.size(); i++) {
				writer.write("," + u.get(i).username + "," + u.get(i).password + "," + u.get(i).incomeMonth);
			}
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	/**this method is called before any other method and it is used to load all of
	 * the information about the different users that the application has knowledge of.
	 * the method creates a filereader and scanner that goes through the text file and collects 
	 * information about the various different user(username, password, and monthly income).
	 * The scanner takes this information and uses it to create user objects and adds
	 * them to the arraylist to be used later. 
	 * 
	 * 
	 * @param u this is the original user object that is used to create the array list
	 * that stores other user objects. this is also the object that is used to call
	 * all method in the tester class.
	 */
	public void loadUser() {	
		
		Scanner s = new Scanner(System.in);
		try {
			s = new Scanner(new FileInputStream("fin.txt"));//txt file with user info
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		s.useDelimiter(",\\s*|\r\n|\n");//user data is seperated by a coma ","
		int i = 0;
		
		while(s.hasNext()) {
			
			//creates new user object and adds it to the user arraylist
			user user = new user();
			userArray.add(user);
			//fils the user object with different information
			userArray.get(i).username = s.next();
			userArray.get(i).password = s.next();
			userArray.get(i).incomeMonth = s.nextDouble();
			userArray.get(i).incomeYear = userArray.get(i).incomeMonth * 12;
			userArray.get(i).index = i;
			
			System.out.println("");
			i++;
		}

		s.close();
	}

	/**this method goes through the arraylist of user objects and prints out the
	 * information to the console. This method is mainly used to test
	 * if the user information is being stored correclty and added to the arraylist
	 * and text file correctly. 
	 * 
	 * @param u- the arraylist of user objects that the method will go through.
	 */
	public void listUsers(ArrayList<user> u) {
		
		//goes through arraylist and prints out user object information to the console
		for(int j = 0; j < u.size();j++) {
			System.out.println("here is the username: " + u.get(j).username);
			System.out.println("here is password: " + u.get(j).password);
			System.out.println("here is the monthly income: $" + u.get(j).incomeMonth);
			System.out.println("here is the yearly income: $" + u.get(j).incomeYear);
			System.out.println("");
		}
	}
	/**this method is a simple log in feature. It takes in a username from the user
	 * and goes through the arraylist of user objects to find a user object that 
	 * has that username. If there is a user object that matchs the username than
	 * the user is promted to enter a password. The user has three guesses to get
	 * the password correct. For right now if the password is correct there is no account
	 * menu for the user to go to, and the program just prints "here is your account"
	 * to the console. A user account menu could be created in the future that allows 
	 * the user to add and change information to their account. 
	 * 
	 * @param u- user array list that is used to go through user objects and find 
	 * the right username and password
	 */
	
	
	//waqars code//
	//method that allows user to edit their data after logging in//
	public void editDataMenu(ArrayList<user> userArr, user u) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,250);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(5,5));
		
		JButton menu0 = new JButton("Edit Username");
		JButton menu1 = new JButton("Edit Password");
		JButton menu2 = new JButton("Edit Monthly Budget");
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(35,100));
		frame.add(center);
		
		center.add(menu0);
		center.add(menu1);
		center.add(menu2);
		
		menu0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				editUsername(userArr,u,getUserIndex(userArray,u.username));
			}
		});
		
		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				editPassword(userArr,u,getUserIndex(userArray,u.username));
			}
		});
		
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				editIncome(userArr,u,getUserIndex(userArray,u.username));
			}
		});
	}
	
	public void editUsername(ArrayList<user> userarray, user u, int index) {
		
		JFrame dframe = new JFrame();
		dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dframe.setSize(270,150);
		dframe.setVisible(true);
		dframe.setLayout(new BorderLayout(5,5));
	
		JPanel dpanel = new JPanel();
		dframe.add(dpanel);
	
		JLabel userlabel = new JLabel("New Username");
		userlabel.setBounds(10,20,80,25);
		dpanel.add(userlabel);
	
		JTextField userText = new JTextField(20);
		userText.setBounds(10,20,16,25);
		dpanel.add(userText);	
	
		JButton dbutton = new JButton("Change Username");
		dbutton.setBounds(10,80,80,25);
		dpanel.add(dbutton);
	
		dbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newUserName = userText.getText();
				u.username = newUserName;
				reWriteUserDoc(userarray);
		}
	});
	}
	
	public void editPassword(ArrayList<user> userarray, user u, int index) {
		
		JFrame dframe = new JFrame();
		dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dframe.setSize(270,150);
		dframe.setVisible(true);
		dframe.setLayout(new BorderLayout(5,5));
	
		JPanel dpanel = new JPanel();
		dframe.add(dpanel);
	
		JLabel userlabel = new JLabel("New password");
		userlabel.setBounds(10,20,80,25);
		dpanel.add(userlabel);
	
		JTextField userText = new JTextField(20);
		userText.setBounds(10,20,16,25);
		dpanel.add(userText);	
	
		JButton dbutton = new JButton("Change password");
		dbutton.setBounds(10,80,80,25);
		dpanel.add(dbutton);
	
		dbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newPassword = userText.getText();
				u.password = newPassword;
				reWriteUserDoc(userarray);
		}
	});
	}
	

	
	public void editIncome(ArrayList<user> userarray, user u, int index) {
		
		JFrame dframe = new JFrame();
		dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dframe.setSize(270,150);
		dframe.setVisible(true);
		dframe.setLayout(new BorderLayout(5,5));
	
		JPanel dpanel = new JPanel();
		dframe.add(dpanel);
	
		JLabel userlabel = new JLabel("New password");
		userlabel.setBounds(10,20,80,25);
		dpanel.add(userlabel);
	
		JTextField userText = new JTextField(20);
		userText.setBounds(10,20,16,25);
		dpanel.add(userText);	
	
		JButton dbutton = new JButton("Change password");
		dbutton.setBounds(10,80,80,25);
		dpanel.add(dbutton);
	
		dbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String income = userText.getText();
				double income1 = Double.parseDouble(income);
				double incomeYearly = income1 * 12;
				
				u.incomeMonth = income1;
				u.incomeYear =  incomeYearly;
				reWriteUserDoc(userarray);
		}
	});
	}
	
	//waqar code: boolean function to check if user already exists by looping through user arraylist//
	public boolean checkUser(String n) {
		for (user index : userArray) {
			if (index.username.equalsIgnoreCase(n)) {
				return false;
			}
		}
		return true;
	}
	
	//waqar code: boolean function to check if password already exists by looping through user arraylist//
		public boolean checkPass(String n) {
			for (user index : userArray) {
				if (index.username.equalsIgnoreCase(n)) {
					return false;
				}
			}
			return true;
		}
	public void loginMenu(Scanner s, user u) {
		//if login attempt failed, user object will be null and user will be taken back to main menu//
				if (u == null) {
					System.out.println("The password was incorrect so there is no user to be edited");
				}
				//if login attempt was correct, user will be put in menu loop that allows them to edit their info//
				else {
					System.out.println("Here is your account page.");
					do {
						System.out.println("1.) Edit User Information.");
						System.out.println("2.) Add Expense.");
						System.out.println("3.) Budgeting Guideline");
						System.out.println("4.) View your expenses");
						System.out.println("5.) Go Back To Main Menu");

						System.out.println("Enter here: ");
						try {
							input = s.nextInt();
						}catch(Exception e)
						{
							System.out.println("something went wrong with input.");
						}
						
						switch(input) {
						case 1:
							//allows user to edit their info//
							//waqars code
							
							break;
							
						case 2: //david code
							System.out.println("this feature is not finished");
							double total = 0;
							double budget;
							double budgetMinusExpenses;
							
							System.out.println("Enter Budget: ");
							budget = s.nextDouble();

							
							budgetMinusExpenses = budget - total;
							System.out.println("Your remaining budget after your expenses is: "+budgetMinusExpenses+"\n");
							break;
							
						case 3:
							//System.out.println("this feature is not finished.");
							System.out.print("                                       50/30/20 Budget Rule \nThe 50/30/20 rule is a popular budgeting method that splits your monthly income among three main categories.\nHere's how it breaks down:\n");
							System.out.println("\n");
							System.out.println("50% of your income: Needs.\nNecessities are the expenses you cant avoid. This portion of your budget should cover required costs such as:\nHousing,  Food, Transportation,Basic utilities & Insurance.\n");
							System.out.println("Your 50% based on your monthly income: ");
							System.out.println(u.getIncomeMonth() / 50.0);
							System.out.println("\n");
							System.out.println("30% of your income: Wants.\nGenerally, wants are the extras that arent essential to living and working. Theyre often for fun and may include:\nMonthly subscriptions, Travel, Entertainment, Meals out.\n");
							System.out.println("Your 30% based on your monthly income: ");
							System.out.println(u.getIncomeMonth() / 30.0);
							System.out.println("\n");
							System.out.println("20% of your income: Savings.\nSavings is the amount you sock away to prepare for the future.\n");
							System.out.println("Your 20% based on your monthly income: ");
							System.out.println(u.getIncomeMonth() / 20.0);
							System.out.println("\n");
							break;
						case 4:
							
						case 5:
							System.out.println("Going back to main menu.");
							break;
						}
				}while(input != 5);
			}
	}
	//getters and setters

	public double getIncomeMonth() {
		return incomeMonth;
	}
	
	public void setIncomeMonth(double incomeMonth) {
		this.incomeMonth = incomeMonth;
	}

	public double getIncomeYear() {
		return incomeYear;
	}

	public void setIncomeYear(double incomeYear) {
		this.incomeYear = incomeYear;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
	}

	public ArrayList<user> getUserArray() {
		return userArray;
	}

	public void setUserArray(ArrayList<user> userArray) {
		this.userArray = userArray;
	}
	
}
