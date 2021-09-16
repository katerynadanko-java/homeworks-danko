package lesson07.company.comparator;

import lesson07.company.Employee;

import java.util.Comparator;

public class EmploymentDateComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        return e2.getEmploymentDate().compareTo(e1.getEmploymentDate());
    }
}
