package selenium;

public class TestClass {

	public static void validate(int age) throws InvalidAgeException  {
		if (age < 18) {
			throw new InvalidAgeException();
		} else {
			System.out.println("Allright");
		}

	}

	public static void main(String[] args) {
		try {
			validate(17);
		} catch (InvalidAgeException e) {

			System.out.println("Error " + e.getMessage());
		}

	}

}

class InvalidAgeException extends Exception {

	InvalidAgeException() {
		super("exception");
		System.out.println("Invalid age");

	}
}