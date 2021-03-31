package com.xingyun.springbootwithspringdatajpasample.service;

import com.xingyun.springbootwithspringdatajpasample.dao.jpa.CustomerRepository;
import com.xingyun.springbootwithspringdatajpasample.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 技术宅星云
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
    public Page<Customer> showAllCustomerPageList(Pageable pageable) {
        PageRequest pageRequest=PageRequest.of(pageable.getPageNumber(),pageable.getPageSize());
        return this.customerRepository.findAll(pageRequest);
    }

    @Override
    public List<Customer> findAllCustomerBySQL(String lastName) {
        return customerRepository.findByLastNameBySQL(lastName);
    }
}
