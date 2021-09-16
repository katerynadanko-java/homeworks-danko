package lesson07;

import lesson07.company.Company;
import lesson07.salaryCalculator.Mode;

import java.util.ArrayList;

public class Model {

    public final Company company;

    public Model(Company company){
        this.company = company;
    }

    public ArrayList<Long> calculateSalaryForCompany(Mode mode){

        return company.calculateSalary(mode);
    }

    public ArrayList<ArrayList<Long>> calculateSalaryForDepartments(Mode mode){

        int departmentCount = company.getDepartmentCount();
        ArrayList<ArrayList<Long>> output = new ArrayList<>();

        for (int i=0;i<departmentCount;i++){
            ArrayList<Long> salary = company.getDepartmentById(i).calculateSalary(mode);

            output.add(salary);
        }
        return output;
    }

}