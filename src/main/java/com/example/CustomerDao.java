package com.example;

import com.example.Customer;
import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);
    Customer getCustomerById(int id);
    List<Customer> getAllCustomers();
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}



