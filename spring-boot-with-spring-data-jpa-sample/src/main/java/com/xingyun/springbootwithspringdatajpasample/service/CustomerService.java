package com.xingyun.springbootwithspringdatajpasample.service;

import com.xingyun.springbootwithspringdatajpasample.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author 技术宅星云
 * @功能
 * @date 9/28/2019 10:16 PM
 */
public interface CustomerService {
    /**
     * 根据lastName 查找多个对象
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);

    /**
     * 根据Id查找一个对象
     * 该接口方法原型是 Optional<T> findById(ID var1); 位于CrudRepository 里的
     * @param id
     * @return
     */
     Optional<Customer> findCustomerById(Long id);

    /**
     * 保存一个对象
     * @param customer
     */
    void saveCustomer(Customer customer);

    /**
     * 查找所有对象
     * @return
     */
    List<Customer> showAllCustomer();

    Page<Customer> showAllCustomerPageList(Pageable pageable);

    /**
     * 根据名字查找对象
     * @param lastName
     * @return
     */
    List<Customer> findAllCustomerBySQL(String lastName);
}
