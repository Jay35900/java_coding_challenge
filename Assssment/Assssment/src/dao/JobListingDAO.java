package dao;

import entity.JobListing;
import java.util.List;

public interface JobListingDAO {
    // Method to post a new job
    void postJob(JobListing job);

    // Method to retrieve jobs by company ID
    List<JobListing> getJobsByCompany(int companyID);

    // Method to retrieve a job by its ID
    JobListing getJobById(int jobID);

    // Method to retrieve all job listings
    List<JobListing> getAllJobs();

    // Method to update an existing job listing
    void updateJob(JobListing job);

    // Method to delete a job listing by its ID
    void deleteJob(int jobID);
}
