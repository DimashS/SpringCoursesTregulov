package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: trying for returning back to Library");
        Object targetMethodResult = null;
        try {
            targetMethodResult = proceedingJoinPoint.proceed(); // result of proceeding is this
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: exception was caught " + e);
            throw e;
        }
        System.out.println("aroundReturnBookLoggingAdvice: successfully returned book to Library");
        return targetMethodResult;
    }
}
