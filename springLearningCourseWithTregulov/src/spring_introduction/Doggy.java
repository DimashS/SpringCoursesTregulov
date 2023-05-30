package spring_introduction;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class Doggy implements Pet {
    private String name;

    //    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }


//    @PostConstruct
//    public void initializationMethod() {
//        System.out.println("Class Dog: init method");
//    }
//
//    @PreDestroy
//    public void destroyMethod() {
//        System.out.println("Class Dog: destroy method");
//    }

    public Doggy() {
        System.out.println("Doggy has been created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }
}
