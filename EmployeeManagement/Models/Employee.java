package EmployeeManagement.Models;

import EmployeeManagement.Constants.CompanyConstants;

public abstract class Employee {
    public int employeeId;
    int age;
    String department;
    String role;
    String employeeName;
    double salary;

    public Employee(int employeeId, String employeeName, int age, String department, String role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age =age;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public double calculate_salary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Name of the Organization: "+ CompanyConstants.COMPANY_NAME + "\nID: " + this.employeeId + "\nName: " + this.employeeName + "\nAge: " + this.age
                + "\nDepartment: " + this.department + "\nRole: "+ this.role +"\nSalary: " + this.salary;
    }
}


