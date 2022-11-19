package sprint_1;



import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class tester {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		for (LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
			System.out.println(lafInfo);
		}
		GuiClass newGui = new GuiClass("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				
}
}
