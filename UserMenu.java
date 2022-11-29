package sprint_1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserMenu extends user{

	public UserMenu(ArrayList<user> userarray,user u) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,250);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout(5,5));
		
		JButton menu0 = new JButton("Edit user Information");
		JButton menu1 = new JButton("Add Expense");
		JButton menu2 = new JButton("Budget Guidline");
		JButton menu3 = new JButton("View Your Expenses");
		JButton menu4 = new JButton("Create Expense Report");
		
		
		JPanel center = new JPanel();
		center.setPreferredSize(new Dimension(35,100));
		frame.add(center);
		
		center.add(menu0);
		center.add(menu1);
		center.add(menu2);
		center.add(menu3);
		center.add(menu4);
		
		expenses exp = new expenses();
		u.loadExpenses();
		
		menu0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				editDataMenu(userArray,u);
			}
		});
		
		menu1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		menu2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		menu3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		menu4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
