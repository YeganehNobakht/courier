package data;

import model.Customer;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public static void save(Employee employee){
        // open session
        Session session = sessionFactory.openSession();
        // begin a criteria
        session.beginTransaction();
        //use the session to save the contact
        session.save(employee);
        // create list of contact
        session.getTransaction().commit();
        // close the session
        session.close();
    }
    public static Employee fetchEmployeeByUsername(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.Employee as c  where c.username= :c_username")
                .setParameter("c_username",username);
        Employee employee = (Employee) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return employee;
    }
}
