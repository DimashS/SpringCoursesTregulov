package hibernate_one_to_many_bi;


import hibernate_one_to_many_bi.Entity.Department;
import hibernate_one_to_many_bi.Entity.Employee;
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
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);


            System.out.println("Подгрузим наших работников");
            department.getEmployeeList().get(0);
            session.getTransaction().commit();
            System.out.println("Show employees of the department");
            System.out.println(department.getEmployeeList());

            System.out.println("Done!");

//            session = sessionFactory.getCurrentSession();
//
//            Department department = new Department("IT",1200,300);
//            Employee employee = new Employee("Zaur","Tregulov",800);
//            Employee employee1 = new Employee("Elena","Rybakina",1000);
//
//            department.addEmployeeToDepartment(employee);
//            department.addEmployeeToDepartment(employee1);
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
//            Department department = session.get(Department.class,1);
//            System.out.println(department);
//            System.out.println(department.getEmployeeList());


//            session.getTransaction().commit();
//            System.out.println("Done!");

//********************************************************************

//            session = sessionFactory.getCurrentSession();

//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee + " " + employee.getDepartment());


//            session.getTransaction().commit();
//            System.out.println("Done!");

//********************************************************************

//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}