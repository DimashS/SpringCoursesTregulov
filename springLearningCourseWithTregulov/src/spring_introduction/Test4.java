package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        Doggy myDoggy = context.getBean("myPet", Doggy.class);
        Doggy yourDoggy = context.getBean("myPet", Doggy.class);

//        myDoggy.setName("Strelka");
//        yourDoggy.setName("Belka");
//
//        System.out.println(yourDoggy.getName());
//        System.out.println(myDoggy.getName());

//        context.close();
//                System.out.println("Переменные ссылаются на один и тот же объект? " +
//                        (myDoggy == yourDoggy));
//                System.out.println(myDoggy);
//                System.out.println(yourDoggy);
    }
}
