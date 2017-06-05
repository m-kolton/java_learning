import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatchApp extends JFrame {
	
	private final String apptitle = "Stop Watch Application";
	
	public static void main(String[] args) {
		StopWatchApp app = new StopWatchApp();
		app.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// metoda wy�rodkowuj�ca okno
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
		// uzyskanie wymiar�w ekranu
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		// sk�adowa x g�rnego lewego naro�nika
		int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		//sk�adowa y g�rnego lewego naro�nika
		int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
		// ustawienie ramki
		frame.setLocation(x, y);
	}
	
	class ConfirmOnClose extends WindowAdapter {
		@Override 
		public void windowClosing(WindowEvent e) {
			// okno dialogowe przy wyj�ciu z aplikacji
			int confirm = JOptionPane.showConfirmDialog(e.getWindow(), "Czy jeste� pewien �e chcesz wyj��?");
			if(confirm == 0) {
				e.getWindow().dispose();
				System.exit(0);
			}
		}
		
	}
	
}
