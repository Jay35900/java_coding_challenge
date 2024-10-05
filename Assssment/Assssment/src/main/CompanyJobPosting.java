package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CompanyJobPosting {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CareerHub";
        String user = "root";
        String password = "J@y24480";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Job ID: ");
        int jobId = scanner.nextInt();
        System.out.print("Enter Company ID: ");
        int companyId = scanner.nextInt();
        System.out.print("Enter Job Title: ");
        scanner.nextLine(); // consume newline
        String jobTitle = scanner.nextLine();
        System.out.print("Enter Job Description: ");
        String jobDescription = scanner.nextLine();
        System.out.print("Enter Job Location: ");
        String jobLocation = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Job Type: ");
        String jobType = scanner.next();

        String query = "INSERT INTO Job (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, jobId);
            stmt.setInt(2, companyId);
            stmt.setString(3, jobTitle);
            stmt.setString(4, jobDescription);
            stmt.setString(5, jobLocation);
            stmt.setDouble(6, salary);
            stmt.setString(7, jobType);
            stmt.executeUpdate();
            System.out.println("Job posted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
