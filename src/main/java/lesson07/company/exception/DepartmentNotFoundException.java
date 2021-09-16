package lesson07.company.exception;

public class DepartmentNotFoundException extends RuntimeException{
    String name;
    public DepartmentNotFoundException(String name){
        this.name = name;
    }
    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.println("Department with name \""+name+"\" Not found.\n");
    }
}