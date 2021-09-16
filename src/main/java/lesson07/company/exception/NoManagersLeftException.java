package lesson07.company.exception;

public class NoManagersLeftException extends RuntimeException{
    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.println("Can not downgrade the last manager of the company.");
    }
}
