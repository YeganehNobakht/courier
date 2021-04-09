package model.data;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerDao {
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
        Customer customer = (Customer) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return customer;
    }
    public static Customer fetchCustomerByEmail(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.Customer as c  where c.email = :c_email")
                .setParameter("c_email",username);
        Customer customer = (Customer) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return customer;
    }
    public static Integer getMaxReserveNumber(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder =session.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Object.class);
        Root<NewDelivery> root = criteriaQuery.from(NewDelivery.class);
        criteriaQuery.select(criteriaBuilder.max(root.get("trackingCode")));
        Query query =session.createQuery(criteriaQuery);
        Integer trackingCode = (Integer) query.getSingleResult();
        session.close();
        return trackingCode;
    }
    public static List<Customer> getAllRecords(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        Query<Customer> query = session.createQuery(criteriaQuery);
        List<Customer> weatherModelList = query.getResultList();
        return weatherModelList;
    }

}
