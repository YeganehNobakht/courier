package data;

import model.OrderStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderStatusDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public static OrderStatus fetchOrderByTrackingCode(int trackCode){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.OrderStatus as c  where c.orderId= :c_orderId")
                .setParameter("c_orderId",trackCode);

        OrderStatus orderStatus = (OrderStatus) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return orderStatus;
    }
    public static int  update(OrderStatus orderStatus){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query = session.createQuery(
                "update model.OrderStatus as c set c.acceptDate = :c_acceptDate,c.orderStates = :c_orderStates, c.employeeId = :c_employeeId, c.sendingDate = :c_sendingDate, c.deliverDate = :c_deliverDate where c.orderId = :c_orderId")
                .setParameter("c_acceptDate", orderStatus.getAcceptDate())
                .setParameter("c_orderStates", orderStatus.getOrderStates())
                .setParameter("c_employeeId", orderStatus.getEmployeeId())
                .setParameter("c_sendingDate", orderStatus.getSendingDate())
                .setParameter("c_deliverDate", orderStatus.getDeliverDate())
                .setParameter("c_orderId", orderStatus.getOrderId());
        int countUpdate = query.executeUpdate();
        transaction.commit();
        session.close();
        return countUpdate;
    }

    public static List<OrderStatus> fetchOrderByEmployeeId(String employeeId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.OrderStatus as c  where c.employeeId= :c_employeeId")
                .setParameter("c_employeeId",employeeId);

        List<OrderStatus> orderStatus =  query.getResultList();
        transaction.commit();
        session.close();
        return orderStatus;
    }
}
