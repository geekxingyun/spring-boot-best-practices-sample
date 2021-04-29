package com.xingyun.springbootwithrabbitmqsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithRabbitmqSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithRabbitmqSampleApplication.class, args);
        // 如果想启动后就关闭
        //SpringApplication.run(SpringBootWithRabbitmqSampleApplication.class, args).close();
    }

}
