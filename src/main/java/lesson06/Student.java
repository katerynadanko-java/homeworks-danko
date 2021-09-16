package lesson06;

import java.util.Date;
import java.util.Objects;

public final class Student {
    private final  String name;
    private final int age;
    private final String group;
    private final Date mutableDate;

    private Student(String name, int age, String group, Date date) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.mutableDate = new Date(date.getTime());
    }
    public static Student createStudent(String name, int age, String group, Date date){
        return new Student(name, age, group, date);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public Date getMutableDate() {
        return new Date(mutableDate.getTime());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", mutableDate=" + mutableDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, group);
    }
}
