package entity;

import exception.InvalidEmailFormatException;

public class ApplicantRegistration {
    public static void validateEmail(String email) throws InvalidEmailFormatException {
        if (!email.contains("@") || !email.matches(".+\\..+")) {
            throw new InvalidEmailFormatException("Invalid email format. Email should contain '@' and a valid domain.");
        }
        System.out.println("Email is valid. Proceed with registration.");
    }

    public static void main(String[] args) {
        try {
            validateEmail("invalidemail.com"); // Example invalid email
        } catch (InvalidEmailFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

