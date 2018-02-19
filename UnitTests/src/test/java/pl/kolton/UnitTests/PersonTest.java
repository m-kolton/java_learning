package pl.kolton.UnitTests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PersonTest {
	
	// Metoda testowa
	@Test
	public void constructorShouldSetFirstNameAndLastName() {
		
		/*
		 * Utworzenie obiektu klasy Person o imieniu 
		 * "Mateusz" i nazwisku "Kołton".
		 */
		Person person = new Person("Mateusz", "Kołton");
		
		// Sprawdzenie poprawności tworzenia obiektów o zadanych parametrach.
		assertEquals("Mateusz", person.getFirstName());
		assertEquals("Kołton", person.getLastName());
	}	
}
