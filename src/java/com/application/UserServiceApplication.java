package com.application;

import com.microservice.UserService;
import org.wso2.msf4j.MicroservicesRunner;

public class UserServiceApplication  {

    public static void main(String[] args) throws Exception {
        MicroservicesRunner microservicesRunner = new MicroservicesRunner(8085);
        microservicesRunner.deploy(new UserService());
        microservicesRunner.start();
    }

}
