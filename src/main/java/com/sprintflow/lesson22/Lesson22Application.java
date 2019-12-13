package com.sprintflow.lesson22;

import com.sprintflow.lesson22.spring.TestConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Lesson22Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Lesson22Application.class, args);
        TestConnector bean = context.getBean(TestConnector.class);
        bean.saveToDatabase();
    }

}
