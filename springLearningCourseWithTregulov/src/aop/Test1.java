package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        UniversityLibrary uniLibrary = context.getBean("universityLibrary", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
        uniLibrary.getBook();
//        System.out.println("--------------");
//        uniLibrary.getMagazine();
        uniLibrary.addBook("Zaur",book);
        uniLibrary.addMagazine();
//        uniLibrary.returnMagazine();
//        System.out.println("--------------");
//        uniLibrary.addBook();

//        uniLibrary.getBook();
//        uniLibrary.returnBook();

//        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
//        schoolLibrary.getBook();

      context.close();
    }
}
