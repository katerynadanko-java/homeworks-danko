package lesson07;

import lesson07.company.Company;
import lesson07.company.Department;
import lesson07.company.Employee;
import lesson07.company.Manager;
import lesson07.company.OtherEmployee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;

public class Main {

    private static final String pattern = "dd.MM.yyyy";

    private static Company company;

    public static void init() throws ParseException {

        company = new Company("Five Stars");
        Department d1 = new Department("Department1",company);
        Department d2 = new Department("Department2",company);

        Employee e1 = new Employee(
                "Kateryna",
                new SimpleDateFormat(pattern).parse("10.11.1995"),
                new SimpleDateFormat(pattern).parse("20.06.2019"),
                1
        );
        OtherEmployee e2 = new OtherEmployee(
                "Lena",
                new SimpleDateFormat(pattern).parse("03.08.2005"),
                new SimpleDateFormat(pattern).parse("11.10.2021"),
                "employee",
                10
        );
        Employee e3 = new Employee(
                "Alex",
                new SimpleDateFormat(pattern).parse("02.03.1987"),
                new SimpleDateFormat(pattern).parse("10.04.2015"),
                5
        );
        Employee e4 = new Employee(
                "Laura",
                new SimpleDateFormat(pattern).parse("11.07.2001"),
                new SimpleDateFormat(pattern).parse("10.16.2018"),
                3
        );
        OtherEmployee e5 = new OtherEmployee(
                "Anna",
                new SimpleDateFormat(pattern).parse("30.02.1984"),
                new SimpleDateFormat(pattern).parse("01.0.2018"),
                "very nice",
                2
        );

        HashSet<Employee> subordinates = new HashSet<>();

        subordinates.add(e2);
        subordinates.add(e3);

        Manager m1 = new Manager(
                "Nikolay",
                new SimpleDateFormat(pattern).parse("10.12.2013"),
                new SimpleDateFormat(pattern).parse("20.06.2012"),
                subordinates,
                3);

        HashSet<Employee> e_m2 = new HashSet<>();
        e_m2.add(e4);
        Manager m2 = new Manager(
                "Lev",
                new SimpleDateFormat(pattern).parse("11.06.2013"),
                new SimpleDateFormat(pattern).parse("13.10.2020"),
                e_m2,
                1);

        HashSet<Employee> e_m3 = new HashSet<>();
        e_m3.add(e5);
        Manager m3 = new Manager(
                "Olga",
                new SimpleDateFormat(pattern).parse("13.01.1998"),
                new SimpleDateFormat(pattern).parse("20.03.2021"),
                e_m3,
                3);

        d1.addEmployee(e1);
        d1.addEmployee(e2);
        d1.addEmployee(e3);
        d1.addEmployee(m1);

        d2.addEmployee(e4);
        d2.addEmployee(e5);
        d2.addEmployee(m2);
        d2.addEmployee(m3);

        d1.getDepartmentSalaryFund().setFundBudget(12000);
        d2.getDepartmentSalaryFund().setFundBudget(9000);

        d1.getDepartmentSalaryFund().setMinSalary(1500);
        d2.getDepartmentSalaryFund().setMinSalary(1800);

        company.getCompanySalaryFund().setFundBudget(32000);
        company.getCompanySalaryFund().setMinSalary(1900);

        company.getCompanySalaryFund().setManagerPremiumPerEmployee(700);

    }

    public static void main(String[] args) throws ParseException {
        init();

        Model model = new Model(company);
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.run();
    }
}