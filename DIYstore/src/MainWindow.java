import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTable table;
	private JLabel lblImageWindow;
	private JDateChooser txtAddDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		initComponents();
		getConnection();
		showProducts();
	}
	
	String imagePath = null;
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/products_db", "root","root");
			//JOptionPane.showMessageDialog(null, "Connected");
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Not connected");
			return null;
		}
	}
	
	// resize image
	public ImageIcon resizeImage(String imagePath, byte[] pic) {
		ImageIcon myImage = null;
		
		if(imagePath != null) {
			myImage = new ImageIcon(imagePath);
		} else {
			myImage = new ImageIcon(pic);
		}
		
		Image img = myImage.getImage();
		Image img2 = img.getScaledInstance(lblImageWindow.getWidth(), lblImageWindow.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
	
	// display data in JTable
	// 1 - Data -> ArrayList
	
	public ArrayList<Product> getProducts() {
		ArrayList productList = new ArrayList<Product>();
		Connection con = getConnection();
		String query = "SELECT * FROM products";
		Statement statement;
		ResultSet resultSet;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery(query);
			Product product;
			while(resultSet.next()) {
				product = new Product(resultSet.getInt("id"), resultSet.getString("name"), Float.parseFloat(resultSet.getString("price")), resultSet.getString("add_date"), resultSet.getBytes("image"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	// 2 - Populate JTable
	
	public void showProducts() {
		ArrayList<Product> list = getProducts();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		Object[] row = new Object[4];
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getPrice();
			row[3] = list.get(i).getAddDate();
			
			model.addRow(row);
		}
	}
	
	// check inputs
	public boolean checkInput() {
		if(txtName.getText() == null || txtPrice.getText() == null) {
			return false;
		} else {
			try {
				Float.parseFloat(txtPrice.getText());
				return true;
			} catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Wrong input");
				//e.printStackTrace();
				return false;
			}	
		}
	}
	
	// gui
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 425);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblId.setBounds(30, 30, 90, 25);
		contentPane.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblName.setBounds(30, 66, 90, 25);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPrice.setBounds(30, 102, 90, 25);
		contentPane.add(lblPrice);
		
		JLabel lblAddDate = new JLabel("Add Date:");
		lblAddDate.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAddDate.setBounds(30, 138, 130, 25);
		contentPane.add(lblAddDate);
		
		JLabel lblImage = new JLabel("Image:");
		lblImage.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblImage.setBounds(30, 174, 130, 25);
		contentPane.add(lblImage);
		
		txtId = new JTextField();
		txtId.setBounds(180, 30, 120, 25);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(180, 66, 120, 25);
		contentPane.add(txtName);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(180, 102, 120, 25);
		contentPane.add(txtPrice);
		
		txtAddDate = new JDateChooser();
		txtAddDate.setBounds(180, 138, 120, 25);
		contentPane.add(txtAddDate);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(checkInput() && imagePath != null) {
					try {
						Connection con = getConnection();
						PreparedStatement statement = con.prepareStatement("INSERT INTO products(name, price, add_date, image) VALUES(?,?,?,?)");
						statement.setString(1, txtName.getText());
						statement.setString(2, txtPrice.getText());
						
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						String addDate = dateFormat.format(txtAddDate.getDate());
						statement.setString(3,  addDate);
						
						InputStream img = new FileInputStream(new File(imagePath));
						statement.setBlob(4, img);
						statement.executeUpdate();
						showProducts();
						
						JOptionPane.showMessageDialog(null, "Data inserted!");
					} catch(Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Empty fields!");
				}	
				
			}
		});
		
		btnInsert.setBounds(45, 232, 75, 30);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(checkInput() && txtId.getText() != null) {
					String updateQuery;
					PreparedStatement preparedStatement;
					Connection con = getConnection();
					
					if(imagePath == null) {
						try {
							updateQuery = "UPDATE products SET name = ?, price = ?, add_date = ? WHERE id = ?";
							preparedStatement = con.prepareStatement(updateQuery);
							preparedStatement.setString(1, txtName.getText());
							preparedStatement.setString(2, txtPrice.getText());
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String addDate = dateFormat.format(txtAddDate.getDate());
							preparedStatement.setString(3,  addDate);
							preparedStatement.setInt(4, Integer.parseInt(txtId.getText()));
							preparedStatement.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Data updated!");
						} catch(SQLException e) {
							e.printStackTrace();
						}
						
					} else {
						try {
							InputStream img = new FileInputStream(new File(imagePath));
							updateQuery = "UPDATE products SET name = ?, price = ?, add_date = ?, image = ? WHERE id = ?";
							preparedStatement = con.prepareStatement(updateQuery);
							preparedStatement.setString(1, txtName.getText());
							preparedStatement.setString(2, txtPrice.getText());
							
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							String addDate = dateFormat.format(txtAddDate.getDate());
							preparedStatement.setString(3,  addDate);
							preparedStatement.setBlob(4,  img);
							preparedStatement.setInt(5, Integer.parseInt(txtId.getText()));
							preparedStatement.executeUpdate();
							
							JOptionPane.showMessageDialog(null, "Data updated!");
							
						} catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		btnUpdate.setBounds(45, 274, 75, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				if(!txtId.getText().equals("")) {
					try {
						Connection con = getConnection();
						String deleteQuery = "DELETE FROM products WHERE id = ?";
						PreparedStatement preparedStatement = con.prepareStatement(deleteQuery); 
						int id = Integer.parseInt(txtId.getText());
						preparedStatement.setInt(1, id);
						preparedStatement.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data deleted!");
					} catch(SQLException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Data not deleted.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Choose product id to delete it.");
				}
			}
		});
		
		btnDelete.setBounds(45, 316, 75, 30);
		contentPane.add(btnDelete);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 34, 340, 294);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Price", "Add date"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBounds(320, 335, 75, 30);
		contentPane.add(btnFirst);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBounds(586, 335, 75, 30);
		contentPane.add(btnLast);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(405, 335, 75, 30);
		contentPane.add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.setBounds(501, 335, 75, 30);
		contentPane.add(btnPrevious);
		
		JButton btnChooseImage = new JButton("Choose Image");
		btnChooseImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lblImageWindow.setIcon(resizeImage(path, null));
					imagePath = path;
				} else {
					System.out.println("No file selected");
				}
			}
		});
		
		btnChooseImage.setBounds(156, 335, 154, 30);
		contentPane.add(btnChooseImage);
		
		lblImageWindow = new JLabel("");
		lblImageWindow.setBounds(156, 174, 154, 154);
		contentPane.add(lblImageWindow);
	}
}
