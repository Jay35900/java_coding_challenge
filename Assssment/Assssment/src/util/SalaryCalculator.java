package util;

import exception.NegativeSalaryException;

public class SalaryCalculator {

    public static double calculateAverageSalary(double[] salaries) throws NegativeSalaryException {
        double total = 0;
        for (double salary : salaries) {
            if (salary < 0) {
                throw new NegativeSalaryException("Negative salary value found: " + salary);
            }
            total += salary;
        }
        return total / salaries.length;
    }

    public static void main(String[] args) {
        double[] salaries = {50000, 70000, -60000}; // Example with a negative salary

        try {
            double averageSalary = calculateAverageSalary(salaries);
            System.out.println("Average Salary: " + averageSalary);
        } catch (NegativeSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}
