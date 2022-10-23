import java.util.InputMismatchException;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) {
		//scanner object for taking in input from the user
		Scanner scan = new Scanner(System.in);
		
		//integer for the switch statment
		int input = 0;
		
		//initial user object that is used to call all method 
		//and create arraylist of user object
		user user = new user();
		
		//method to load information about different users
		//and create different user objects from the data
		user.loadUser(user);
		
		//intro to program
		System.out.println("Welcome please enter the number that corelates with the "
				+ " menu option you would like to choose.");
		
		
		
		do {
			//collection of different manu options 
			System.out.println("1.) Create new user account.");
			System.out.println("2.) Login to existing account.");
			System.out.println("3.) List user accounts.");
			System.out.println("4.) Delete user account.");
			System.out.println("5.) Exit menu.");
			System.out.print("Enter here: ");
			
			//takes in input from the user to choose different menu options
			do {
			try {
				input = scan.nextInt();
			}catch(InputMismatchException e)
			{
				System.out.println("something went wrong with input.");
			}
			}while(input<1 && input >5);
			
			//switch statment to pick which option the user wants and call
			//method from original user object to edit user objects in arraylist
			switch(input) {
			
			//adds new user object to array and re writes txt file with new info
			case 1:
				user.addUser(scan,user.userArray);
				user.reWriteUserDoc(user.userArray);
				System.out.println("");				
				break;
				
			//basic login with 	user account menu
			case 2:
				user.loginMenu(scan, user.login(user.userArray));
				user.reWriteUserDoc(user.userArray);
				break;
				
			//list info from all of the users	
			case 3:
				System.out.println("");
				System.out.println("Here is a list of users in the text file: ");
				System.out.println("");
				user.listUsers(user.userArray);
				break;
			//deletes user object from arralist and re writes txt file	
			case 4:
				user.deleteUser(user.userArray);
				user.reWriteUserDoc(user.userArray);
				break;
			//ends program
			case 5:
				System.out.println("Ending the program.");
				break;
			}
		}while(input != 5);
		
		}
	}
