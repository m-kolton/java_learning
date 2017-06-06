import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StopWatchApp extends JFrame {
	
	private final String apptitle = "Stop Watch Application";
	private JLabel title;
	private JTextField hoursField;
	private JTextField minutesField;
	private JTextField secondsField;
	private JButton startButton;
	private JButton stopButton;
	private JButton resetButton;
	private int hours;
	private int minutes;
	private int seconds;
	private boolean isWatchTicking = false;
	
	//private StopWatch stopWatch;
	
	
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
		initializeGUI();
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
	
	private void initializeGUI() {
		// utworzenie panelu
		JPanel content = (JPanel)this.getContentPane();
		content.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// zerowy wiersz
		c.insets = new Insets(2, 2, 2, 2);
		c.gridx = 0;
		c.gridy = 0;
		title = new JLabel("Stop Watch", SwingConstants.CENTER);
		content.add(title, c);
		addWindowListener(new ConfirmOnClose());
		// pierwszy wiersz
		c.gridx = 0;
		c.gridy = 1;
		content.add(createDisplayPanel(), c);
		// drugi wiersz
		c.gridx = 0;
		c.gridy = 2;
		content.add(createButtonsPanel(), c);
	}
	
	private JPanel createDisplayPanel() {
		JPanel displayPanel = new JPanel();
		displayPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(2, 2, 2, 2);
		JLabel hoursLabel = new JLabel("Hours", SwingConstants.CENTER);
		JLabel minutesLabel = new JLabel("Minutes", SwingConstants.CENTER);
		JLabel secondsLabel = new JLabel("Seconds", SwingConstants.CENTER);
		c.gridx = 0;
		c.gridy = 0;
		displayPanel.add(hoursLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		displayPanel.add(minutesLabel, c);
		c.gridx = 2;
		c.gridy = 0;
		displayPanel.add(secondsLabel, c);
		hoursField = new JTextField("");
		Font bigFont = hoursField.getFont().deriveFont(Font.PLAIN, 150f);
		hoursField.setFont(bigFont);
		hoursField.setColumns(2);
		hoursField.setHorizontalAlignment(JTextField.CENTER);
		minutesField = new JTextField("");
		minutesField.setFont(bigFont);
		minutesField.setColumns(2);
		minutesField.setHorizontalAlignment(JTextField.CENTER);
		secondsField = new JTextField("");
		secondsField.setFont(bigFont);
		secondsField.setColumns(2);
		secondsField.setHorizontalAlignment(JTextField.CENTER);
		c.gridx = 0;
		c.gridy = 1;
		displayPanel.add(hoursField, c);
		c.gridx = 1;
		c.gridy = 1;
		displayPanel.add(minutesField, c);
		c.gridx = 2;
		c.gridy = 1;
		displayPanel.add(secondsField,c);
		
		return displayPanel;
	}
	
	private JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		ButtonActions actionListener = new ButtonActions();
		buttonsPanel.setLayout(new GridLayout(1, 3));
		startButton = new JButton("Start");
		startButton.setSize(10, 60);
		startButton.setActionCommand("start");
		startButton.addActionListener(actionListener);
		stopButton = new JButton("Stop");
		stopButton.setSize(10, 60);
		stopButton.setActionCommand("stop");
		stopButton.addActionListener(actionListener);
		resetButton = new JButton("Reset");
		resetButton.setSize(10, 60);
		resetButton.setActionCommand("reset");
		resetButton.addActionListener(actionListener);
		buttonsPanel.add(startButton);
		buttonsPanel.add(stopButton);
		buttonsPanel.add(resetButton);
		
		return buttonsPanel;
		
	}
	
	class ConfirmOnClose extends WindowAdapter {
		@Override 
		public void windowClosing(WindowEvent e) {
			// okno dialogowe przy wyjœciu z aplikacji
			int confirm = JOptionPane.showConfirmDialog(e.getWindow(), "Czy jesteœ pewien ¿e chcesz wyjœæ?");
			// jeœli tak - wyjœcie z aplikacji
			if(confirm == 0) {
				e.getWindow().dispose();
				System.exit(0);
			}
		}
	}
	
	// niedokoñczona klasa wewnêtrzna
	class ButtonActions implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ev) {
			String actCommand = ev.getActionCommand();
			
			if(actCommand.equalsIgnoreCase("reset")) {
				hours = 0;
				minutes = 0;
				seconds = 0;
			} 
			else if(actCommand.equalsIgnoreCase("start")) {
				System.out.println("Klikniêto przycisk START");
				
			}
			
		}
		
	}
	
}
