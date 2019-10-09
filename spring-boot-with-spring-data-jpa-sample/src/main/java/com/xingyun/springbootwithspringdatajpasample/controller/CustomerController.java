package com.xingyun.springbootwithspringdatajpasample.controller;

import com.xingyun.springbootwithspringdatajpasample.model.AppResponse;
import com.xingyun.springbootwithspringdatajpasample.model.Customer;
import com.xingyun.springbootwithspringdatajpasample.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author 星云
 * @功能
 * @date 9/28/2019 8:25 PM
 */
@Slf4j
@RequestMapping(value = "/customers")
@RestController
public class CustomerController {

    @Autowired
    AppResponse appResponse;

    @Autowired
    CustomerService customerService;

    /**
     * curl -d '' http://127.0.0.1:8080/customers/saveCustomer
     * 保存一个对象
     * @return
     */
    @PostMapping(value = "/saveCustomer")
    public AppResponse saveCustomer(){
        // save a few customers
        customerService.saveCustomer(new Customer("Jack", "Bauer"));
        customerService.saveCustomer(new Customer("Chloe", "O'Brian"));
        customerService.saveCustomer(new Customer("Kim", "Bauer"));
        customerService.saveCustomer(new Customer("David", "Palmer"));
        customerService.saveCustomer(new Customer("Michelle", "Dessert"));

        appResponse.setResponseCode(200);
        appResponse.setResponseMessage("save user finished");
        appResponse.setResponseData(null);
        return appResponse;
    }

    /**
     * 根据Id 查找某个对象
     * curl http://127.0.0.1:8080/customers/1
     * @param id
     */
    @GetMapping(value = "/{id}")
    public AppResponse findCustomerById(@PathVariable(value = "id")Long id){

        // fetch an individual customer by ID
        Optional<Customer> customer=customerService.findCustomerById(id);

        //如果有值不为空
        if(customer.isPresent()){
            log.info("Customer found with findById(1L):");
            log.info("------------start--------------------");
            log.info(customer.toString());
            log.info("------------end--------------------");
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("根据Id 查找某个对象成功");
            appResponse.setResponseData(customer);
        }else{
            appResponse.setResponseCode(401);
            appResponse.setResponseMessage("未找到该对象");
            appResponse.setResponseData(null);
        }
        return appResponse;
    }


    /**
     * 查找所有的对象
     * curl http://127.0.0.1:8080/customers/showCustomerList
     */
    @GetMapping(value = "/showCustomerList")
    public AppResponse showAllCustomer(){

        List<Customer> customerList=customerService.showAllCustomer();
        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (Customer customer : customerList) {
            log.info(customer.toString());
        }

        appResponse.setResponseCode(200);
        appResponse.setResponseMessage("查找所有的对象 finished");
        appResponse.setResponseData(customerList);
        return appResponse;
    }

    /**
     * 根据lastName 查找一个对象
     * curl http://127.0.0.1:8080/customers/findCustomerByLastName?lastName=Bauer
     */
    @GetMapping(value = "/findCustomerByLastName")
    public AppResponse showAllCustomerByLastName(@RequestParam(value = "lastName")String lastName){

        List<Customer> customerList=customerService.findByLastName(lastName);
        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");

        if(null!=customerList){
            //使用lambda表达式
            customerList.forEach(bauer -> {
                log.info(bauer.toString());
            });

            //使用传统的方式遍历
            for (Customer bauer : customerList) {
                log.info(bauer.toString());
            }
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("根据lastName 查找一个对象 finished");
            appResponse.setResponseData(customerList);
        }else{
            appResponse.setResponseCode(401);
            appResponse.setResponseMessage("未找到相关数据");
            appResponse.setResponseData(null);
        }
        return appResponse;
    }

    /**
     * 根据lastName 查找一个对象
     * curl http://127.0.0.1:8080/customers/findCustomerByLastNameWithSQL?lastName=Bauer
     */
    @GetMapping(value = "/findCustomerByLastNameWithSQL")
    public AppResponse findCustomerByLastNameWithSQL(@RequestParam(value = "lastName")String lastName){

        List<Customer> customerList=customerService.findAllCustomerBySQL(lastName);
        // fetch customers by last name
        if(null!=customerList){
            //使用lambda表达式
            customerList.forEach(bauer -> {
                log.info(bauer.toString());
            });
            appResponse.setResponseCode(200);
            appResponse.setResponseMessage("根据lastName 查找一个对象 finished");
            appResponse.setResponseData(customerList);
        }else{
            appResponse.setResponseCode(401);
            appResponse.setResponseMessage("未找到相关数据");
            appResponse.setResponseData(null);
        }
        return appResponse;
    }
}
