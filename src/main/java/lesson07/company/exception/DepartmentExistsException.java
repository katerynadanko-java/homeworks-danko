package lesson07.company.exception;

public class DepartmentExistsException extends RuntimeException{
    String name;
    public DepartmentExistsException(String name){
        this.name = name;
    }
    @Override
    public void printStackTrace(){
        super.printStackTrace();
        System.out.println("Department with name \""+name+"\" Already exists.\n");
    }
}