package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class ExceptionHandleAspect {
    @Before("aop.aspects.PointCuts.allAddMethods()")
    public void beforeAddExceptionHandleAdvice() {
        System.out.println("beforeAddExceptionHandleAdvice: catching/handle exception when trying to get book/magazine");
        System.out.println("--------------");
    }
}
