
public class SingletonTest {
	
	public static void main(String[] args) {
		// próba stworzenia dwóch instancji
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		// ustawienie sk³adowych obiektu
		s1.name = "Mateusz";
		s2.name = "Patryk";
		
		// jeden obiekt -> to samo imiê
		System.out.println(s1.name);
		System.out.println(s2.name);
	}
}
