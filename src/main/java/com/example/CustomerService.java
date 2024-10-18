package com.example;

import com.example.Customer;
import com.example.CustomerDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
}
