package exception;

public class InvalidEmailFormatException extends Exception {
  public InvalidEmailFormatException(String message) {
    super(message);
    System.out.println("InvalidEmailFormatException occurred: " + message);
  }
}
