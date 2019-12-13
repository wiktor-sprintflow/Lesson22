package com.sprintflow.lesson22.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component  //wszystko co z component to spring sam stworzy
//@Service
@Repository //klasa posrednicząca np z bazą danych
public class TestConnector {
    private DatabaseConnector databaseConnector;

    @Autowired //tu wstrzyknij DatabaseConnector, który na adnotacje Component lub Repository, lub Service
    public TestConnector(@Qualifier("postgress") DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void saveToDatabase(){
        databaseConnector.connect();

        databaseConnector.close();
    }
}
