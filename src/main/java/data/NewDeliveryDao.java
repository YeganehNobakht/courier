package data;

import model.NewDelivery;
import model.OrderStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class NewDeliveryDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public static List<NewDelivery> getAllRecords(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<NewDelivery> criteriaQuery = criteriaBuilder.createQuery(NewDelivery.class);
        Root<NewDelivery> root = criteriaQuery.from(NewDelivery.class);
        criteriaQuery.select(root);
        Query<NewDelivery> query = session.createQuery(criteriaQuery);
        List<NewDelivery> weatherModelList = query.getResultList();
        return weatherModelList;
    }
    public static int  delete(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query = session.createQuery(
                "delete model.NewDelivery as c where c.trackingCode = :c_trackingCode")
                .setParameter("c_trackingCode", id);
        int countUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        return countUpdate;
    }
    public static List<NewDelivery> fetchOrderByCustomerId(String customerId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.NewDelivery as c  where c.customerUsername= :c_customerUsername")
                .setParameter("c_customerUsername",customerId);

        List<NewDelivery> orderStatus =  query.getResultList();
        transaction.commit();
        session.close();
        return orderStatus;
    }
}
