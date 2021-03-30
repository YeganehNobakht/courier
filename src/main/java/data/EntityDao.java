package data;

import model.Customer;
import model.NewDelivery;
import model.OrderStates;
import model.OrderStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    public static OrderStatus fetchOrderByTrackingCode(int trackCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.OrderStatus as c  where c.trackingCode= :c_trackingCode")
                .setParameter("c_trackingCode",trackCode);

        OrderStatus roomReservation = (OrderStatus) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return roomReservation;
    }
}
