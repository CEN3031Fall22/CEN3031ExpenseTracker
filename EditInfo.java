package sprint_1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditInfo extends JPanel {
	private DefaultComboBoxModel modelBox;
	private JComboBox<String> choices;
	private String choiceName;
	String userName = " ";
	String passWord = " ";
	String income = " ";
	String currentName = " ";
	String currentPass = " ";
	String currentIncome = " ";
	double income1 = 0;
	double incomeYearly = 0;
	user userObj;

	ArrayList<String> choiceList = new ArrayList<String>();
	public EditInfo(user userObj) {
		this.userObj = userObj;
		setLayout(new FlowLayout());
		setBackground(new Color(0,0,0));

		choiceList.add("Edit Username");
		choiceList.add("Edit Password");
		choiceList.add("Edit Budget");
		modelBox = new DefaultComboBoxModel(choiceList.toArray());
		choices = new JComboBox<String>(modelBox);
		add(choices);
		
		choices.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent l) {

	        choiceName = String.valueOf(choices.getSelectedItem());
       		if (choiceName.equals("Edit Username")) {
    	        boolean valid = false;

       			while (!valid) {
       				userName = JOptionPane.showInputDialog(null, "Enter your new username");
       				if (userName == null) {
	        			break;
	        		}
       				if (userObj.checkUsername(userName)) {
		        		JOptionPane.showMessageDialog(new JFrame(),"This username already exists for another user. Choose something else.");
		        	}
		        	else {
			            userObj.replaceUserName(currentName, userName);
			            currentName = userName;
						valid = true;
		        	}
		        	
       			}
       			
       		}
       		if (choiceName.equals("Edit Password")) {
       			boolean valid = false;
       			while (!valid) {
       				passWord = JOptionPane.showInputDialog(null, "Enter your new password");
       				if (passWord == null) {
       					break;
       				}
       				else {
           				String newPass = passWord;
           				userObj.replacePass(currentName, newPass);
			            valid = true;
       				}
       			}
       		}
       		if (choiceName.equals("Edit Budget")) {
       			boolean valid = false;
       			while (!valid) {
       				income = JOptionPane.showInputDialog(null, "Enter your new budget");
       				if (income == null) {
       					break;
       				}
       				else {
       					income1 = Double.parseDouble(income);
       					userObj.replaceBudget(currentName, income1);
       					valid = true;
       				}
       			}
       		}
       		
	     }
	    });
	}
	public void setName(String userName) {
		currentName = userName;
	}
	public void setPass(String passWord) {
		currentPass = passWord;
	}
	public void setIncome(double budget) {
		income1 = budget;
	}
	
}
