package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        University university = context.getBean("university", University.class);
        university.addStudents();
        try {
            List<Student> studentsList = university.getStudents();
            System.out.println(studentsList);
        } catch (Exception e) {
            System.out.println("Exception was caught " + e);
        }
        context.close();
    }
}
