package lesson07.company;

import com.sun.istack.internal.NotNull;
import lesson07.company.exception.EmployeeWithoutDepartmentException;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class Employee {
    private final String name;
    private final Date dateOfBirth;
    private final Date employmentDate;

    private int workTimeYears = 0;

    private Department department;


    public Employee(@NotNull String name,
                    @NotNull Date dateOfBirth,
                    @NotNull Date employmentDate,
                    int workTimeYears){
        this.name = name;
        this.dateOfBirth=dateOfBirth;
        this.employmentDate=employmentDate;
        this.workTimeYears = workTimeYears;
        if (workTimeYears<0){
            throw new IllegalArgumentException("Work time in years is less than 0.");
        }
    }

    public Employee(@NotNull String name,
                    @NotNull Date dateOfBirth,
                    @NotNull Date employmentDate){
        this.name = name;
        this.dateOfBirth=dateOfBirth;
        this.employmentDate=employmentDate;
    }


    public Manager promoteToManager(@NotNull HashSet<Employee> subordinateEmployees){
        if (this instanceof Manager) {
            return (Manager) this;
        }

        this.department.removeEmployee(this);
        Manager promoted = new Manager(this.name,this.dateOfBirth,
                this.employmentDate,new HashSet<>(subordinateEmployees));
        this.department.addEmployee(promoted);

        return promoted;
    }

    public OtherEmployee promoteToOtherEmployee(String employeeDescription){
        this.department.removeEmployee(this);
        OtherEmployee promoted = new OtherEmployee(getName(),
                getDateOfBirth(),
                getEmploymentDate(),
                employeeDescription);
        this.department.addEmployee(promoted);
        return promoted;
    }


    public Department getDepartment() {
        if (department==null)
            throw new EmployeeWithoutDepartmentException(this);
        return department;
    }


    public void changeDepartment(@NotNull Department department) {
        if (this.department==null){
            this.department = department;
            department.addEmployee(this);
            return;
        }

        this.department.removeEmployee(this);
        this.department = department;
        this.department.addEmployee(this);
    }


    public String getName(){return name;}

    public Date getDateOfBirth(){return dateOfBirth;}

    public Date getEmploymentDate(){return employmentDate;}

    public int getWorkTimeYears() {return workTimeYears;}

    public void setWorkTimeYears(int workTimeYears) {this.workTimeYears = workTimeYears;}

    @Override
    public boolean equals(Object o){
        if (o==null)
            return false;
        if (!(o instanceof Employee))
            return false;
        if (o==this)
            return true;
        if (o.hashCode()!=this.hashCode())
            return false;

        Employee e = (Employee) o;

        return e.getName().equals(name) &
                e.getEmploymentDate().equals(employmentDate) &
                e.getDateOfBirth().equals(dateOfBirth);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,dateOfBirth,employmentDate);
    }

    @Override
    public String toString(){
        return "Employee: {\n"+
                "  name: "+name+
                "\n  date of birth: "+dateOfBirth.toString()+
                "\n  employment date: "+employmentDate.toString()+
                "\n  work time in years: "+workTimeYears+
                "\n  position: Employee"+
                "\n}";
    }

}
