package EmployeeManagement.Models;

import EmployeeManagement.Constants.CompanyConstants;

public class Manager extends Employee{

    double bonus;
    int team_size;

    public Manager(int employeeId, String employeeName, int age, String department, double salary, int team_size) {
        super(employeeId, employeeName, age, department, "Manager", salary);
        this.bonus = 0.35 * salary;
        this.team_size = team_size;
    }

    @Override
    public double calculate_salary() {
        this.salary += this.bonus;
        return salary;
    }

    @Override
    public String toString() {
        return "Name of the Organization: "+ CompanyConstants.COMPANY_NAME + "\nID: " + this.employeeId + "\nName: " + this.employeeName + "\nAge: " + this.age
                + "\nDepartment: " + this.department + "\nRole: "+ this.role + "\nTeam Size: "+ this.team_size+"\nSalary: " + calculate_salary();
    }


}
