package EmployeeManagement.Models;

import EmployeeManagement.Constants.CompanyConstants;

public class Tester extends Employee {
    double tester_bonus;
    public Tester(int employeeId, String employeeName, int age, String department,double salary) {
        super(employeeId, employeeName, age, department, "Tester", salary);
        this.tester_bonus = 0.15 * salary;
    }


    @Override
    public double calculate_salary() {
        this.salary += this.tester_bonus;
        return salary;
    }

    @Override
    public String toString() {
        return "Name of the Organization: "+ CompanyConstants.COMPANY_NAME + "\nID: " + this.employeeId + "\nName: " + this.employeeName + "\nAge: " + this.age
                + "\nDepartment: " + this.department + "\nRole: "+ this.role +"\nSalary: " + calculate_salary();
    }
}
