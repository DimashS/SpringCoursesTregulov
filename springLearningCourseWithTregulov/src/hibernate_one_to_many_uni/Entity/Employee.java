package hibernate_one_to_many_uni.Entity;

import javax.persistence.*;

@Entity
@Table(name = "employees") // с какой таблицой будет связан класс
public class Employee {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Аннотация описывает стратегию по генерации значения Primary K
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String firstName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "salary")
    private int salary;



    public Employee() {
    }

    public Employee(String firstName, String surname, int salary) {
        this.firstName = firstName;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
