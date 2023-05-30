package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Main starts");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UniversityLibrary universityLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        String bookName = universityLibrary.returnBook();
        System.out.println("Book was returned in library " + bookName);
        context.close();
        System.out.println("Main ends");
    }
}
