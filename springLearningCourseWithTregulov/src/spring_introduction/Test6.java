package spring_introduction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test6 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        // config будет представлен данным классом, класс в параметрах будет класс, выступающий конфигурацией с
        // определенными аннотациями
//        PersonH personH = context.getBean("ThisIsMyPerson", PersonH.class);
//        personH.callYourPet();
//        context.close();

//        Pet cat1 = context.getBean("catBean", Pet.class);
//        cat1.say();
//        Pet cat2 = context.getBean("catBean", Pet.class);
//        cat2.say();
        PersonH personH = context.getBean("personBeanS", PersonH.class);
//        PersonH personH1 = context.getBean("personBeanS", PersonH.class);
//        personH.callYourPet();

        System.out.println(personH.getSurname());
        System.out.println(personH.getAge());
        context.close();
    }
}
