package aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {
    private List<Student> students = new ArrayList<>();

    public void addStudents() {
        Student student1 = new Student("Dinmukhammed Shynggys", 3, 2.9);
        Student student2 = new Student("Adilkhan Dombyra", 3, 2.8);
        Student student3 = new Student("Abdrahman Rakhmonov", 3, 2.5);
        students.add(student1);
        students.add(student2);
        students.add(student3);
    }

    public List<Student> getStudents() {
        System.out.println("Beginning of working of method getStudents");
//        System.out.println(students.get(3));
        System.out.println("Information from method getStudents: ");
        System.out.println(students);
        return students;
    }
}
