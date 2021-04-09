package model.data;

import model.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManagerDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public static void save(Manager manager){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(manager);
        session.getTransaction().commit();
        session.close();
    }
    public static Manager fetchEmployeeByUsername(String username){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        javax.persistence.Query query  = session.createQuery("from model.Manager as c  where c.username= :c_username")
                .setParameter("c_username",username);
        Manager manager = (Manager) query.getResultList().stream().findFirst().orElse(null);;
        transaction.commit();
        session.close();
        return manager;
    }
}
