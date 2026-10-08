package EmployeeManagement.Service;

import EmployeeManagement.Interfaces.Workable;
import EmployeeManagement.Models.Employee;
import EmployeeManagement.Utils.SearchFilter;

public class WorkAssignment implements Workable {

    EmployeeService e;

    public WorkAssignment(EmployeeService e) {
        this.e = e;
    }


    @Override
    public void assignWork(int id, String assignedWork) {

        SearchFilter search = new SearchFilter(e);
        Employee emp = search.searchFunction(id);

        if (emp != null) {
            emp.setAssignedWork(assignedWork);
        }
        else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    @Override
    public void displayWorkInfo(int id) {
        SearchFilter search = new SearchFilter(e);
        Employee emp = search.searchFunction(id);

        if(emp != null){
            StringBuffer sb = new StringBuffer();


            sb.append("\n===== Work Assignment Summary =====\n");
            sb.append("Employee ID : ").append(emp.employeeId).append("\n");
            sb.append("Employee Name : ").append(emp.employeeName).append("\n");
            sb.append("Role : ").append(emp.role).append("\n");
            sb.append("Assigned Work : ").append(emp.getAssignedWork()).append("\n");
            sb.append("Status : Assigned Successfully");

            System.out.println(sb);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

}
