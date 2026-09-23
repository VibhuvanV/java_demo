package EmployeeManagement.Exceptions;

import EmployeeManagement.Constants.CompanyConstants;

public class InvalidAgeException extends Exception{
    int age;
    public InvalidAgeException(int age) {
        this.age = age;
    }

    public String toString(){
        return "The entered age is not valid according to company rules.Minimum age is " + CompanyConstants.MIN_AGE;
    }
}
