package EmployeeManagement.Models;

import EmployeeManagement.Constants.CompanyConstants;

public abstract class Employee {
    public int employeeId;
    int age;
    public String department;
    public String role;
    public String employeeName;
    double salary;
    public String assignedWork;

    public Employee(int employeeId, String employeeName, int age, String department, String role, double salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age =age;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public String getAssignedWork() {
        return assignedWork;
    }

    public void setAssignedWork(String assignedWork) {
        this.assignedWork = assignedWork;
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


