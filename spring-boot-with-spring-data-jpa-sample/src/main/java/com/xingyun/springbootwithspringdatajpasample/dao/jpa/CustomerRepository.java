package com.xingyun.springbootwithspringdatajpasample.dao.jpa;

import com.xingyun.springbootwithspringdatajpasample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    /**
     * 使用原生的SQL进行查询 ?1是占位符
     * @param lastName 查询的名字
     * @return 返回用户
     */
    @Query(value = "select * from T_CUSTOMER u where u.LAST_NAME = ?1",nativeQuery = true)
    List<Customer> findByLastNameBySQL(String lastName);
}