package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.Entity.Department;
import hibernate_one_to_many_uni.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = sessionFactory.getCurrentSession();
//
//            Department department = new Department("Sales", 700, 1500);
//            Employee employee1 = new Employee("Oleg", "Horoshkin", 800);
//            Employee employee2 = new Employee("Andrey", "Gavrila", 1000);
//            Employee employee3 = new Employee("Anton", "Sidorov", 1200);
//
//            department.addEmployeeToDepartment(employee1);
//            department.addEmployeeToDepartment(employee2);
//            department.addEmployeeToDepartment(employee3);
//
//            session.beginTransaction();
//            session.save(department);
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//********************************************************************
//            session = sessionFactory.getCurrentSession();
//            session.beginTransaction();
//
//            System.out.println("Get department");
//            Department department = session.get(Department.class,4);
//            System.out.println("Show department");
//            System.out.println(department);
//
//
//            session.getTransaction().commit();
//
//            System.out.println("Show employees of the department");
//            System.out.println(department.getEmployeeList());
//            System.out.println("Done!");

//********************************************************************

//            session = sessionFactory.getCurrentSession();

//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee + " " + employee.getDepartment());


//            session.getTransaction().commit();
//            System.out.println("Done!");

//********************************************************************
//
//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 3);
//            session.delete(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}