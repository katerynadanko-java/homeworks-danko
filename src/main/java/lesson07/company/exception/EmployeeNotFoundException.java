package lesson07.company.exception;

import lesson07.company.Employee;

public class EmployeeNotFoundException extends RuntimeException{
    Employee employee;
    public EmployeeNotFoundException(Employee employee){
        this.employee = employee;
    }

    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.println(employee.toString()+"Not found.\n");
    }
}
