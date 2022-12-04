package sprint_1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.table.DefaultTableModel;

public class GuiClass extends JFrame{
	JTable table1 = new JTable();
//	Object[] columns = {"Username", "Password", "Income"};
//	DefaultTableModel model = new DefaultTableModel();
	//initial user object to load data//
	user userObj = new user();
	//objects that represent each panel//
	DisplayMembers displayMems = new DisplayMembers();
	LoginMenu login = new LoginMenu();
	EditInfo edit = new EditInfo(userObj);
	AddExpense expenseObj = new AddExpense(userObj);
	//variables to hold user data//
	String userName = " ";
	String passWord = " ";
	String income = " ";
	double budget;
//	String password;
	double income1 = 0;
	double incomeYearly = 0;
	//container for card layout//
	JPanel container = new JPanel();
	CardLayout cl = new CardLayout();
	//object for initial main menu//
	MainMenu mainMenu = new MainMenu();
	//text fields to accept information in the login panel//
	JLabel userlabel = new JLabel("Username");
	JTextField userText = new JTextField(20);
	JLabel password = new JLabel("password");
	JTextField passwordText = new JTextField(20);
	JLabel incomeLabel = new JLabel("income");
	JTextField incomeText = new JTextField(20);
	//buttons for main menu//
	JButton createAccButton = new JButton("Create New Account");
	JButton loginButton = new JButton("Login to Existing Account");
	JButton listUsersButton = new JButton("List Users");
	//buttons for login menu panel//
	JButton editInfo = new JButton("Edit User Infomation");
	JButton addExpense = new JButton("Manage Expenses");
	JButton budgetGuide = new JButton("Simple Budget Guide");
	JButton deleteUserButton = new JButton("Delete Account");

	//constructor//
	public GuiClass(String lookAndFeel) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setBackground(new Color(0,0,0));
		createAccButton.setBackground(Color.red);
		createAccButton.setForeground(Color.BLACK);
		loginButton.setBackground(Color.red);
		listUsersButton.setBackground(Color.red);
		editInfo.setBackground(Color.red);
		addExpense.setBackground(Color.red);
		budgetGuide.setBackground(Color.red);
		deleteUserButton.setBackground(Color.red);
		//getting userinfo from file//
		userObj.loadUser();
		//sets look and feel//
		UIManager.setLookAndFeel(lookAndFeel);
		setTitle("Expense Tracker");
		setSize(750,600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    container.setLayout(cl);
	     //adding buttons to mainMenu panel//
	    mainMenu.setButton(createAccButton, 50, 40, 200, 50);
	    mainMenu.setButton(loginButton, 50, 150, 200, 50);
	    mainMenu.setButton(listUsersButton, 50, 250, 200, 50);
	    //adding buttons to login panel//
	    //login.add(editInfo);
	    login.setButton(editInfo, 50, 40, 200, 50);
	    login.setButton(addExpense, 50, 150, 200, 50);
	    login.setButton(deleteUserButton, 50, 260, 200, 50);
	    login.setButton(createButton("1"), 50 , 360, 200, 50);
	    //login.add(budgetGuide);
	    //login.add(viewExpense);
	    //adding back buttons to panels//
	    displayMems.add(createButton("1"));
	    login.add(createButton("1"));
	    edit.add(createButton("3"));
	    expenseObj.setButton(createButton("3"));
	    //adding all panel cards to main container//
	    container.add(mainMenu, "1");
	    container.add(displayMems, "2");
	    container.add(login, "3");
	    container.add(edit, "4");
	    container.add(expenseObj, "5");
	    //making cardlayout and GUI show the mainMenu everytime it is opened//
	    cl.show(container, "1");
	    //adding container to main GUI frame and setting frame visible//
	    add(container);
	    setVisible(true);
	     //actionListener for login button added to mainMenu panel//
	    createAccButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0){
	        	boolean valid = false;
	        	while (!valid) {
	        		userName = JOptionPane.showInputDialog(null, "Enter the username of the new account");
	        		if (userName == null) {
	        			break;
	        		}
		        	if (userObj.checkUsername(userName)) {
		        		JOptionPane.showMessageDialog(new JFrame(),"This user already exists! You can try again");
		        	}
		        	else {
		        		passWord = JOptionPane.showInputDialog(null, "Enter your password " + userName);
		        		if (passWord == null) {
		        			break;
		        		}
		        		String newPass = passWord;
		        		income = JOptionPane.showInputDialog(null, "Enter your budget " + userName);
		        		if (income == null) {
		        			break;
		        		}
		        		double income1 = Double.parseDouble(income);
						double incomeMonthly = income1 * 12;
						user u = new user(userName,newPass,income1,incomeMonthly);
						userObj.userArray.add(u);
						userObj.reWriteUserDoc(userObj.getUserArray());
						JOptionPane.showConfirmDialog(null, userName + " has been added!","User added", JOptionPane.DEFAULT_OPTION);
						valid = true;
		        	}
	        	}
	        }
	    });
	    //actionListener for loginbutton that takes user to login panel//
	    loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean valid = false;
	        	while (!valid) {
	        		userName = JOptionPane.showInputDialog(null, "Enter your existing username");
	        		if (userName == null) {
	        			break;
	        		}
		        	else {
		        		passWord = JOptionPane.showInputDialog(null, "Enter your password " + userName);
		        		if (passWord == null) {
		        			break;
		        		}
		        		String newPass = passWord;

		        		if (!userObj.checkExist(userName, newPass)) {
			        		JOptionPane.showMessageDialog(new JFrame(),"The login information is not correct. You can try again or make a new account.");
			        	}
		        		else {
			            budget = userObj.getIncome(userName);
			            cl.show(container, "3");
						valid = true;
		        		}
		        	}
	        	}
			
			}		
			});
	    //actionListener for delete user button added to mainMenu panel//
	    deleteUserButton.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	boolean valid = false;
	        	while (!valid) {
	        		userName = JOptionPane.showInputDialog(null, "Enter your username to delete your account");
	        		if (userName == null) {
	        			break;
	        		}
		        	else {
		        		passWord = JOptionPane.showInputDialog(null, "Now enter your password");
		        		if (passWord == null) {
		        			break;
		        		}
		        		String newPass = passWord;

		        		if (!userObj.checkExist(userName, newPass)) {
			        		JOptionPane.showMessageDialog(new JFrame(),"The login information is not correct. You can try again or cancel account deletion");
			        	}
		        		else {
		        			int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to delete your account?");
		        			if(dialogResult == JOptionPane.YES_OPTION){
		        			  userObj.removeFromList(userName, newPass);
		        			  JOptionPane.showMessageDialog(new JFrame(),"Your account has been deleted.");
		        			}
		        			else {
		        				break;
		        			}
		        			valid = true;
		        		}
		        	}
	        	}
	        }
	    });
	    //actionListener for create accoun button added to mainMenu panel//
	    listUsersButton.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	displayMems.updateArray(userObj.getUserArray());
	        	cl.show(container, "2");
	        }
	    });
	   
	    //actionListener for edit info button in login panel//
	    editInfo.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	System.out.println("in edit info");
	        	edit.setName(userName);
	        	edit.setPass(passWord);
	        	edit.setIncome(budget);
	        	cl.show(container, "4");
	        }
	    });
	    //actionListener for add expense button in login panell//
	    addExpense.addActionListener(new ActionListener(){
	    	
	        public void actionPerformed(ActionEvent arg0){
	        	expenseObj.setUsename(userName);
	        	expenseObj.setBudget(userObj.getIncome(userName));
	        	cl.show(container, "5");
	        	
	        }
	    });
	    //actionListener for add expense button in login panell//
	    budgetGuide.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	System.out.println("in budget guide");
	        }
	    });
	    
	}
	
	//function for creating back buttons//
	public JButton createButton(String n) {
		
		JButton button = new JButton("Go back");
		button.setBackground(Color.red);
		 button.addActionListener(new ActionListener(){

		        public void actionPerformed(ActionEvent arg0){
		        	cl.show(container, n);
		        }
		    });
		return button;
	}
	
}
