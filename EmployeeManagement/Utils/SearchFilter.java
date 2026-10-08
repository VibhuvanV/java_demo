package EmployeeManagement.Utils;

import EmployeeManagement.Models.Employee;
import EmployeeManagement.Service.EmployeeService;

public class SearchFilter {
    EmployeeService e;

    public SearchFilter(EmployeeService e) {
        this.e = e;
    }


    public Employee searchFunction(int id) {
        for(int i=0;i<e.totalEmployees();i++){
            if(e.employeeList[i].employeeId == id) {
                return e.employeeList[i];
            }
        }
        return null;
    }

    public void searchFunction(String name) {

        for(int i=0;i<e.totalEmployees();i++) {
            if(name.trim().equalsIgnoreCase(e.employeeList[i].employeeName)){
                System.out.println(e.employeeList[i]);
            }
        }
    }

    public void searchFunction(int id, String dept) {
        for(int i=0;i<e.totalEmployees();i++) {
            if(dept.trim().equalsIgnoreCase(e.employeeList[i].department)){
                System.out.println(e.employeeList[i]);
            }
        }
    }

}
