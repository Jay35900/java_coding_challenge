package main;

import dao.DatabaseManager;

import java.sql.Date;
import java.util.Scanner;

public class MainModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DatabaseManager dbManager = new DatabaseManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Post a Job");
            System.out.println("2. View Jobs by Company");
            System.out.println("3. View Job by ID");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Code to post a job
                    System.out.println("Enter Job ID: ");
                    int jobID = scanner.nextInt();
                    System.out.println("Enter Company ID: ");
                    int companyID = scanner.nextInt();
                    scanner.nextLine();  // Consume newline left-over

                    System.out.println("Enter Job Title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.println("Enter Job Description: ");
                    String jobDescription = scanner.nextLine();
                    System.out.println("Enter Job Location: ");
                    String jobLocation = scanner.nextLine();
                    System.out.println("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.println("Enter Job Type (Full-time/Part-time): ");
                    String jobType = scanner.nextLine();
                    System.out.println("Enter Job Posting Date (yyyy-mm-dd): ");
                    String dateStr = scanner.nextLine();
                    Date postedDate = Date.valueOf(dateStr);  // Convert string to Date

                    dbManager.postJob(jobID, companyID, jobTitle, jobDescription, jobLocation, salary, jobType, postedDate);
                    break;
                case 2:
                    // Code to view jobs by company
                    System.out.println("Enter Company ID: ");
                    int companyId = scanner.nextInt();
                    dbManager.viewJobsByCompany(companyId);
                    break;
                case 3:
                    // Code to view a job by ID
                    System.out.println("Enter Job ID: ");
                    int jobId = scanner.nextInt();
                    dbManager.viewJobById(jobId);
                    break;
                case 4:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        dbManager.closeConnection();  // Close connection when done
        scanner.close();
    }
}
