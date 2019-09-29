package com.xingyun.springbootwithjpasample.dao.jpa;

import com.xingyun.springbootwithjpasample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 星云
 * @功能
 * @date 9/28/2019 8:22 PM
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * 根据lastName 查找多个对象
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);
}
