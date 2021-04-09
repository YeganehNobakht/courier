package service;

import data.CustomerDao;
import data.EmployeeDao;
import data.NewDeliveryDao;
import data.OrderStatusDao;
import model.Customer;
import model.Employee;
import model.NewDelivery;
import model.OrderStatus;

import java.util.List;

public class Courier {

    public static List<OrderStatus> fetchOrderByEmployee(String id){
        return OrderStatusDao.fetchOrderByEmployeeId(id);
    }
    public static void updateOrderStatus(OrderStatus orderStatus){
        OrderStatusDao.update(orderStatus);
    }
    public static OrderStatus fetchOrderStatusByTrackCode(int trackingCode){
       return OrderStatusDao.fetchOrderByTrackingCode(trackingCode);
    }
    public static void saveToCustomer(String username,String password,String name1,String lastName1,String mail,String mobileNumber,String address){
        Customer customer = new Customer(username,password,name1,lastName1,mail,mobileNumber,address);
        CustomerDao.save(customer);
    }
    public static int generateTrackingCode(NewDelivery newDelivery){
        Integer trackingCode = CustomerDao.getMaxReserveNumber();
        if ( trackingCode!= null) {
            trackingCode = trackingCode+1;
            newDelivery.setTrackingCode(trackingCode);
        } else {
            trackingCode = 10001;
            newDelivery.setTrackingCode(trackingCode);
        }
        return trackingCode;
    }

    public static void saveToEmployee(String username, String password, String name1, String lastName1, String mail, String mobileNumber, String address) {
        Employee employee = new Employee(username,password,name1,lastName1,mail,mobileNumber,address);
        EmployeeDao.save(employee);
    }
    public static int getNumberOfOrder(String username){
        List<OrderStatus> orderStatuses = OrderStatusDao.fetchOrderByCustomerId(username);
        List<NewDelivery> newDeliveries = NewDeliveryDao.fetchOrderByCustomerId(username);
        return orderStatuses.size() + newDeliveries.size();
    }
    public static boolean findDuplicateCustomerEmail(String email){
        if (CustomerDao.fetchCustomerByEmail(email)!=null ){
            return true;
        }else{
            return false;
        }
    }
    public static boolean findDuplicateCustomerUsername(String username){
        if ( CustomerDao.fetchCustomerByUsername(username)!=null){
            return true;
        }else{
            return false;
        }
    }
}
