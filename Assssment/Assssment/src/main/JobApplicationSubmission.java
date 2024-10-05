package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JobApplicationSubmission {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CareerHub";
        String user = "root";
        String password = "J@y24480";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Applicant ID: ");
        int applicantId = scanner.nextInt();
        System.out.print("Enter Job ID: ");
        int jobId = scanner.nextInt();
        System.out.print("Enter Cover Letter: ");
        scanner.nextLine(); // consume newline
        String coverLetter = scanner.nextLine();

        String query = "INSERT INTO JobApplication (JobID, ApplicantID, ApplicationDate, CoverLetter) VALUES (?, ?, NOW(), ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, jobId);
            stmt.setInt(2, applicantId);
            stmt.setString(3, coverLetter);
            stmt.executeUpdate();
            System.out.println("Job application submitted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
