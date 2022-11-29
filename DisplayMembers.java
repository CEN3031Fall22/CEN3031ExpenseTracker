package sprint_1;


import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DisplayMembers extends JPanel {
	private Scanner fileIn = null;
	private List<String> membersList = new ArrayList<>();
	private JScrollPane scrollPane = new JScrollPane();
	private DefaultListModel model = new DefaultListModel();
	private String member;
	private String passWord;
	private String income;
	
	public DisplayMembers() {
		setLayout(new FlowLayout());
		setBackground(new Color(0,0,0));

		try {
			FileInputStream file = new FileInputStream("fin.txt");
			fileIn = new Scanner(file);
			fileIn.useDelimiter(",");
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		do {
			member = fileIn.next();
			membersList.add(member);
			passWord = fileIn.next();
			income = fileIn.next();
		} while(fileIn.hasNext());
		model.addAll(membersList);
		JList<String> list = new JList<String>(model);
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		add(scrollPane);
		fileIn.close();
	}
	public void delete(String userName) {
		model.removeAllElements();
	}
	public void addMember(String newMember) {
		membersList.add(newMember);
		model.removeAllElements();
		model.addAll(membersList);
	}
	//create function to take in arraylist and then update model//
	public void updateArray(ArrayList<user> list) {
		model.removeAllElements();
		ArrayList<String> newList = new ArrayList<String>();
		for (user index : list) {
			newList.add(index.username);
		}
		model.addAll(newList);
	}
}
