package data;

import model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EntityDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public static void save(Object object){
        // open session
        Session session = sessionFactory.openSession();
        // begin a criteria
        session.beginTransaction();
        //use the session to save the contact
        session.save(object);
        // create list of contact
        session.getTransaction().commit();
        // close the session
        session.close();
    }

    public static Customer fetchCustomerByUsername(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.Customer as c  where c.username= :c_username")
                .setParameter("c_username",username);
        Customer roomReservation = (Customer) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return roomReservation;
    }

}
