package lesson07.company.exception;

import lesson07.company.Employee;

public class EmployeeWithoutDepartmentException extends RuntimeException{
    Employee employee;

    public EmployeeWithoutDepartmentException(Employee employee){
        this.employee=employee;
    }

    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.println("Employee does not have department:\n"+employee.toString());
    }
}