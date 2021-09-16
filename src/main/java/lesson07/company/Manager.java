package lesson07.company;

import com.sun.istack.internal.NotNull;
import lesson07.company.exception.EmployeeExistsException;
import lesson07.company.exception.EmployeeNotFoundException;
import lesson07.company.exception.NoManagersLeftException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Manager extends Employee{

    private final ArrayList<Employee> subordinateEmployees = new ArrayList<>();

    public Manager(@NotNull String name,
                   @NotNull Date dateOfBirth,
                   @NotNull Date employmentDate,
                   @NotNull Set<Employee> subordinateEmployees) {
        super(name, dateOfBirth, employmentDate);
        this.subordinateEmployees.addAll(subordinateEmployees);
    }

    public Manager(@NotNull String name,
                   @NotNull Date dateOfBirth,
                   @NotNull Date employmentDate,
                   @NotNull Set<Employee> subordinateEmployees,
                   int workTimeYears) {
        super(name, dateOfBirth, employmentDate,workTimeYears);
        this.subordinateEmployees.addAll(subordinateEmployees);
    }


    public Employee downgradeToEmployee(){
        ArrayList<Manager> managers = this.getDepartment().getCompany().getAllManagers();

        if (managers.size()<=1){
            throw new NoManagersLeftException();
        }

        Employee employee = new Employee(this.getName(),this.getDateOfBirth(),
                this.getEmploymentDate());

        this.getDepartment().removeEmployee(this);
        this.getDepartment().addEmployee(employee);

        managers = this.getDepartment().getCompany().getAllManagers();

        int employeesPerManager = (int)Math.ceil((double)getSubordinateEmployeeCount()/managers.size());
        int currentManagerIndex = -1;

        for (int i=0; i<getSubordinateEmployeeCount(); i++){
            if (i%employeesPerManager==0){
                currentManagerIndex++;
            }

            managers.get(currentManagerIndex).addSubordinateEmployee(this.getSubordinateEmployeeById(i));
        }

        return employee;
    }


    public OtherEmployee promoteToOtherEmployee(String employeeDescription){
        Employee e = this.downgradeToEmployee();
        return e.promoteToOtherEmployee(employeeDescription);
    }


    public int getSubordinateEmployeeCount(){
        return subordinateEmployees.size();
    }

    public Employee getSubordinateEmployeeById(int id){
        return subordinateEmployees.get(id);
    }

    public void addSubordinateEmployee(@NotNull Employee employee) throws EmployeeExistsException {
        if (!subordinateEmployees.contains(employee)) {
            subordinateEmployees.add(employee);
        } else {
            throw new EmployeeExistsException(employee);
        }
    }

    public void removeSubordinateEmployee(int index){
        subordinateEmployees.remove(index);
    }

    public void removeSubordinateEmployee(@NotNull Employee employee) throws EmployeeNotFoundException {
        for (int i=0; i<subordinateEmployees.size(); i++){
            Employee e = subordinateEmployees.get(i);
            if (e.equals(employee)){
                subordinateEmployees.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException(employee);
    }

    @Override
    public String toString(){

        StringBuilder sub = new StringBuilder("{ ");
        for (Employee e: subordinateEmployees){
            sub.append(e.getName());
            sub.append(", ");
        }
        sub.append("}");

        return "Employee: {\n"+
                "  name: "+getName()+
                "\n  date of birth: "+getDateOfBirth().toString()+
                "\n  employment date: "+getEmploymentDate().toString()+
                "\n  work time in years: "+getWorkTimeYears()+
                "\n  position: Manager"+
                "\n  subordinate Employees: "+ sub +
                "\n}";
    }

}
