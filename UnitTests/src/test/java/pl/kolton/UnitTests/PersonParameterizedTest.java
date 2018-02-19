package pl.kolton.UnitTests;

import org.junit.runner.RunWith;
import org.junit.Test;
import junitparams.Parameters;
import junitparams.JUnitParamsRunner;
//import junitparams.*; - alternatywnie
import static org.junit.Assert.assertEquals;
import static junitparams.JUnitParamsRunner.$;

// Adnotacja o użyciu JUnitParamsRunner
@RunWith(JUnitParamsRunner.class)
public class PersonParameterizedTest {

	/*
	 * Metoda dostarczająca dane do testów.
	 * Zwraca tablicę Object[].
	 */
	private static final Object[] getPerson() {
		return $(
			$("Jan", "Kowalski"),
			$("Jan", "Nowak")
		);
	}
	
	// Metoda testowa
	@Test
	@Parameters(method = "getPerson")
	public void constructorShouldSetFirstNameAndLastName(String firstName, String lastName) {
		
		/*
		 * Utworzenie obiektu klasy Person o imionach i nazwiskach
		 * sparametryzowanych, dostarczanych przez metodę getPerson().
		 */
		Person person = new Person(firstName, lastName);
		
		// Sprawdzenie poprawności tworzenia obiektów o zadanych parametrach.
		assertEquals(firstName, person.getFirstName());
		assertEquals(lastName, person.getLastName());
	}
}
