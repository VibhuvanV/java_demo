package EmployeeManagement.Service;

import EmployeeManagement.Constants.CompanyConstants;
import EmployeeManagement.Models.Developer;
import EmployeeManagement.Models.Employee;
import EmployeeManagement.Models.Manager;
import EmployeeManagement.Models.Tester;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeService {
    Employee[] employeeList = new Employee[CompanyConstants.EMPLOYEE_SIZE];
    Scanner scanner = new Scanner(System.in);
    public static int count = 0;
    public void addEmployee(int id , String name , int age , String dept,String role,  double sal) {
        if(role.trim().equalsIgnoreCase("developer")) {
            System.out.print("Enter developer's programming Language (Ex: Java , SpringBoot , C++ etc): ");
            String lang = scanner.nextLine();
            Developer d = new Developer(id, name, age, dept, sal, lang);
            employeeList[EmployeeService.count] = d;
            EmployeeService.count++;
        } else if(role.trim().equalsIgnoreCase("tester")) {
            Tester t = new Tester(id , name ,age, dept, sal);
            employeeList[EmployeeService.count] = t;
            EmployeeService.count++;
        } else if(role.trim().equalsIgnoreCase("manager")) {
            System.out.print("Enter the Team Size: ");
            int team_size = scanner.nextInt();
            scanner.nextLine();
            Manager m = new Manager(id,name, age, dept, sal, team_size);
            employeeList[EmployeeService.count] = m;
            EmployeeService.count++;
        }
        System.out.println("Employee Details are Added.");
    }

    public void displayEmployeeDetails() {
        for(int i=0;i<count;i++) {
            System.out.println(employeeList[i]);
            System.out.println("=========================================");
        }
    }

    public Employee searchEmployeeById(int empId){
        for(int i=0;i<count;i++) {
            if(employeeList[i].employeeId == empId) {
                return employeeList[i];
            }
        }

        return null;
    }

    public int totalEmployees(){
        return EmployeeService.count;
    }


}
