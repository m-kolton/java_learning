package pl.kolton.UnitTests;

/**
 * Klasa Person do przećwiczenia tworzenia testów 
 * jednostkowych za pomocą biblioteki JUnit.
 * @author Mateusz
 * @version 1.0 19.02.2018
 */
public class Person {
	
	// Prywatne pola klasy Person
	private String firstName;
	private String lastName;
	 
	// Konstruktor ustawiający wartości firstName i lastName
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Metoda wypisująca dane konkretnej osoby w formacie
	 * "Nazywam się imię nazwisko"
	 * @param fName imię przedstawianej osoby
	 * @param lName nazwisko przedstawianej osoby
	 */
	public void introducePerson(String fName, String lName)
	{
		System.out.println("Nazywam się " + fName + " " + lName);
	}
	
	// Gettery i settery składowych klasy
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
