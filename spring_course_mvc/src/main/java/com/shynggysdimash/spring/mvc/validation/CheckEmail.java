package com.shynggysdimash.spring.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
// что инф о нашей аннотации сохранится вплоть до RunTime.
// Аннотация будет сохраняться вплоть до выполнения кода
@Constraint(validatedBy = CheckEmailValidator.class)
public @interface CheckEmail {

    // 2 поля
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    public Class<?>[] groups() default {};
    public Class<? extends Payload> [] payload() default {};


}
