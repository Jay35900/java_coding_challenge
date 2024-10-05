package dao;

import util.DBConnUtil;

import java.sql.*;

public class DatabaseManager {
    private Connection connection;

    // SQL Queries as constants
    private static final String INSERT_JOB_QUERY = "INSERT INTO Job (JobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_JOBS_BY_COMPANY_QUERY = "SELECT * FROM Job WHERE CompanyID = ?";
    private static final String SELECT_JOB_BY_ID_QUERY = "SELECT * FROM Job WHERE JobID = ?";

    public DatabaseManager() {
        try {
            this.connection = DBConnUtil.getConnection();
            if (this.connection != null) {
                System.out.println("Database connection established successfully.");
            } else {
                System.out.println("Failed to establish database connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while establishing the database connection: " + e.getMessage());
        }
    }

    // Updated postJob method
    public void postJob(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocation, double salary, String jobType, Date postedDate) {
        try (PreparedStatement pstmt = connection.prepareStatement(INSERT_JOB_QUERY)) {
            pstmt.setInt(1, jobID);
            pstmt.setInt(2, companyID);
            pstmt.setString(3, jobTitle);
            pstmt.setString(4, jobDescription);
            pstmt.setString(5, jobLocation);
            pstmt.setDouble(6, salary);
            pstmt.setString(7, jobType);
            pstmt.setDate(8, postedDate);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job posted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while posting job: " + e.getMessage());
        }
    }

    public void viewJobsByCompany(int companyId) {
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_JOBS_BY_COMPANY_QUERY)) {
            pstmt.setInt(1, companyId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No jobs found for Company ID: " + companyId);
                } else {
                    while (rs.next()) {
                        System.out.println("Job ID: " + rs.getInt("JobID"));
                        System.out.println("Job Title: " + rs.getString("JobTitle"));
                        System.out.println("Job Description: " + rs.getString("JobDescription"));
                        System.out.println("Job Location: " + rs.getString("JobLocation"));
                        System.out.println("Salary: " + rs.getDouble("Salary"));
                        System.out.println("Job Type: " + rs.getString("JobType"));
                        System.out.println("Posted Date: " + rs.getDate("PostedDate"));
                        System.out.println("----------------------------------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while fetching jobs for company: " + e.getMessage());
        }
    }

    public void viewJobById(int jobId) {
        try (PreparedStatement pstmt = connection.prepareStatement(SELECT_JOB_BY_ID_QUERY)) {
            pstmt.setInt(1, jobId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Job ID: " + rs.getInt("JobID"));
                    System.out.println("Job Title: " + rs.getString("JobTitle"));
                    System.out.println("Job Description: " + rs.getString("JobDescription"));
                    System.out.println("Job Location: " + rs.getString("JobLocation"));
                    System.out.println("Salary: " + rs.getDouble("Salary"));
                    System.out.println("Job Type: " + rs.getString("JobType"));
                    System.out.println("Posted Date: " + rs.getDate("PostedDate"));
                } else {
                    System.out.println("No job found with Job ID: " + jobId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while fetching job: " + e.getMessage());
        }
    }

    // Close the database connection when done
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while closing the database connection: " + e.getMessage());
        }
    }
}
