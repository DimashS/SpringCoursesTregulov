package hibernate_one_to_one;


import hibernate_one_to_one.entity.Details;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class).addAnnotatedClass(Details.class)
                .buildSessionFactory();
        Session session = null;
        try {
//            session = sessionFactory.getCurrentSession();
//            Employee employee = new Employee("Nikolaj", "Schdwes", "HR", 500);
//            Details details = new Details("Serbia", "21321321", "nikolaiwork@gmail.com");
//
//            employee.setEmpDetails(details);
//            details.setEmployee(employee);
//
//            session.beginTransaction();
//            session.save(details);
//
//
//            session.getTransaction().commit();
//            System.out.println("Done!");


//            session = sessionFactory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Details details = session.get(Details.class,4);
//            System.out.println(details.getEmployee());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

            session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Details details = session.get(Details.class,1);
//            details.getEmployee().setEmpDetails(null);
            session.delete(details);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}