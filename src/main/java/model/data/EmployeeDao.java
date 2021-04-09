package model.data;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao {
    private static SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
    public static void save(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
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
    public static List<Employee> getAllRecords(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        criteriaQuery.select(root);
        Query<Employee> query = session.createQuery(criteriaQuery);
        List<Employee> weatherModelList = query.getResultList();
        return weatherModelList;
    }
}
