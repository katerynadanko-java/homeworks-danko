package lesson07.company;

import com.sun.istack.internal.NotNull;

import java.util.Date;

public class OtherEmployee extends Employee{

    String employeeDescription;

    public String getEmployeeDescription() {
        return employeeDescription;
    }
    public void setEmployeeDescription(@NotNull String employeeDescription) {
        this.employeeDescription = employeeDescription;
    }

    public OtherEmployee(@NotNull String name,
                         @NotNull Date dateOfBirth,
                         @NotNull Date employmentDate,
                         @NotNull String employeeDescription) {

        super(name, dateOfBirth, employmentDate);
        this.employeeDescription = employeeDescription;
    }

    public OtherEmployee(@NotNull String name,
                         @NotNull Date dateOfBirth,
                         @NotNull Date employmentDate,
                         @NotNull String employeeDescription,
                         int workTimeYears) {

        super(name, dateOfBirth, employmentDate,workTimeYears);
        this.employeeDescription = employeeDescription;
    }

    @Override
    public String toString(){
        return "Employee: {\n"+
                "  name: "+getName()+
                "\n  date of birth: "+getDateOfBirth().toString()+
                "\n  employment date: "+getEmploymentDate().toString()+
                "\n  work time in years: "+getWorkTimeYears()+
                "\n  description: "+employeeDescription+
                "\n  position: Other employee"+
                "\n}";
    }

}


