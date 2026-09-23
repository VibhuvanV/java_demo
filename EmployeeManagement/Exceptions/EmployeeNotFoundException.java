package EmployeeManagement.Exceptions;

public class EmployeeNotFoundException extends Exception{
    int id;

    public EmployeeNotFoundException(int id) {
        this.id = id;
    }

    public String toString() {
        return "Employee id : " + id + " not found.\n";
    }

}
