
public class Product {
	private int id;
	private String name;
	private float price;
	private String addDate;
	private byte[] image;
	
	// konstruktor inicjalizuj¹cy wartoœci zmiennych
	public Product(int id, String name, float price, String addDate, byte[] image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.addDate = addDate;
		this.image = image;
	}
	
	// gettery
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public float getPrice() {
		return price;
	}
	public String getAddDate() {
		return addDate;
	}
	public byte[] getImage() {
		return image;
	}
	
}
