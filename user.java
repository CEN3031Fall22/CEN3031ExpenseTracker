package sprint_1;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class user {

	//integer for the switch statment
	int input = 0;
	String username;
	String password;
	double incomeMonth;
	double incomeYear;
	ArrayList<user> userArray;
	
	//Parameterized constructor
	public user(String username, String password, double incomeMonth, double incomeYear) {
		super();
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

	/**This method takes info from the user(username, password, and monthly income) 
	 * and creates a new user object from the at info. The method then adds the 
	 * new user object to the arraylist of user objects.
	 * 
	 * @param s- Scanner objet from the test class. might delete this an intiate
	 * own scanner object within the class
	 * 
	 * @param u- the arraylist of user objects that the new object will be added
	 * to
	 */
	public void addUser(Scanner s, ArrayList<user> u) {
		
		//takes in username, password, and monthly budget
		//this data will be used as parameters for the creation of a new user object
		System.out.print("Enter username: ");
		setUsername(s.next());
		
		System.out.print("Enter password: ");
		setPassword(s.next());
		
		System.out.print("enter monthly budget: ");
		setIncomeMonth(s.nextDouble());
		setIncomeYear(incomeMonth * 12);
		
		//creates new user object with parameterized constructor
		user user = new user(username,password,incomeMonth,incomeYear);
		//adds new user object to arraylist
		u.add(user);

		
	}
	
	/**This method goes back and rewrites the text file that stores all of the 
	 * user information with the new information fromt the new user object that
	 * has been created. 
	 * 
	 @param u- the arraylist of user objects that has information on all the
	 * the different users.
	 */
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
			// TODO Auto-generated catch block
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
	public void loadUser(user u) {	
		
		Scanner s = new Scanner(System.in);
		try {
			s = new Scanner(new FileInputStream("fin.txt"));//txt file with user info
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		s.useDelimiter(",");//user data is seperated by a coma ","
		int i = 0;
		
		while(s.hasNext()) {
			
			//creates new user object and adds it to the user arraylist
			user user = new user();
			u.userArray.add(user);
			//fils the user object with different information
			u.userArray.get(i).username = s.next();
			u.userArray.get(i).password = s.next();
			u.userArray.get(i).incomeMonth = s.nextDouble();
			u.userArray.get(i).incomeYear = u.userArray.get(i).incomeMonth * 12;
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
			System.out.println("here is the monthly income: " + u.get(j).incomeMonth);
			System.out.println("here is the yearly income: " + u.get(j).incomeYear);
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
	public user login(ArrayList<user> u) {
		//the string that the user enters for username
		String inputUserName;
		//the string that the user enters for password
		String inputPassword;
		//integers that is used to save which user object needs to be called
		int index = 0;
		//scanner object to take in user input
		Scanner s = new Scanner(System.in);
		//takes in username from user
		System.out.println("Please enter your username: ");
		inputUserName = s.next();
		//searches through arraylist to find user object with same username
		for(int i = 0; i < u.size(); i++) {
			if(u.get(i).username.equals(inputUserName)) {
				index = i;
				System.out.println("that user exist here is the index: " + index);
				break;
			}
			
		}
			//asks user to enter password there are three attempts before fail 
			for(int j = 0; j < 3; j++) {
				//takes in user password
				System.out.print("Enter password: ");
				inputPassword = s.next();
				//prints "here is your account if password and username match
				if(u.get(index).password.equals(inputPassword)) {
					return u.get(index);
				}
				else {
					System.out.println("that password was not correct.");
				}
					
				
			}
		return null;
	}
	
	public void deleteUser(ArrayList<user> u) {
		//the string that the user enters for username
		String inputUserName;
		//integers that is used to save which user object needs to be called
		int index = 0;
		//scanner object to take in user input
		Scanner scan = new Scanner(System.in);
		//takes in username from user
		System.out.println("Please enter your username for the account that needs to be deleted: ");
		inputUserName = scan.next();
		//searches through arraylist to find user object with same username
		for(int i = 0; i < u.size(); i++) {
			if(u.get(i).username.equals(inputUserName)) {
				index = i;
				break;
			}
					
		}
		//remove user object from arraylist
		u.remove(index);
		
		
	}
	//waqars code//
	//method that allows user to edit their data after logging in//
	public void editData(Scanner s, user u) {
		//if login attempt failed, user object will be null and user will be taken back to main menu//
		if (u == null) {
			System.out.println("The password was incorrect so there is no user to be edited");
		}
		//if login attempt was correct, user will be put in menu loop that allows them to edit their info//
		else {
			System.out.println("What would you like to edit, " + u.getUsername() + "?");
			do {
				System.out.println("1.) Edit username.");
				System.out.println("2.) Edit password.");
				System.out.println("3.) Edit budget");
				System.out.println("4.) Go back to main menu");

				System.out.println("Enter here: ");
				try {
					input = s.nextInt();
				}catch(Exception e)
				{
					System.out.println("something went wrong with input.");
				}
				
				switch(input) {
				case 1:
					System.out.print("Enter new username for " + u.getUsername() + " here:");
					u.setUsername(s.next());		
					break;
					
				case 2:
					System.out.print("Enter new password for " + u.getUsername() + " here:");
					u.setPassword(s.next());
					break;
					
				case 3:
					System.out.print("Enter new monthly budget for " + u.getUsername() + " here:");
					u.setIncomeMonth(s.nextDouble());
					u.setIncomeYear(u.incomeMonth * 12);
					break;
				case 4:
					break;
				}
		}while(input != 4);
	}
	}
	//waqars code//
	
	public void loginMenu(Scanner s, user u) {
		//if login attempt failed, user object will be null and user will be taken back to main menu//
				if (u == null) {
					System.out.println("The password was incorrect so there is no user to be edited");
				}
				//if login attempt was correct, user will be put in menu loop that allows them to edit their info//
				else {
					System.out.println("Here is your account page.");
					do {
						System.out.println("1.) Edit user information.");
						System.out.println("2.) Add expense.");
						System.out.println("3.) Create budget report.");
						System.out.println("4.) Go back to main menu");

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
							u.editData(s, u);
							break;
							
						case 2:
							System.out.println("this feature is not finished");
							break;
							
						case 3:
							System.out.println("this feature is not finished.");
							break;
						case 4:
							System.out.println("Going back to main menu.");
							break;
						}
				}while(input != 4);
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
