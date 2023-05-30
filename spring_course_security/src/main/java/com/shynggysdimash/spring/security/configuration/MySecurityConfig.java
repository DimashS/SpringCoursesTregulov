package com.shynggysdimash.spring.security.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@EnableWebSecurity // клас ответсвенный за spring security config
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        //        UserBuilder userBuilder = User.withDefaultPasswordEncoder(); // default шифрование паролей
//        // при процессе аудентифкиации сравнивай с этими user и паролями
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("shyngys").password("shyngys").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("polina").password("polina").roles("HR"))
//                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"));
    }

    // даем доступ для конкретных ролей с url. ЭТО ЗАЩИТА ОТ ПРОСМОТРА ДРУГИМИ РОЛЯМИ ДРУГИХ АДРЕСОВ
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // для конкретного url конкретная роль
        http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER") // все видят эту страницу;
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info/**").hasRole("MANAGER")
                .and().formLogin().permitAll(); // форма логина и пароля будет запрашиваться у всех
    }
}
