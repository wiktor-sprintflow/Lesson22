package com.sprintflow.lesson22.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Qualifier("mysql")
public class MySQLConnector implements DatabaseConnector {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL.");
    }

    @Override
    public void close() {
        System.out.println("Close MySQL Connection.");
    }
}
