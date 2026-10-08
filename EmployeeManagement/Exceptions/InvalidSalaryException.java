package EmployeeManagement.Exceptions;

import EmployeeManagement.Constants.CompanyConstants;

public class InvalidSalaryException extends Exception{
    double salary;
    public InvalidSalaryException(double salary) {
        this.salary = salary;
    }

    public String toString() {
        if(salary < 0.0) {
            return "Salary cannot be negative.\n";
        }
        return "Minimum salary is " + CompanyConstants.EMPLOYEE_MIN_SALARY;
    }

}
