import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private JButton exitButton = new JButton("Exit");
	JLabel displayField;
	JLabel displayField2;
	JLabel displayField3;
	JLabel displayField4;
	public MainMenu() {
		setLayout(null);
		
		try {
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("account-image.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("login-image.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(getClass().getResource("list-image.png")).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
			ImageIcon imageIcon4 = new ImageIcon(new ImageIcon(getClass().getResource("exit-image.png")).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));

			displayField = new JLabel(imageIcon);
			displayField.setBounds(350,40,50,50);
			displayField2 = new JLabel(imageIcon2);
			displayField2.setBounds(350, 135, 80, 80);
			displayField3 = new JLabel(imageIcon3);
			displayField3.setBounds(350, 240, 80, 80);
			displayField4 = new JLabel(imageIcon4);
			displayField4.setBounds(350, 350, 50, 50);
		}
		catch (Exception e) {
			////
		}
		setBackground(Color.WHITE);
		
		
		setButton(exitButton, 50, 350, 100, 50);
		add(displayField);
		add(displayField2);
		add(displayField3);
		add(displayField4);
	exitButton.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent arg0){
        	System.exit(0);
        }
    });
	}
	
	public void setButton(JButton button, int x, int y, int n, int f) {
		button.setBackground(Color.RED);
		button.setBounds(x, y, n, f);
		add(button);
	}
	
	
	
}