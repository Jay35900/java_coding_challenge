package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SalaryRangeQuery {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/CareerHub";
        String user = "root";
        String password = "J@y24480";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Minimum Salary: ");
        double minSalary = scanner.nextDouble();
        System.out.print("Enter Maximum Salary: ");
        double maxSalary = scanner.nextDouble();

        String query = "SELECT Job.JobTitle, Company.CompanyName, Job.Salary " +
                "FROM Job JOIN Company ON Job.CompanyID = Company.CompanyID " +
                "WHERE Job.Salary BETWEEN ? AND ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, minSalary);
            stmt.setDouble(2, maxSalary);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String jobTitle = rs.getString("JobTitle");
                String companyName = rs.getString("CompanyName");
                double salary = rs.getDouble("Salary");
                System.out.println("Job Title: " + jobTitle + ", Company: " + companyName + ", Salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
