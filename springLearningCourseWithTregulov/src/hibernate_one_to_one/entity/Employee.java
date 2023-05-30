package hibernate_one_to_one.entity;

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
    @Column(name = "department")
    private String department;
    @Column(name = "salary")
    private int salary;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id") // Foreign key => с помощью details id будет ссылка на empDetails
    private Details empDetails;


    public Employee() {
    }

    public Employee(String name, String surname, String department, int salary) {
        this.firstName = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Details getEmpDetails() {
        return empDetails;
    }

    public void setEmpDetails(Details empDetails) {
        this.empDetails = empDetails;
    }
}
