package dao;

import entity.JobListing;
import util.DBConnUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobListingDAOImpl {

    private Connection connection;

    public JobListingDAOImpl() {
        try {
            this.connection = DBConnUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to establish database connection: " + e.getMessage());
        }
    }

    // Method to add a job listing
    public void addJobListing(JobListing jobListing) {
        String query = "INSERT INTO Job (CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobListing.getCompanyID());
            pstmt.setString(2, jobListing.getJobTitle());
            pstmt.setString(3, jobListing.getJobDescription());
            pstmt.setString(4, jobListing.getJobLocation());
            pstmt.setDouble(5, jobListing.getSalary());
            pstmt.setString(6, jobListing.getJobType());
            pstmt.setDate(7, new Date(jobListing.getPostedDate().getTime()));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job listing added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while adding job listing: " + e.getMessage());
        }
    }

    // Method to retrieve a job listing by job ID
    public JobListing getJobListingById(int jobId) {
        JobListing jobListing = null;
        String query = "SELECT * FROM Job WHERE JobID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    jobListing = new JobListing();
                    jobListing.setJobID(rs.getInt("JobID"));
                    jobListing.setCompanyID(rs.getInt("CompanyID"));
                    jobListing.setJobTitle(rs.getString("JobTitle"));
                    jobListing.setJobDescription(rs.getString("JobDescription"));
                    jobListing.setJobLocation(rs.getString("JobLocation"));
                    jobListing.setSalary(rs.getDouble("Salary"));
                    jobListing.setJobType(rs.getString("JobType"));
                    jobListing.setPostedDate(rs.getDate("PostedDate"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while retrieving job listing: " + e.getMessage());
        }
        return jobListing;
    }

    // Method to retrieve all job listings
    public List<JobListing> getAllJobListings() {
        List<JobListing> jobListings = new ArrayList<>();
        String query = "SELECT * FROM Job";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                JobListing jobListing = new JobListing();
                jobListing.setJobID(rs.getInt("JobID"));
                jobListing.setCompanyID(rs.getInt("CompanyID"));
                jobListing.setJobTitle(rs.getString("JobTitle"));
                jobListing.setJobDescription(rs.getString("JobDescription"));
                jobListing.setJobLocation(rs.getString("JobLocation"));
                jobListing.setSalary(rs.getDouble("Salary"));
                jobListing.setJobType(rs.getString("JobType"));
                jobListing.setPostedDate(rs.getDate("PostedDate"));
                jobListings.add(jobListing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while retrieving all job listings: " + e.getMessage());
        }
        return jobListings;
    }

    // Method to update a job listing
    public void updateJobListing(JobListing jobListing) {
        String query = "UPDATE Job SET CompanyID = ?, JobTitle = ?, JobDescription = ?, JobLocation = ?, Salary = ?, JobType = ?, PostedDate = ? WHERE JobID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobListing.getCompanyID());
            pstmt.setString(2, jobListing.getJobTitle());
            pstmt.setString(3, jobListing.getJobDescription());
            pstmt.setString(4, jobListing.getJobLocation());
            pstmt.setDouble(5, jobListing.getSalary());
            pstmt.setString(6, jobListing.getJobType());
            pstmt.setDate(7, new Date(jobListing.getPostedDate().getTime()));
            pstmt.setInt(8, jobListing.getJobID());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job listing updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while updating job listing: " + e.getMessage());
        }
    }

    // Method to delete a job listing
    public void deleteJobListing(int jobId) {
        String query = "DELETE FROM Job WHERE JobID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, jobId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job listing deleted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while deleting job listing: " + e.getMessage());
        }
    }
}
