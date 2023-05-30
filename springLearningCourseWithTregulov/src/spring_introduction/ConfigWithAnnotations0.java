package spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigWithAnnotations0 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext3.xml");
        PersonH personH = context.getBean("ThisIsMyPerson", PersonH.class);
        personH.callYourPet();
        System.out.println(personH.getSurname() + " : " + personH.getAge());
//        Cat cat = context.getBean("catBean", Cat.class);
//        cat.say();
        context.close();
    }
}
