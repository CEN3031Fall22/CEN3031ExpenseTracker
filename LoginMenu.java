package sprint_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginMenu extends JPanel {
	//buttons to add to login menu//
	
	JLabel displayField;
	JLabel displayField2;
	JLabel displayField3;
	JLabel displayField4;
	
	LoginMenu(){
		
		setLayout(null);
		//setBackground(new Color(0,0,0));
		
		try {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("edit-image.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("manage-image.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(getClass().getResource("delete-image.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(getClass().getResource("back-image.png")).getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));

			displayField = new JLabel(imageIcon);
			displayField.setBounds(350,40,50,50);
			displayField2 = new JLabel(imageIcon2);
			displayField2.setBounds(350, 135, 80, 80);
			displayField3 = new JLabel(imageIcon3);
			displayField3.setBounds(350, 240, 80, 80);
			displayField4 = new JLabel(imageIcon4);
			displayField4.setBounds(350, 450, 64, 64);
		}
		catch (Exception e) {
			////
		}
		add(displayField);
		add(displayField2);
		add(displayField3);
		add(displayField4);

	}
	
	//functions for setting buttons//
	public void setButton(JButton button, int x, int y, int n, int f) {
		button.setBackground(Color.RED);
		button.setBounds(x, y, n, f);
		add(button);
	}
}

