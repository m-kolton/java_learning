
public class Singleton {
	private static Singleton instance = null;
	public String name;
	
	// prywatny konstruktor, nie mo�na tworzy� instancji przez wywo�ywanie konstruktora domy�lnego
	private Singleton() {
		System.out.println("Instance created");
	}
	
	// metoda tworz�ca/zwracaj�ca instancje
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
