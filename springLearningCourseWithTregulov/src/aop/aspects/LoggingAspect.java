package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspect {

//    @Pointcut("execution (* aop.UniversityLibrary.*(..))")
//    private void allMethodsFromUniversity(){}

//    @Pointcut("execution (public void aop.UniversityLibrary.returnMagazine())")
//    private void returnMagazineFromUniversityLibrary() {}


//    @Pointcut("allMethodsFromUniversity() && !returnMagazineFromUniversityLibrary()")
//    private void allMethodsExceptReturnMagazineFromUniversity() {}

//    @Before("allMethodsExceptReturnMagazineFromUniversity()")
//    public void beforeMethodsExceptReturnMagazineAdvice() {
//        System.out.println("Logging");
//    }

//    @Pointcut("execution (* aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromAopUniversityLibrary() {
//    }
//
//    @Pointcut("execution (* aop.UniversityLibrary.return*())")
//    private void allReturnMethodsLoggingAdvice() {
//    }

//    @Pointcut("allGetMethodsFromAopUniversityLibrary() || allReturnMethodsLoggingAdvice())")
//    private void allGetAndReturnMethodsFromAopUniversityLibrary() {
//    }

//    @Before("allGetMethodsFromAopUniversityLibrary()")
//    public void beforeGetMethodsLoggingAdvice() {
//        System.out.println("beforeGetMethodsLoggingAdvice: writing Log #1");
//    }


//    @Before("allReturnMethodsLoggingAdvice()")
//    public void beforeReturnMethodsLoggingAdvice() {
//        System.out.println("beforeReturnMethodsLoggingAdvice: writing Log #2");
//    }

//    @Before("allGetAndReturnMethodsFromAopUniversityLibrary()")
//    public void beforeGetAndReturnMethods() {
//        System.out.println("beforeGetAndReturnMethods: writing Log #3");
//    }

//    @Pointcut("execution(* get*())")
//    public void allAddMethods() {
//    }

    @Before("aop.aspects.PointCuts.allAddMethods()")  // перед выполнением метода + это pointcut
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        // Advice - метод в Аспект классе, который определяет, что должно произойти
        // метод опишет, что должно произойти
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());
        if (methodSignature.getName().equals("addBook")) { // checking if method is addBook
            Object[] args = joinPoint.getArgs(); // get array
            for (Object obj : args) { // for each
                if (obj instanceof Book) { // instance of
                    Book myBook = (Book) obj; // down casting
                    System.out.println("Information book: name is " + myBook.getName() + ", author is " + myBook.getAuthor() +
                            ", year of publication " + myBook.getYearOfPublication());
                } else if (obj instanceof String){
                    System.out.println("Book was added by " + obj);
                }
            }
        }
        System.out.println("beforeAddBookAdvice: logging of attempt get book or magazine");
        System.out.println("--------------");
    }


//    @Before("execution(* returnBook())")  // перед выполнением метода + это pointcut
//    public void beforeReturnBookAdvice() {
//        // Advice - метод в Аспект классе, который определяет, что должно произойти
//        // метод опишет, что должно произойти
//        System.out.println("beforeReturnBookAdvice: attempt to return book");
}

