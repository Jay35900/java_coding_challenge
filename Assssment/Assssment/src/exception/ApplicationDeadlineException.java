package exception;

public class ApplicationDeadlineException extends Exception {
  public ApplicationDeadlineException(String message) {
    super(message);
    System.out.println("ApplicationDeadlineException occurred: " + message);
  }
}