package lesson07.company;

import com.sun.istack.internal.NotNull;
import lesson07.company.comparator.EmploymentDateComparator;
import lesson07.company.comparator.NameComparator;
import lesson07.company.exception.EmployeeExistsException;
import lesson07.company.exception.EmployeeNotFoundException;
import lesson07.company.exception.EmployeeWithoutDepartmentException;
import lesson07.salaryCalculator.Mode;
import lesson07.salaryCalculator.SalaryConstants;
import lesson07.salaryCalculator.SalaryFund;

import java.util.ArrayList;
import java.util.Objects;

public class Department {
    private String name;
    private final ArrayList<Employee> employees;

    private SalaryFund departmentSalaryFund;
    private final Company company;


    public Department(@NotNull String name, @NotNull Company company){
        this.name = name;
        this.employees = new ArrayList<>();
        this.company=company;
        this.company.addDepartment(this);
        createSalaryFund(SalaryConstants.defaultBudget);
    }

    public Department(@NotNull String name,
                      @NotNull Company company,
                      @NotNull ArrayList<Employee> employees,
                      long budget){
        this.name = name;

        for (Employee e : employees)
            e.changeDepartment(this);

        this.employees = employees;
        this.company=company;
        this.company.addDepartment(this);
        createSalaryFund(budget);
    }

    public Company getCompany() {return company;}

    public Employee getEmployeeById(int id){return employees.get(id);}

    public int getEmployeeCount(){return employees.size();}

    public String getName(){return name;}

    public void setName(@NotNull String name){this.name=name;}

    public Employee getEmployeeByName(@NotNull String name){
        for (Employee e : employees) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public void addEmployee(@NotNull Employee employee) throws EmployeeExistsException {
        Department d;
        try {
            d = employee.getDepartment();
        } catch (EmployeeWithoutDepartmentException e){
            d = this;
            employee.changeDepartment(this);
        }

        if (!d.equals(this)) {
            employee.changeDepartment(this);
        }

        if (!employees.contains(employee)) {
            employees.add(employee);
        }
    }

    public void removeEmployee(int index){
        employees.remove(index);
    }

    public void removeEmployee(@NotNull Employee employee) throws EmployeeNotFoundException {
        for (int i=0; i<employees.size(); i++){
            Employee e = employees.get(i);
            if (e.equals(employee)){
                employees.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException(employee);
    }

    public boolean containsEmployee(Employee employee){
        return employees.contains(employee);
    }

    public void createSalaryFund(long budget){
        if (departmentSalaryFund!=null) {
            departmentSalaryFund = new SalaryFund(
                    departmentSalaryFund.getMinSalary(),
                    departmentSalaryFund.getPremiumCoefficient(),
                    departmentSalaryFund.getManagerPremiumPerEmployee(),
                    budget,
                    employees);
        } else {
            departmentSalaryFund = new SalaryFund(employees,budget);
        }
    }

    public void updateSalaryFund(){
        createSalaryFund(departmentSalaryFund.getFundBudget());
    }

    public SalaryFund getDepartmentSalaryFund() {return departmentSalaryFund;}

    public ArrayList<Manager> getAllManagers(){
        ArrayList<Manager> managers = new ArrayList<>();

        for (Employee e: employees){
            if (e instanceof  Manager){
                managers.add((Manager)e);
            }
        }

        return managers;
    }

    public void sortEmployeesByName(){
        employees.sort(new NameComparator());
    }

    public void sortEmployeesByEmploymentDate(){
        employees.sort(new EmploymentDateComparator());
    }

    public ArrayList<Long> calculateSalary(@NotNull Mode mode){
        updateSalaryFund();
        return departmentSalaryFund.calculateSalary(mode);
    }

    @Override
    public boolean equals(Object o){
        if (o==null)
            return false;
        if (!(o instanceof Department))
            return false;
        if (o==this)
            return true;
        if (o.hashCode()!=this.hashCode())
            return false;

        Department e = (Department) o;
        return e.getName().equals(name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
