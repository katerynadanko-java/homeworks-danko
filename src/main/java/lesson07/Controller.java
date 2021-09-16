package lesson07;

import lesson07.company.Department;
import lesson07.salaryCalculator.Mode;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static final String COMPANY = "company";
    private static final String DEPARTMENT = "department";


    private final Model model;
    private final View view;

    public Controller(Model model, View view){
        this.model=model;
        this.view=view;
    }

    public void run(){
        view.printCompany(model.company);

        view.printCalculateForCompanyOrEveryDepartment();

        String companyOrDepartment = inputCompanyOrDepartment();



        if (companyOrDepartment.equals(COMPANY)){
            view.printInputCompanyBudget();
            long budget = inputNumber();
            model.company.getCompanySalaryFund().setFundBudget(budget);

            view.printMessageMode();
            Mode mode = inputModeInaccurate();

            view.printDoubleNewLine();
            view.printDoubleNewLine();

            ArrayList<Long> calculated = model.calculateSalaryForCompany(mode);

            view.printCompanySalary(model.company,calculated);

        } else {
            view.printCompanyName(model.company);

            for (int i=0; i<model.company.getDepartmentCount();i++){
                Department department = model.company.getDepartmentById(i);

                view.printDepartmentName(department);
                view.printInputDepartmentBudget();


                long budget = inputNumber();
                department.getDepartmentSalaryFund().setFundBudget(budget);

                view.printMessageMode();
                Mode mode = inputModeInaccurate();

                view.printDoubleNewLine();


                ArrayList<Long> calculated = department.getDepartmentSalaryFund().calculateSalary(mode);

                view.printSalaryForDepartment(department,calculated);
            }

        }

    }



    public Mode inputModeInaccurate(){
        while (true) {
            String input = inputString();

            for (Mode m: Mode.values()) {
                if (m.name().toLowerCase().contains(input.toLowerCase())) {
                    return m;
                }
            }
        }
    }

    public String inputCompanyOrDepartment(){
        while (true){
            String input = inputString();
            if (input.equalsIgnoreCase(COMPANY) ||
                    input.equalsIgnoreCase(DEPARTMENT)){
                return input;
            }
        }
    }

    public Mode inputMode(){
        while (true) {
            String input = inputString();

            for (Mode m: Mode.values()) {
                if (m.name().equalsIgnoreCase(input)) {
                    return m;
                }
            }
        }
    }

    public String inputString(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNext()){
            sc.next();
        }
        return sc.next();
    }

    public long inputNumber(){
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextLong()){
            sc.nextLong();
        }
        return sc.nextLong();
    }
}
