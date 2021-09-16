package lesson07.company;

import com.sun.istack.internal.NotNull;
import lesson07.company.comparator.EmploymentDateComparator;
import lesson07.company.comparator.NameComparator;
import lesson07.company.exception.DepartmentExistsException;
import lesson07.company.exception.DepartmentNotFoundException;
import lesson07.salaryCalculator.Mode;
import lesson07.salaryCalculator.SalaryConstants;
import lesson07.salaryCalculator.SalaryFund;

import java.util.ArrayList;
import java.util.Set;

public class Company {
    private final ArrayList<Department> departments = new ArrayList<>();

    private SalaryFund companySalaryFund;

    private final String companyName;

    public Company(@NotNull String companyName){
        this.companyName = companyName;
        createSalaryFund(SalaryConstants.defaultBudget);
    }

    public void addDepartments(Set<Department> departments){
        this.departments.addAll(departments);
    }

    public void createSalaryFund(long budget){
        long allDepartmentsBudget = 0L;

        ArrayList<Employee> allEmployees = getAllEmployees();

        if (companySalaryFund!=null) {
            companySalaryFund = new SalaryFund(
                    companySalaryFund.getMinSalary(),
                    companySalaryFund.getPremiumCoefficient(),
                    companySalaryFund.getManagerPremiumPerEmployee(),
                    budget,
                    allEmployees);
        } else {
            companySalaryFund = new SalaryFund(allEmployees,budget);
        }

        if (allDepartmentsBudget>companySalaryFund.getFundBudget()){
            companySalaryFund.setFundBudget(allDepartmentsBudget);
        }
    }

    public void updateSalaryFund(){
        createSalaryFund(companySalaryFund.getFundBudget());
    }

    public ArrayList<Manager> getAllManagers(){
        ArrayList<Manager> managers = new ArrayList<>();

        for (Department d: departments){
            managers.addAll(d.getAllManagers());
        }

        return managers;
    }

    public Department getDepartmentById(int id){return departments.get(id);}

    public Department getDepartmentByName(@NotNull String name) throws DepartmentNotFoundException {
        for (Department d : departments) {
            if (d.getName().equals(name)) {
                return d;
            }
        }
        throw new DepartmentNotFoundException(name);
    }

    public void addDepartment(@NotNull Department department) {
        for (Department d: departments){
            if (d.equals(department)){
                throw new DepartmentExistsException(department.getName());
            }
        }
        departments.add(department);
    }

    public int getDepartmentCount(){return departments.size();}

    public void removeDepartment(int index){
        departments.remove(index);
    }

    public void removeDepartment(@NotNull String name) throws DepartmentNotFoundException{
        for (int i=0; i<departments.size(); i++){
            Department d = departments.get(i);
            if (d.getName().equals(name)){
                departments.remove(i);
                return;
            }
        }
        throw new DepartmentNotFoundException(name);
    }

    public String getCompanyName(){return companyName;}

    public SalaryFund getCompanySalaryFund() {return companySalaryFund;}

    public int getEmployeeCount(){return companySalaryFund.getEmployeeCount();}

    public Employee getEmployeeById(int id){return companySalaryFund.getEmployeeById(id);}

    public ArrayList<Long> calculateSalary(@NotNull Mode mode){
        updateSalaryFund();
        return companySalaryFund.calculateSalary(mode);
    }

    public ArrayList<Employee> getAllEmployees(){
        ArrayList<Employee> all = new ArrayList<>();

        for (Department d: departments){
            for (int i=0;i<d.getEmployeeCount();i++){
                all.add(d.getEmployeeById(i));
            }
        }
        return all;
    }

    public ArrayList<Employee> sortEmployeesByName(){
        ArrayList <Employee> sorted = getAllEmployees();
        sorted.sort(new NameComparator());
        return sorted;
    }


    public ArrayList<Employee> sortEmployeesByEmploymentDate(){
        ArrayList <Employee> sorted = getAllEmployees();
        sorted.sort(new EmploymentDateComparator());
        return sorted;
    }

}
