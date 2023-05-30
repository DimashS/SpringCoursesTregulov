package spring_introduction;

import org.springframework.context.annotation.*;

@Configuration
// @ComponentScan("spring_introduction")
@PropertySource("classpath:myApplication.properties")
public class MyConfig {

    @Bean // аннтоация говорит, что бин будет вручную
    @Scope("singleton")
    public Pet catBean() { // name of method is Bean Id
        System.out.println("111");
        return new Cat();
    }

    @Bean
    @Scope("prototype")
    public Pet doggyCat() {
        return new Doggy();
    }

    @Bean
    public PersonH personBeanS() {
        return new PersonH(catBean());
    }
}
