package spring_introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("ThisIsMyPerson")
public class PersonH {
//    @Autowired
//    @Qualifier ("catBean")
    // подключит сам нужный нам Pet, то есть тот, который тоже будет component.
    // Использует просто pet, для внедрения зависмости
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;


    public PersonH(Pet pet) { // добавление зависимостей
        System.out.println("PersonH bean created");
        this.pet = pet;
    }


//    public PersonH() {
//        System.out.println("PersonH has been created");
//    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("set surname of Class Person");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("set age of Class Person");
        this.age = age;
    }

    // homePet -> setPet
//    @Autowired
//    @Qualifier ("doggy")
    public void setHomePet(Pet Pet) {
        System.out.println("set HomePet for Person constructor");
        this.pet = Pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet");
        pet.say();
    }
}
