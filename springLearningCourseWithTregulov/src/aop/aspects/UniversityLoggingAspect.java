package aop.aspects;

import aop.Student;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsAdvice() {
//        System.out.println("beforeGetStudentsAdvice: logging getting list of students before method getStudents");
//    }

//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students") // returning возвращает под этот
//    // поинткат                                           должны совпадать
//    public void afterReturningStudentsAdvice(List<Student> students) {
//        System.out.println(students.get(0).getNameSurname());
//        Student student1 = students.get(0);
//        String nameSurname = student1.getNameSurname();
//        nameSurname = "Mr." + nameSurname;
//        student1.setNameSurname(nameSurname);
//
//        double avgGrade = student1.getAvgGrade();
//        avgGrade = avgGrade + 1;
//        student1.setAvgGrade(avgGrade);
//        System.out.println("afterReturningStudentsAdvice: logging getting list of students after method getStudents");
//    }
//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingStudentsAdvice(Throwable exception) {
//
//        System.out.println("afterThrowingStudentsAdvice: logging of throwing exception " + exception);
//
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: logging normal end or throwing exception");
    }
}
