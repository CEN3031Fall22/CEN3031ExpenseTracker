package sprint_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class tester {

	public static void main(String[] args) {
		//initial user object that is used to call all method 
				//and create arraylist of user object
				user user = new user();
						
				//method to load information about different users
				//and create different user objects from the data
				user.loadUser(user);
				
				
				
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(200,250);
				frame.setVisible(true);
				frame.setLayout(new BorderLayout(5,5));
				
				JButton menu0 = new JButton("Create New Account");
				JButton menu1 = new JButton("Login to Existing Account");
				JButton menu2 = new JButton("List Users");
				JButton menu3 = new JButton("Delete Users");
				JButton menu4 = new JButton("Exit Program");
				
				JPanel center = new JPanel();
				center.setPreferredSize(new Dimension(35,100));
				frame.add(center);
				
				center.add(menu0);
				center.add(menu1);
				center.add(menu2);
				center.add(menu3);
				center.add(menu4);
				
				
				menu0.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
				
					JFrame nuframe = new JFrame();
					nuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					nuframe.setSize(270,300);
					nuframe.setVisible(true);
					nuframe.setLayout(new BorderLayout(5,5));
					
					JPanel lpanel = new JPanel();
					nuframe.add(lpanel);
					
					JLabel userlabel = new JLabel("Username");
					userlabel.setBounds(10,20,80,25);
					lpanel.add(userlabel);
					
					JTextField userText = new JTextField(20);
					userText.setBounds(10,20,16,25);
					lpanel.add(userText);
					
					JLabel password = new JLabel("password");
					password.setBounds(10,20,80,25);
					lpanel.add(password);
					
					JTextField passwordText = new JTextField(20);
					passwordText.setBounds(10,20,16,25);
					lpanel.add(passwordText);
					
					JLabel income = new JLabel("income");
					income.setBounds(10,20,80,25);
					lpanel.add(income);
					
					JTextField incomeText = new JTextField(20);
					incomeText.setBounds(10,20,16,25);
					lpanel.add(incomeText);
					
					JButton nubutton = new JButton("Create New User");
					nubutton.setBounds(10,80,80,25);
					lpanel.add(nubutton);
					
					nubutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String username = userText.getText();
							String password = passwordText.getText();
							String income = incomeText.getText();
							double income1 = Double.parseDouble(income);
							double incomeMonthly = income1 * 12;
							user u = new user(username,password,income1,incomeMonthly);
							user.userArray.add(u);
							user.reWriteUserDoc(user.userArray);
						}
					});
					
					}		
					});	
			
				menu1.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
					
					
					JFrame lframe = new JFrame();
					lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					lframe.setSize(270,150);
					lframe.setVisible(true);
					lframe.setLayout(new BorderLayout(5,5));
					
					JPanel lpanel = new JPanel();
					lframe.add(lpanel);
					
					JLabel userlabel = new JLabel("Username");
					userlabel.setBounds(10,20,80,25);
					lpanel.add(userlabel);
					
					JTextField userText = new JTextField(20);
					userText.setBounds(10,20,16,25);
					lpanel.add(userText);
					
					JLabel password = new JLabel("password");
					password.setBounds(10,20,80,25);
					lpanel.add(password);
					
					JTextField passwordText = new JTextField(20);
					passwordText.setBounds(10,20,16,25);
					lpanel.add(passwordText);
					
					JButton lbutton = new JButton("Login");
					lbutton.setBounds(10,80,80,25);
					lpanel.add(lbutton);
					
					lbutton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String username = userText.getText();
							String password = passwordText.getText();
							System.out.println(username);
							System.out.println(password);
						}
					});
					
					}		
					});	
			
				menu2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						System.out.println("");
						System.out.println("Here is a list of users in the text file: ");
						System.out.println("");
						user.listUsers(user.userArray);		
					}		
					});	
				
				menu3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						JFrame dframe = new JFrame();
						dframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dframe.setSize(270,150);
						dframe.setVisible(true);
						dframe.setLayout(new BorderLayout(5,5));
						
						JPanel dpanel = new JPanel();
						dframe.add(dpanel);
						
						JLabel userlabel = new JLabel("Username");
						userlabel.setBounds(10,20,80,25);
						dpanel.add(userlabel);
						
						JTextField userText = new JTextField(20);
						userText.setBounds(10,20,16,25);
						dpanel.add(userText);	
						
						JButton dbutton = new JButton("Delete");
						dbutton.setBounds(10,80,80,25);
						dpanel.add(dbutton);
						
						dbutton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String username = userText.getText();
								int index = user.getUserIndex(user.userArray, username);
								user.userArray.remove(index);
								user.reWriteUserDoc(user.userArray);
							}
						});
					}		
					});	
				
				menu4.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
						frame.dispose();		
						}		
						});	
}
}
