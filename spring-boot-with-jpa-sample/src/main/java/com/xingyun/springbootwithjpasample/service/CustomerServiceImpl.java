package com.xingyun.springbootwithjpasample.service;

import com.xingyun.springbootwithjpasample.dao.jpa.CustomerRepository;
import com.xingyun.springbootwithjpasample.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 星云
 * @功能
 * @date 9/28/2019 10:19 PM
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Optional<Customer> findCustomerById(Long id) {
       return customerRepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> showAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAllCustomerBySQL(String lastName) {
        return customerRepository.findByLastName(lastName);
    }
}
