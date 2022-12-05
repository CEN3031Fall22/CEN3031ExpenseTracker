import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class ExpenseFile extends JPanel {
	private user userObj;
	private String expenseName;
	private String expenseCat;
	private String expensePrice;
	private String expenseDate;
	private PrintWriter fileWriter;
	private ArrayList<String> expenses = new ArrayList<String>();
	Scanner fileIn;
	ExpenseFile(user userObj) {
		this.userObj = userObj;
	}

	public void addExpenses(ArrayList<String> n,String userName) throws FileNotFoundException {
//		try {
//			new PrintWriter(userName).close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			try {
//				fileIn = new Scanner(new FileInputStream(createTextFileName(userName)));//txt file with user info
//			} catch (FileNotFoundException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();
//		}
//		 try {
//		        PrintWriter fileWriter = new PrintWriter(fileIn);
//		        
//		        fileWriter.flush(); // empty buffer in the file
//		        fileWriter.close(); // close the file to allow opening by others applications
//		    }
//		    catch(IOException ioException) {
//		        ioException.printStackTrace();
//		    }
		File f = new File(userName);
		try {
			fileWriter = new PrintWriter(f);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public String createTextFileName(String username) {
		String textFileName = username + ".txt";
		
		return textFileName;
	}
}
