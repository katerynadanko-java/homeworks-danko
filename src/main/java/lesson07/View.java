package lesson07;

import lesson07.company.Company;
import lesson07.company.Department;
import lesson07.company.Employee;

import java.util.ArrayList;

public class View {
    private static final String COMPANY_NAME_PATTERN = "Company: \"%s\"\n";
    private static final String DEPARTMENT_NAME_PATTERN = "Department \"%s\":\n";
    private static final String EMPLOYEE_SALARY = "  Calculated salary: %d\n";
    private static final String EMPLOYEE_SALARY_WITH_PREMIUM = "  Calculated salary: %d (+premium: %d)\n";

    private static final String DOUBLE_SPACE = "  ";
    private static final String DOUBLE_NEWLINE = "\n\n";

    private static final String MESSAGE_MODE = "Input mode that will be used to calculate salary ( proportional | uniform ): ";

    private static final String CALCULATE_FOR_COMPANY_OR_DEPARTMENTS = "Calculate salary for the whole company or for every department? ( company | department ): ";


    private static final String INPUT_DEPARTMENT_BUDGET = "Input Department salary fund's budget: ";
    private static final String INPUT_COMPANY_BUDGET = "Input Company salary fund's budget: ";

    public void printSalaryForDepartment(Department department, ArrayList<Long> calculatedSalary){
        System.out.printf(DEPARTMENT_NAME_PATTERN,department.getName());

        for (int j=0; j<department.getEmployeeCount();j++){
            Employee e = department.getEmployeeById(j);

            System.out.println(DOUBLE_SPACE+e.toString());

            if (department.getDepartmentSalaryFund().employeeHasPremium(j)) {
                System.out.printf(EMPLOYEE_SALARY_WITH_PREMIUM,
                        calculatedSalary.get(j),
                        (long)(calculatedSalary.get(j)*(department.getDepartmentSalaryFund().getPremiumCoefficient()-1)));
            } else {
                System.out.printf(EMPLOYEE_SALARY, calculatedSalary.get(j));
            }

            printDoubleNewLine();
        }
        System.out.println(DOUBLE_NEWLINE);
    }

    public void printCompanySalary(Company company, ArrayList<Long> calculatedSalary){
        ArrayList<Employee> employees = company.getAllEmployees();

        System.out.printf(COMPANY_NAME_PATTERN,company.getCompanyName());

        for (int i=0; i<calculatedSalary.size();i++){
            System.out.println(DOUBLE_SPACE+employees.get(i).toString());

            if (company.getCompanySalaryFund().employeeHasPremium(i)) {
                System.out.printf(EMPLOYEE_SALARY_WITH_PREMIUM,
                        calculatedSalary.get(i),
                        (long)(calculatedSalary.get(i)*(company.getCompanySalaryFund().getPremiumCoefficient()-1)));
            } else {
                System.out.printf(EMPLOYEE_SALARY, calculatedSalary.get(i));
            }

            printDoubleNewLine();
        }

    }

    public void printCompany(Company company){
        System.out.printf(COMPANY_NAME_PATTERN,company.getCompanyName());

        for (int i=0; i<company.getDepartmentCount(); i++){

            Department department = company.getDepartmentById(i);
            System.out.printf(DEPARTMENT_NAME_PATTERN,department.getName());

            for (int j=0; j<department.getEmployeeCount();j++){
                Employee e = department.getEmployeeById(j);

                System.out.println(DOUBLE_SPACE+e.toString());
            }
            System.out.println(DOUBLE_NEWLINE);
        }
    }

    public void printMessageMode(){
        System.out.println(MESSAGE_MODE);
    }

    public void printCalculateForCompanyOrEveryDepartment(){
        System.out.println(CALCULATE_FOR_COMPANY_OR_DEPARTMENTS);
    }

    public void printDoubleNewLine(){
        System.out.println(DOUBLE_NEWLINE);
    }

    public void printCompanyName(Company company){
        System.out.printf(COMPANY_NAME_PATTERN,company.getCompanyName());
    }

    public void printInputDepartmentBudget(){
        System.out.println(INPUT_DEPARTMENT_BUDGET);
    }

    public void printInputCompanyBudget(){
        System.out.println(INPUT_COMPANY_BUDGET);
    }

    public void printDepartmentName(Department department){
        System.out.printf(DEPARTMENT_NAME_PATTERN,department.getName());
    }

}
