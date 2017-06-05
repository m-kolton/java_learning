import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatchApp extends JFrame {
	
	private final String apptitle = "Stop Watch Application";
	
	public static void main(String[] args) {
		StopWatchApp app = new StopWatchApp();
		app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// metoda wyœrodkowuj¹ca okno
		centreWindow(app);
		app.setVisible(true);
	}
	
	public StopWatchApp() {
		this.setTitle(apptitle);
		this.setSize(800, 320);
		//initializeGUI();
		//setTime();
	}
	
	// argumentem metody jest Window: app rozszerza JFrame a JFrame rozszerza Window
	public static void centreWindow(Window frame)  {
		// uzyskanie wymiarów ekranu
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		// sk³adowa x górnego lewego naro¿nika
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		//sk³adowa y górnego lewego naro¿nika
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		// ustawienie ramki
		frame.setLocation(x, y);
	}
	
	class ConfirmOnClose extends WindowAdapter {
		@Override 
		public void windowClosing(WindowEvent e) {
			// okno dialogowe przy wyjœciu z aplikacji
			int confirm = JOptionPane.showConfirmDialog(e.getWindow(), "Czy jesteœ pewien ¿e chcesz wyjœæ?");
			if(confirm == 0) {
				e.getWindow().dispose();
				System.exit(0);
			}
		}
		
	}
	
}
