import EmployeeManagement.Constants.CompanyConstants;
import EmployeeManagement.Models.Employee;
import EmployeeManagement.Service.EmployeeService;

import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner (System.in);
        int id , age;
        String dept , name, role;
        double salary;


        EmployeeService empService = new EmployeeService();


        int choice;
        do{
            System.out.println("1. Add Employee\n" +
                    "2.Display Employee Details\n" +
                    "3.Search Employee By Id\n" +
                    "4.Total Employees in " + CompanyConstants.COMPANY_NAME+"\n" +
                    "0.Exit\n");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0 : break;
                case 1:
                    System.out.println("Enter the Employee details");
                    System.out.print("Enter the Id: ");
                    id = scanner.nextInt();
                    scanner.nextLine();   // consume \n

                    System.out.print("Enter Employee Name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter Employee Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Department Alloted: ");
                    dept = scanner.nextLine();

                    System.out.print("Enter the Role of Employee: ");
                    role = scanner.nextLine();

                    System.out.print("Enter the salary of Employee: ");
                    salary = scanner.nextDouble();

                    empService.addEmployee(id , name , age , dept, role, salary);
                break;
                case 2:
                    empService.displayEmployeeDetails();;
                break;
                case 3:
                    System.out.println("Enter the Id of an Employee to search: ");
                    int search_id = scanner.nextInt();
                    Employee e = null;
                    if((e = empService.searchEmployeeById(search_id)) != null) {
                        System.out.println(e);
                    } else{
                        System.out.println("Employee with Id " + search_id + " not found.");
                    }
                break;
                case 4:
                    System.out.println(empService.totalEmployees());
                break;
                default: System.out.println("Invalid choice please enter again.");
            }
        } while(choice != 0);

    }
}