
public class Singleton {
	private static Singleton instance = null;
	public String name;
	
	// prywatny konstruktor, nie mo¿na tworzyæ instancji przez wywo³ywanie konstruktora domyœlnego
	private Singleton() {
		System.out.println("Instance created");
	}
	
	// metoda tworz¹ca/zwracaj¹ca instancje
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
