package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
//        Pet pet = new Cat();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonH person = context.getBean("myPerson", PersonH.class);
        person.callYourPet();
        System.out.println(person.getSurname());
        System.out.println(person.getAge());
        context.close();
    }
}
