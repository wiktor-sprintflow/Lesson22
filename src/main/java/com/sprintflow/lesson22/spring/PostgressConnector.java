package com.sprintflow.lesson22.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("postgress")
public class PostgressConnector implements DatabaseConnector {
    @Override
    public void connect() {
        System.out.println("Connected to Postgress.");
    }

    @Override
    public void close() {
        System.out.println("Close Postgress Connection.");
    }
}
