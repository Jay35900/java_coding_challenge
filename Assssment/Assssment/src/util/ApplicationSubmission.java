package util;

import exception.ApplicationDeadlineException;

import java.util.Date;

public class ApplicationSubmission {

    public static void submitApplication(Date deadline, Date submissionDate) throws ApplicationDeadlineException {
        if (submissionDate.after(deadline)) {
            throw new ApplicationDeadlineException("Application submission failed. The deadline has passed.");
        }
        System.out.println("Application submitted successfully.");
    }

    public static void main(String[] args) {
        Date deadline = new Date(System.currentTimeMillis() - 10000); // Deadline 10 seconds in the past
        Date submissionDate = new Date();

        try {
            submitApplication(deadline, submissionDate);
        } catch (ApplicationDeadlineException e) {
            System.out.println(e.getMessage());
        }
    }
}
