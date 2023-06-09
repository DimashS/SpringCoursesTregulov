package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Doggy myDoggy = context.getBean("myPet",Doggy.class);
        myDoggy.say();
        
        Doggy yourDoggy = context.getBean("myPet",Doggy.class);
        yourDoggy.say();

        context.close();
    }
}
