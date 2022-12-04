package sprint_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ExampleClass extends JPanel {
	JTable table = new JTable();
	Object[] columns = {"Username", "Budget", "Date"};
	ArrayList<String> expenses = new ArrayList<String>();
	ArrayList<JTextField> numExpenses = new ArrayList<JTextField>();
	DefaultTableModel model = new DefaultTableModel();
	double budget;
	JTextField expenseName;
	JTextField expenseCat;
	JTextField expensePrice;
	JTextField expenseDate;
	JLabel name;
	JLabel catagory;
	JLabel price;
	JLabel date;
	user userObj;
	String userName;
	ExampleClass() {
		this.userObj = userObj;
		setLayout(null);
		//setBackground(new Color(0,0,0));
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.red);
		table.setGridColor(Color.red);
		table.setSelectionBackground(Color.white);
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.red);
		pane.setBackground(Color.white);
		pane.setBounds(10,10,593,354);
		add(pane);
		Object[] row = new Object[3];
		expenseName = new JTextField();
		expenseName.setBounds(121, 374, 184, 20);
		add(expenseName);
		expenseName.setColumns(10);
		expenseCat = new JTextField();
		expenseCat.setBounds(121, 450, 184, 20);
		add(expenseCat);
		expenseCat.setColumns(10);
		expensePrice = new JTextField();
		expensePrice.setBounds(432, 374 , 171, 20);
		add(expensePrice);
		expensePrice.setColumns(10);
		expenseDate = new JTextField();
		expenseDate.setBounds(432, 450, 171, 20);
		add(expenseDate);
		expenseDate.setColumns(10);
		name = new JLabel("Username");
		name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		name.setForeground(Color.WHITE);
		name.setBounds(121, 400, 184, 35);
		add(name);
		catagory = new JLabel("Password");
		catagory.setFont(new Font("Tahoma", Font.PLAIN, 19));
		catagory.setForeground(Color.WHITE);
		catagory.setBounds(121, 476, 184, 35);
		add(catagory);
		price = new JLabel("Budget");
		price.setFont(new Font("Tahoma", Font.PLAIN, 19));
		price.setForeground(Color.WHITE);
		price.setBounds(432, 400, 184, 35);
		add(price);
		date = new JLabel("Date");
		date.setFont(new Font("Tahoma", Font.PLAIN, 19));
		date.setForeground(Color.WHITE);
		date.setBounds(432, 476, 184, 35);
		add(date);
		//ADD BUTTON//
		JButton addButton = new JButton ("Add");
		addButton.setBounds(121, 520, 150, 35);
		add(addButton);
		//DELETE BUTTON//
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(432, 520, 150, 35);
		add(deleteButton);
		//Budget button//
//		JButton getBudget = new JButton("Budget");
//		getBudget.setBackground(Color.RED);
//		getBudget.setBounds(630, 150, 100, 35);
//		add(getBudget);
		
		
		
		addButton.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	row[0] = expenseName.getText();
	        	row[1] = expenseCat.getText();
	        	row[2] = expensePrice.getText();
	        	//row[3] = expenseDate.getText();
	        	expenses.add(expenseName.toString());
	        	expenses.add(expenseCat.toString());
	        	expenses.add(expensePrice.toString());
	        	expenses.add(expenseDate.toString());
	        	numExpenses.add(expensePrice);
	        	model.addRow(row);
	        }
	    });
		
//		getBudget.addActionListener(new ActionListener(){
//
//	        public void actionPerformed(ActionEvent arg0){
//	        	double total = 0;
//	        	for (int i = 0; i < numExpenses.size(); i++) {
//	        		total += Double.valueOf(numExpenses.get(i).getText());
//	        	}
//	        	double remainder = budget - total;
//	        	JFrame f = new JFrame();
//	        	f.setBackground(Color.red);
//	        	JOptionPane.showMessageDialog(f, "Your remaining budget is " + remainder);
//	        }
//	    });
		
		deleteButton.addActionListener(new ActionListener(){

	        public void actionPerformed(ActionEvent arg0){
	        	int i = table.getSelectedRow();
	        	if (i >= 0) {
	        		model.removeRow(i);
	        	}
	        	else {
	        		JFrame f = new JFrame();
		        	f.setBackground(Color.red);
	        		JOptionPane.showMessageDialog(f, "Error with deletion");
	        	}
	        }
	    });
		this.revalidate();
	}
	
	public void setButton(JButton button) {
		button.setBackground(Color.RED);
		button.setBounds(630, 200, 100, 35);
		add(button);
	}
	
	public void setUsename(String userName) {
		this.userName = userName;
	}
	public void setBudget(double n) {
		budget = n;
	}
	public ArrayList<String> returnList() {
		return expenses;
	}
}





