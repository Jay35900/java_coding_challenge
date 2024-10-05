package exception;

public class FileUploadException extends Exception {
  public FileUploadException(String message) {
    super(message);
    System.out.println("FileUploadException occurred: " + message);
  }
}

