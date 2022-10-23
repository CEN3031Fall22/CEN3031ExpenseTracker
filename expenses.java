import java.util.Scanner;

public class expenses {
	int choice;
	int input;
	double subtotal = 0.00;
	double total;
	double tax = 0.07;
	double meat;
	double dairy;
	double produce;
	double nonperishable;
	double tv;
	double charger;
	double speaker;
	double headphones;
	double bodySoap;
	double hairWash;
	double faceWash;
	double makeup;
	double other;
	String otherName;
	
	public expenses() {
		meat = 40.00;
		dairy = 40.00;
		produce = 45.00;
		nonperishable = 55.00;
		tv = 300.00;
		charger = 20.00;
		speaker = 60.00;
		headphones = 30.00;
		bodySoap = 20.00;
		hairWash = 30.00;
		faceWash = 30.00;
		makeup = 40.00;
		other = 0.00;
	}
	
	public void menu() { 
		System.out.println("------------Expense List------------");
		System.out.println("1.) Groceries          2.) Electronics");
		System.out.println("3.) Bed and Bath       4.) Other Expense");
		System.out.println("5.) Exit");
		System.out.println("------------------------------------");;
	}

	public double calculateExpenses(double total) {
		
		Scanner in = new Scanner(System.in);
		expenses e = new expenses();
		e.menu();
			
		System.out.println("Enter a choice from above: ");
		choice = in.nextInt();
				
		while (choice != 5) {
			switch(choice) {
			case 1:
				System.out.println("------------Groceries------------\n");
				System.out.println("1.) Meat - $40          2.) Dairy - $40");
				System.out.println("3.) Produce - $45       4.) Non-Perishables - $55");
				System.out.println("5.) Exit");
				System.out.println("---------------------------------\n");

				System.out.println("Enter a choice from above: ");
				input = in.nextInt();

				while(input != 5) {
					switch(input) {
					case 1:
						subtotal = subtotal + meat;
						break;
					
					case 2:
						subtotal = subtotal + dairy;
						break;
					
					case 3:
						subtotal = subtotal + produce;
						break;
						
					case 4:
						subtotal = subtotal + nonperishable;
						break;
						
					default:
						System.out.println("Invalid Choice, Try Again");
					}
					System.out.println("Enter another choice or exit");
					input = in.nextInt();
				}
				e.menu();
				break;
				
			case 2:
				System.out.println("------------Electronics------------\n");
				System.out.println("1.) TV - $300          2.) Charger - $20");
				System.out.println("3.) Speaker - $60      4.) Headphones - $30");
				System.out.println("5.) Exit");
				System.out.println("-----------------------------------\n");
				
				System.out.println("Enter a choice from above: ");
				input = in.nextInt();

				while(input != 5) {
					switch(input) {
					case 1:
						subtotal = subtotal + tv;
						break;
					
					case 2:
						subtotal = subtotal + charger;
						break;
					
					case 3:
						subtotal = subtotal + speaker;
						break;
						
					case 4:
						subtotal = subtotal + headphones;
						break;
						
					default:
						System.out.println("Invalid Choice, Try Again");
					}
					System.out.println("Enter another choice or exit");
					input = in.nextInt();
				}
				e.menu();
				break;
				
			case 3:
				System.out.println("------------Bed and Bath------------\n");
				System.out.println("1.) Body Soap - $20          2.) Shampoo and Conditioner - $30");
				System.out.println("3.) Face Wash - $30          4.) Makeup - $40");
				System.out.println("5.) Exit");
				System.out.println("------------------------------------\n");
				
				System.out.println("Enter a choice from above: ");
				input = in.nextInt();

				while(input != 5) {
					switch(input) {
					case 1:
						subtotal = subtotal + bodySoap;
						break;
					
					case 2:
						subtotal = subtotal + hairWash;
						break;
					
					case 3:
						subtotal = subtotal + faceWash;
						break;
						
					case 4:
						subtotal = subtotal + makeup;
						break;
						
					default:
						System.out.println("Invalid Choice, Try Again");
					}
					System.out.println("Enter another choice or exit");
					input = in.nextInt();
				}
				e.menu();
				break;
				
			case 4:
				
				System.out.println("------------Other Expense------------\n");
				System.out.println("Enter an Expense and its Price: ");
				otherName = in.next();
				other = in.nextDouble();
				subtotal = subtotal + other;
				break;
				
			default:
				System.out.println("Invalid Choice, Try Again");
			}

			System.out.println("Enter to add another expense");
			choice = in.nextInt();
		}
		
		total = subtotal;
		System.out.println("Thank You!\n");
		return total;
	}
}
