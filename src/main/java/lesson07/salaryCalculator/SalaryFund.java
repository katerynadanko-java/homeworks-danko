package lesson07.salaryCalculator;

import com.sun.istack.internal.NotNull;
import lesson07.company.Employee;
import lesson07.company.Manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SalaryFund {

    private long minSalary;
    private float premiumCoefficient;
    private long managerPremiumPerEmployee;
    private long fundBudget;
    private final ArrayList<Employee> employees;

    public SalaryFund(long minSalary, float premiumCoefficient, long managerPremiumPerEmployee,
                      long fundBudget, ArrayList<Employee> employees){

        if (minSalary * (long)employees.size()>fundBudget){
            throw new IllegalArgumentException("Salary fund's budget is not enough to pay minimum salary to all employees in department.");
        }

        if (premiumCoefficient <=1.0f){
            throw new IllegalArgumentException("Premium coefficient is less or equal to 1");
        }

        this.minSalary = minSalary;
        this.premiumCoefficient = premiumCoefficient;
        this.managerPremiumPerEmployee=managerPremiumPerEmployee;
        this.employees = employees;
        this.fundBudget = fundBudget;
    }

    public SalaryFund(ArrayList<Employee> employees,long fundBudget){

        this.minSalary = SalaryConstants.defaultMinSalary;
        this.premiumCoefficient = SalaryConstants.premiumCoeff;
        this.managerPremiumPerEmployee = SalaryConstants.managerPremiumPerEmployee;

        if (minSalary * (long)employees.size()>fundBudget){
            throw new IllegalArgumentException("Salary fund's budget is not enough to pay minimum salary to all employees in department.");
        }

        this.employees = employees;
        this.fundBudget = fundBudget;
    }

    public Employee getEmployeeById(int id){return employees.get(id);}

    public int getEmployeeCount(){return employees.size();}

    public long getMinSalary(){return minSalary;}

    public void setMinSalary(long minSalary){this.minSalary=minSalary;}

    public long getFundBudget(){return fundBudget;}

    public long getManagerPremiumPerEmployee() {return managerPremiumPerEmployee;}

    public void setManagerPremiumPerEmployee(long managerPremiumPerEmployee) {this.managerPremiumPerEmployee = managerPremiumPerEmployee;}

    public float getPremiumCoefficient() {return premiumCoefficient;}

    public void setPremiumCoefficient(float coeff){
        if (coeff<=1.0f){
            throw new IllegalArgumentException("Premium coefficient is less or equal to 1");
        }
        premiumCoefficient =coeff;
    }

    public boolean employeeHasPremium(int index){
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        int month = calendar.get(Calendar.MONTH);

        calendar.setTime(employees.get(index).getDateOfBirth());

        return month == calendar.get(Calendar.MONTH);
    }

    public void setFundBudget(long fundBudget){
        this.fundBudget=fundBudget;
    }

    public ArrayList<Long> calculateSalary(@NotNull Mode mode){

        ArrayList<Long> salaryList = new ArrayList<>();

        long sum = 0L;

        if (mode==Mode.PROPORTIONAL){
            int employeeWorkYearsSum=0;
            for (Employee employee : employees) {
                employeeWorkYearsSum += employee.getWorkTimeYears();
            }

            long proportion = fundBudget- minSalary *employees.size();

            if (employeeWorkYearsSum!=0){
                proportion = (fundBudget- minSalary *employees.size())/employeeWorkYearsSum;
            }



            for (Employee e : employees) {
                //int month = calendar.get(Calendar.MONTH);

                //calendar.setTime(e.getDateOfBirth());

                long salary = (minSalary + e.getWorkTimeYears() * proportion);
                /*
                if (month == calendar.get(Calendar.MONTH)) {
                    salary = ((long) ((minSalary + e.getWorkTimeYears() * proportion) * SalaryConstants.premiumCoeff));
                } else {
                    salary = (minSalary + e.getWorkTimeYears() * proportion);
                }
                 */

                if (e instanceof Manager){
                    Manager m = (Manager)e;
                    salary += m.getSubordinateEmployeeCount()*managerPremiumPerEmployee;
                }

                sum+=salary;

                salaryList.add(salary);

                //calendar.setTime(currentDate);
            }

        } else if (mode==Mode.UNIFORM_DISTRIBUTION){

            long uniform = (fundBudget- minSalary *employees.size())/employees.size();

            for (Employee e : employees) {
                //int month = calendar.get(Calendar.MONTH);

                //calendar.setTime(e.getDateOfBirth());

                long salary = (minSalary + uniform);

                /*if (month == calendar.get(Calendar.MONTH)) {
                    salary = ((long) ((minSalary + uniform) * SalaryConstants.premiumCoeff));
                } else {
                    salary = (minSalary + uniform);
                }
                 */

                if (e instanceof Manager){
                    Manager m = (Manager)e;
                    salary += m.getSubordinateEmployeeCount()*managerPremiumPerEmployee;
                }

                sum+=salary;

                salaryList.add(salary);

                //calendar.setTime(currentDate);
            }
        }

        if (sum>fundBudget){
            double c = (double)fundBudget/sum;
            for (int i=0; i<salaryList.size(); i++){
                salaryList.set(i,(long)(salaryList.get(i)*c));

            }
        }

        return salaryList;
    }


}