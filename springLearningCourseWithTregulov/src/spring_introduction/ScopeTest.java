package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        Doggy myDoggy = context.getBean("doggy", Doggy.class);
        myDoggy.say();
//        Doggy yourDoggy = context.getBean("doggy", Doggy.class);
//
//        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDoggy==yourDoggy));
//        System.out.println(myDoggy);
//        System.out.println(yourDoggy);
        context.close();
    }
}
