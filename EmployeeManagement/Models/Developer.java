package EmployeeManagement.Models;

import EmployeeManagement.Constants.CompanyConstants;

public class Developer extends Employee{

    double project_bonus;
    String programming_language;


    public Developer(int employeeId, String employeeName, int age, String department, double salary, String programming_language) {
        super(employeeId, employeeName, age, department,"Developer", salary);
        project_bonus = 0.2 * salary;
        this.programming_language = programming_language;

    }


    @Override
    public double calculate_salary() {
        this.salary += this.project_bonus;
        return salary;
    }

    @Override
    public String toString() {
        return "Name of the Organization: "+ CompanyConstants.COMPANY_NAME + "\nID: " + this.employeeId + "\nName: " + this.employeeName + "\nAge: " + this.age
                + "\nDepartment: " + this.department + "\nRole: "+ this.programming_language + " " + this.role +"\nSalary: " + calculate_salary();
    }


}
