package lesson06;


import java.util.Date;

public class StudentTest {
    public static void main(String[] args) {
        Student student = Student.createStudent("Ann", 21, "StudentsGroup_B", new Date(24));
        System.out.println(student);
        tryModificationStudent(student.getName(), student.getAge(), student.getGroup(), student.getMutableDate());
        System.out.println(student);
    }

    private static void tryModificationStudent(String name, int age, String group, Date date){
         name = "Kate";
         age = 20;
         group = "StudentsGroup_A";
         date.setTime(10);
    }



}