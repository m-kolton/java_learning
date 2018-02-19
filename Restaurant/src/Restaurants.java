import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Restaurants {

	private JFrame frame;
	private JTextField jtxtChickenBurger;
	private JTextField jtxtChickenBurgerMeal;
	private JTextField jtxtCheeseburger;
	private JTextField jtxtCalculator;
	private JTextField jtxtReceipt;
	private JTextField jtxtQty;
	private JTextField jtxtBig;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurants window = new Restaurants();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Restaurants() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		orderPanel.setBounds(33, 88, 457, 280);
		frame.getContentPane().add(orderPanel);
		orderPanel.setLayout(null);
		
		JLabel lblChickenBurger = new JLabel("Chicken Burger");
		lblChickenBurger.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChickenBurger.setBounds(32, 22, 166, 37);
		orderPanel.add(lblChickenBurger);
		
		JLabel lblChickenBurgerMeal = new JLabel("Chicken Burger Meal");
		lblChickenBurgerMeal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblChickenBurgerMeal.setBounds(32, 69, 222, 31);
		orderPanel.add(lblChickenBurgerMeal);
		
		JLabel lblCheeseburger = new JLabel("Cheeseburger");
		lblCheeseburger.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCheeseburger.setBounds(32, 113, 222, 31);
		orderPanel.add(lblCheeseburger);
		
		jtxtChickenBurger = new JTextField();
		jtxtChickenBurger.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtChickenBurger.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtxtChickenBurger.setBounds(272, 28, 160, 25);
		orderPanel.add(jtxtChickenBurger);
		jtxtChickenBurger.setColumns(10);
		
		jtxtChickenBurgerMeal = new JTextField();
		jtxtChickenBurgerMeal.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtChickenBurgerMeal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtxtChickenBurgerMeal.setColumns(10);
		jtxtChickenBurgerMeal.setBounds(272, 72, 160, 25);
		orderPanel.add(jtxtChickenBurgerMeal);
		
		jtxtCheeseburger = new JTextField();
		jtxtCheeseburger.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtCheeseburger.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtxtCheeseburger.setColumns(10);
		jtxtCheeseburger.setBounds(272, 116, 160, 25);
		orderPanel.add(jtxtCheeseburger);
		
		JLabel lblDrink = new JLabel("Drink");
		lblDrink.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDrink.setBounds(32, 166, 68, 31);
		orderPanel.add(lblDrink);
		
		JLabel lblQty = new JLabel("Quantity");
		lblQty.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQty.setBounds(272, 166, 145, 31);
		orderPanel.add(lblQty);
		
		JComboBox jCmbDrink = new JComboBox();
		jCmbDrink.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jCmbDrink.setModel(new DefaultComboBoxModel(new String[] {"Select a drink", "Apple Juice", "Orange Juice", "Tea", "Cola", "Ice Tea", "Ice Coffee"}));
		jCmbDrink.setBounds(32, 200, 197, 30);
		orderPanel.add(jCmbDrink);
		
		JCheckBox chckbxHomeDelivery = new JCheckBox("Home Delivery");
		chckbxHomeDelivery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxHomeDelivery.setBounds(32, 235, 197, 23);
		orderPanel.add(chckbxHomeDelivery);
		
		jtxtQty = new JTextField();
		jtxtQty.setHorizontalAlignment(SwingConstants.RIGHT);
		jtxtQty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jtxtQty.setBounds(272, 200, 160, 28);
		orderPanel.add(jtxtQty);
		jtxtQty.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 160, 400, 2);
		orderPanel.add(separator);
		
		JCheckBox chckbxTax = new JCheckBox("Tax");
		chckbxTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxTax.setBounds(272, 235, 160, 23);
		orderPanel.add(chckbxTax);
		
		JPanel taxPanel = new JPanel();
		taxPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		taxPanel.setBounds(500, 88, 478, 280);
		frame.getContentPane().add(taxPanel);
		taxPanel.setLayout(null);
		
		JComboBox jCmbCountry = new JComboBox();
		jCmbCountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jCmbCountry.setModel(new DefaultComboBoxModel(new String[] {"Choose One", "Poland", "Deutchland", "France", "Belgium"}));
		jCmbCountry.setBounds(148, 70, 197, 30);
		taxPanel.add(jCmbCountry);
		
		jtxtBig = new JTextField();
		jtxtBig.setFont(new Font("Tahoma", Font.PLAIN, 24));
		jtxtBig.setColumns(10);
		jtxtBig.setBounds(148, 111, 197, 40);
		taxPanel.add(jtxtBig);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConvert.setBounds(78, 213, 100, 40);
		taxPanel.add(btnConvert);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(301, 213, 100, 40);
		taxPanel.add(btnClose);
		
		JLabel jlblConverter = new JLabel("");
		jlblConverter.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblConverter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblConverter.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblConverter.setBounds(148, 162, 197, 31);
		taxPanel.add(jlblConverter);
		
		JLabel lblCurrencyConverter = new JLabel("Currency Converter");
		lblCurrencyConverter.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrencyConverter.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCurrencyConverter.setBorder(null);
		lblCurrencyConverter.setBounds(127, 28, 238, 31);
		taxPanel.add(lblCurrencyConverter);
		
		JPanel totalPanel = new JPanel();
		totalPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		totalPanel.setBounds(500, 379, 478, 200);
		frame.getContentPane().add(totalPanel);
		totalPanel.setLayout(null);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTax.setBounds(41, 35, 166, 37);
		totalPanel.add(lblTax);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblSubTotal.setBounds(41, 85, 217, 31);
		totalPanel.add(lblSubTotal);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTotal.setBounds(41, 135, 222, 31);
		totalPanel.add(lblTotal);
		
		JLabel jlblTotal = new JLabel("");
		jlblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblTotal.setBounds(292, 135, 141, 31);
		totalPanel.add(jlblTotal);
		
		JLabel jlblSubTotal = new JLabel("");
		jlblSubTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblSubTotal.setBounds(292, 85, 141, 31);
		totalPanel.add(jlblSubTotal);
		
		JLabel jlblTax = new JLabel("");
		jlblTax.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblTax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblTax.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblTax.setBounds(292, 35, 141, 31);
		totalPanel.add(jlblTax);
		
		JLabel label = new JLabel("z³");
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBorder(null);
		label.setBounds(438, 35, 30, 31);
		totalPanel.add(label);
		
		JLabel label_1 = new JLabel("z\u0142");
		label_1.setVerticalAlignment(SwingConstants.BOTTOM);
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBorder(null);
		label_1.setBounds(438, 85, 30, 31);
		totalPanel.add(label_1);
		
		JLabel label_2 = new JLabel("z\u0142");
		label_2.setVerticalAlignment(SwingConstants.BOTTOM);
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBorder(null);
		label_2.setBounds(438, 135, 30, 31);
		totalPanel.add(label_2);
		
		JPanel costPanel = new JPanel();
		costPanel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		costPanel.setBounds(33, 379, 457, 200);
		frame.getContentPane().add(costPanel);
		costPanel.setLayout(null);
		
		JLabel lblCostOfDelivery = new JLabel("Cost of Delivery");
		lblCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCostOfDelivery.setBounds(32, 135, 222, 31);
		costPanel.add(lblCostOfDelivery);
		
		JLabel lblCostOfMeal = new JLabel("Cost of Meal");
		lblCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCostOfMeal.setBounds(32, 85, 217, 31);
		costPanel.add(lblCostOfMeal);
		
		JLabel lblCostOfDrink = new JLabel("Cost of Drink");
		lblCostOfDrink.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCostOfDrink.setBounds(32, 35, 166, 37);
		costPanel.add(lblCostOfDrink);
		
		JLabel jlblCostOfDrink = new JLabel("");
		jlblCostOfDrink.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblCostOfDrink.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCostOfDrink.setBounds(274, 35, 141, 31);
		costPanel.add(jlblCostOfDrink);
		jlblCostOfDrink.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel jlblCostOfMeal = new JLabel("");
		jlblCostOfMeal.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCostOfMeal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblCostOfMeal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblCostOfMeal.setBounds(274, 85, 141, 31);
		costPanel.add(jlblCostOfMeal);
		
		JLabel jlblCostOfDelivery = new JLabel("");
		jlblCostOfDelivery.setHorizontalAlignment(SwingConstants.RIGHT);
		jlblCostOfDelivery.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jlblCostOfDelivery.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jlblCostOfDelivery.setBounds(274, 135, 141, 31);
		costPanel.add(jlblCostOfDelivery);
		
		JLabel label_3 = new JLabel("z\u0142");
		label_3.setVerticalAlignment(SwingConstants.BOTTOM);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBorder(null);
		label_3.setBounds(417, 85, 30, 31);
		costPanel.add(label_3);
		
		JLabel label_4 = new JLabel("z\u0142");
		label_4.setVerticalAlignment(SwingConstants.BOTTOM);
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBorder(null);
		label_4.setBounds(417, 35, 30, 31);
		costPanel.add(label_4);
		
		JLabel label_5 = new JLabel("z\u0142");
		label_5.setVerticalAlignment(SwingConstants.BOTTOM);
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_5.setBorder(null);
		label_5.setBounds(417, 135, 30, 31);
		costPanel.add(label_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setBounds(33, 591, 1280, 100);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				
				double ChickenBurgerQuantity = Double.parseDouble(jtxtChickenBurger.getText());
				double ChickenBurgerPrice = 2.39;
				double ChickenBurger;
				ChickenBurger = (ChickenBurgerQuantity * ChickenBurgerPrice);
				
				double ChickenBurgerMealQuantity = Double.parseDouble(jtxtChickenBurgerMeal.getText());
				double ChickenBurgerMealPrice = 4.19;
				double ChickenBurgerMeal;
				ChickenBurgerMeal = (ChickenBurgerMealQuantity * ChickenBurgerMealPrice);
				
				double CheeseburgerQuantity = Double.parseDouble(jtxtCheeseburger.getText());
				double CheeseburgerPrice = 1.79;
				double Cheeseburger;
				Cheeseburger = (CheeseburgerQuantity * CheeseburgerPrice);
				
				String cMeal = String.format("%.2f", ChickenBurger + ChickenBurgerMeal + Cheeseburger);
				jlblCostOfMeal.setText(cMeal);
				
				//cost of delivery
				double deliveryCost = 2.49;
				if(chckbxHomeDelivery.isSelected()) {
					String delivery = String.format("%.2f", deliveryCost);
					jlblCostOfDelivery.setText(delivery);
				} else {
					jlblCostOfDelivery.setText("0,00");
				}
				
				//drinks
				double drinks = Double.parseDouble(jtxtQty.getText());
				double appleJuice = 2.49 * drinks;
				double orangeJuice = 3.49 * drinks;
				double tea = 1.49 * drinks;
				double cola = 2.49 * drinks;
				double iceTea = 3.19 * drinks;
				double iceCoffee = 3.39 * drinks; 
				
				if(jCmbDrink.getSelectedItem().equals("Apple Juice")) {
					String cAppleJuice = String.format("%.2f", appleJuice);
					jlblCostOfDrink.setText(cAppleJuice);
				}
				if(jCmbDrink.getSelectedItem().equals("Orange Juice")) {
					String cOrangeJuice = String.format("%.2f", orangeJuice);
					jlblCostOfDrink.setText(cOrangeJuice);
				}
				if(jCmbDrink.getSelectedItem().equals("Tea")) {
					String cTea = String.format("%.2f", tea);
					jlblCostOfDrink.setText(cTea);
				}
				if(jCmbDrink.getSelectedItem().equals("Cola")) {
					String cCola = String.format("%.2f", cola);
					jlblCostOfDrink.setText(cCola);
				}
				if(jCmbDrink.getSelectedItem().equals("Ice Tea")) {
					String cIceTea = String.format("%.2f", iceTea);
					jlblCostOfDrink.setText(cIceTea);
				}
				if(jCmbDrink.getSelectedItem().equals("Ice Coffee")) {
					String cIceCoffee = String.format("%.2f", iceCoffee);
					jlblCostOfDrink.setText(cIceCoffee);
				}
				if(jCmbDrink.getSelectedItem().equals("Select a drink")){
					jlblCostOfDrink.setText("0");
				}

				//tax
				String drink = jlblCostOfDrink.getText().replace(',','.');
				String meal = jlblCostOfMeal.getText().replace(',','.');
				String deliv = jlblCostOfDelivery.getText().replace(',','.');
				double total1 = Double.parseDouble(drink);
				double total2 = Double.parseDouble(meal);
				double total3 = Double.parseDouble(deliv);
				double allTotal = (total1 + total2 + total3) /100;
				
				if(chckbxTax.isSelected()) {
					String all = String.format("%.2f", allTotal);
					jlblTax.setText(all);
				} else {
					jlblTax.setText("0");
				}
				
				//subtotal
				double subTotal = (total1 + total2 + total3);
				String isubTotal = String.format("%.2f", subTotal);
				jlblSubTotal.setText(isubTotal);
				
				//total
				double taxes = Double.parseDouble(jlblTax.getText().replace(',', '.'));
				double total = taxes + subTotal;
				String iTotal = String.format("%.2f", total);
				jlblTotal.setText(iTotal);
			}
		});
		
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTotal.setBounds(381, 31, 100, 40);
		panel_3.add(btnTotal);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				jtxtReceipt.setText("Receipt DONE");
			}
		});
		
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setBounds(523, 31, 100, 40);
		panel_3.add(btnReceipt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ev) {
				jlblCostOfDrink.setText(null);
				jlblCostOfMeal.setText(null);
				jlblCostOfDelivery.setText(null);
				jlblTax.setText(null);
				jlblSubTotal.setText(null);
				jlblTotal.setText(null);
				jCmbDrink.setSelectedItem("Select a drink");
				jCmbCountry.setSelectedItem("Choose One");
				jtxtChickenBurger.setText("0");
				jtxtChickenBurgerMeal.setText("0");
				jtxtCheeseburger.setText("0");
				jtxtQty.setText("0");
				jtxtBig.setText(null);
				jlblConverter.setText(null);
				jtxtReceipt.setText(null);
			}
		});
		
		btnReset.setBounds(668, 31, 100, 40);
		panel_3.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});
		
		btnExit.setBounds(815, 31, 100, 40);
		panel_3.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(988, 88, 325, 490);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(160, 9, 5, 5);
		panel_1.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 9, 305, 470);
		panel_1.add(tabbedPane_1);
		
		JPanel panel_6 = new JPanel();
		tabbedPane_1.addTab("Receipt", null, panel_6, null);
		panel_6.setLayout(null);
		
		jtxtReceipt = new JTextField();
		jtxtReceipt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jtxtReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		jtxtReceipt.setBounds(0, 11, 300, 431);
		panel_6.add(jtxtReceipt);
		jtxtReceipt.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		tabbedPane_1.addTab("Calculator", null, panel_7, null);
		panel_7.setLayout(null);
		
		jtxtCalculator = new JTextField();
		jtxtCalculator.setBounds(25, 25, 250, 50);
		panel_7.add(jtxtCalculator);
		jtxtCalculator.setColumns(10);
		
		JButton btbSeven = new JButton("7");
		btbSeven.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbSeven.setBounds(24, 90, 60, 60);
		panel_7.add(btbSeven);
		
		JButton btbEight = new JButton("8");
		btbEight.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbEight.setBounds(88, 90, 60, 60);
		panel_7.add(btbEight);
		
		JButton btbNine = new JButton("9");
		btbNine.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbNine.setBounds(152, 90, 60, 60);
		panel_7.add(btbNine);
		
		JButton btbAdd = new JButton("+");
		btbAdd.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbAdd.setBounds(216, 90, 60, 60);
		panel_7.add(btbAdd);
		
		JButton btbFour = new JButton("4");
		btbFour.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbFour.setBounds(24, 154, 60, 60);
		panel_7.add(btbFour);
		
		JButton btbFive = new JButton("5");
		btbFive.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbFive.setBounds(88, 154, 60, 60);
		panel_7.add(btbFive);
		
		JButton btbSix = new JButton("6");
		btbSix.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbSix.setBounds(152, 154, 60, 60);
		panel_7.add(btbSix);
		
		JButton btbSubtract = new JButton("-");
		btbSubtract.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbSubtract.setBounds(216, 154, 60, 60);
		panel_7.add(btbSubtract);
		
		JButton btbOne = new JButton("1");
		btbOne.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbOne.setBounds(24, 218, 60, 60);
		panel_7.add(btbOne);
		
		JButton btbTwo = new JButton("2");
		btbTwo.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbTwo.setBounds(88, 218, 60, 60);
		panel_7.add(btbTwo);
		
		JButton btbThree = new JButton("3");
		btbThree.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbThree.setBounds(152, 218, 60, 60);
		panel_7.add(btbThree);
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnMultiply.setBounds(216, 218, 60, 60);
		panel_7.add(btnMultiply);
		
		JButton btbPoint = new JButton(".");
		btbPoint.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbPoint.setBounds(24, 282, 60, 60);
		panel_7.add(btbPoint);
		
		JButton btbZero = new JButton("0");
		btbZero.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbZero.setBounds(88, 282, 60, 60);
		panel_7.add(btbZero);
		
		JButton btbEqual = new JButton("=");
		btbEqual.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbEqual.setBounds(152, 282, 60, 60);
		panel_7.add(btbEqual);
		
		JButton btbDivide = new JButton("/");
		btbDivide.setFont(new Font("Tahoma", Font.BOLD, 25));
		btbDivide.setBounds(216, 282, 60, 60);
		panel_7.add(btbDivide);
		
		JLabel lblNewLabel = new JLabel("Restaurant Menagement System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNewLabel.setBounds(33, 0, 1280, 89);
		frame.getContentPane().add(lblNewLabel);
	}
}
