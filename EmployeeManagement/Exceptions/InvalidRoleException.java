package EmployeeManagement.Exceptions;

public class InvalidRoleException extends Exception{
    String role;

    public InvalidRoleException(String role) {
        this.role = role;
    }

    public String toString() {
        return "Roles are either Developer or Manager or Tester.\n";
    }
}
