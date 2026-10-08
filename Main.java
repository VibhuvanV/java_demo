import EmployeeManagement.Constants.CompanyConstants;
import EmployeeManagement.Exceptions.InvalidAgeException;
import EmployeeManagement.Exceptions.InvalidRoleException;
import EmployeeManagement.Exceptions.InvalidSalaryException;
import EmployeeManagement.Models.Employee;
import EmployeeManagement.Service.EmployeeService;
import EmployeeManagement.Service.WorkAssignment;
import EmployeeManagement.Utils.SearchFilter;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.out;

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
            out.println("1. Add Employee\n" +
                    "2.Display Employee Details\n" +
                    "3.Search Employee By Id\n" +
                    "4.Total Employees in " + CompanyConstants.COMPANY_NAME+"\n" +
                    "5. Work Assigned Summary\n" +
                    "0.Exit\n");
            out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 0 : break;
                case 1:
                    try{
                        out.println("Enter the Employee details");
                        out.print("Enter the Id: ");
                        id = scanner.nextInt();
                        scanner.nextLine();   // consume \n

                        out.print("Enter Employee Name: ");
                        name = scanner.nextLine();

                        out.print("Enter Employee Age: ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        if(age < 0 || age < CompanyConstants.MIN_AGE) {
                            throw new InvalidAgeException(age);
                        }

                        out.print("Enter Department Alloted: ");
                        dept = scanner.nextLine();

                        out.print("Enter the Role of Employee: ");
                        role = scanner.nextLine();
                        if (!role.equalsIgnoreCase("developer") && !role.equalsIgnoreCase("tester") && !role.equalsIgnoreCase("manager")) {
                            throw new InvalidRoleException(role);
                        }
                        salary = scanner.nextDouble();
                        if(salary < 0.0 || salary < CompanyConstants.EMPLOYEE_MIN_SALARY) {
                            throw new InvalidSalaryException(salary);
                        }

                        empService.addEmployee(id , name , age , dept, role, salary);
                    } catch(InvalidAgeException | InvalidSalaryException e){
                        System.out.println(e);
                    } catch(NullPointerException e) {
                        e.printStackTrace();
                    } catch (InvalidRoleException e) {
                        throw new RuntimeException(e);
                    } finally {
                        System.out.println("Employee registration Completed.");
                    }

                break;
                case 2:
                    empService.displayEmployeeDetails();;
                break;
                case 3:
                    out.print("1.Search by Id"+ "\n2. Search by name" + "\n3. Search by department" + "\nEnter mode of Search: ");
                    int ch = scanner.nextInt();
                    scanner.nextLine();

                    SearchFilter search = new SearchFilter(empService);
                    if(ch == 1) {
                        System.out.println("Enter Id of Employee to Search: ");
                        id = scanner.nextInt();
                        scanner.nextLine();
                        Employee e = search.searchFunction(id);
                        if (e == null) {
                            System.out.println("Employee with given id " + id + "not found.");
                        } else {
                            System.out.println(e);
                        }
                    } else if(ch == 2) {
                        System.out.println("Enter Name of Employee to Search: ");
                        name = scanner.nextLine();
                        search.searchFunction(name);
                    } else {
                        System.out.println("Enter Department of Employee to Search: ");
                        dept = scanner.nextLine();
                        search.searchFunction(1, dept);
                    }
                break;
                case 4:
                    out.println(empService.totalEmployees());
                break;
                case 5:
                    WorkAssignment wa = new WorkAssignment(empService);
                    System.out.print("Enter the employee id : ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Update the work status of the employee : ");
                    String assignedWork = scanner.nextLine();
                    wa.assignWork(id, assignedWork);
                break;
                case 6:
                    wa = new WorkAssignment(empService);
                    System.out.print("Enter the employee id : ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    wa.displayWorkInfo(id);
                break;
                default: System.out.println("Invalid choice please enter again.");
            }
        } while(choice != 0);

    }
}