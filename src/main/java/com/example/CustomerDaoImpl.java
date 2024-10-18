package com.example;

import com.example.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (fullName, email, socialSecurityNumber) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber());
    }

    @Override
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new Customer(rs.getInt("id"), rs.getString("fullName"), rs.getString("email"), rs.getString("socialSecurityNumber"))
        );
    }

    @Override
    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM Customer";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Customer(rs.getInt("id"), rs.getString("fullName"), rs.getString("email"), rs.getString("socialSecurityNumber"))
        );
    }

    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET fullName = ?, email = ?, socialSecurityNumber = ? WHERE id = ?";
        jdbcTemplate.update(sql, customer.getFullName(), customer.getEmail(), customer.getSocialSecurityNumber(), customer.getId());
    }

    @Override
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
