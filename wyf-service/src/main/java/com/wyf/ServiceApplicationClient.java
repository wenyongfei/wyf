package com.wyf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ImportResource(locations = {"classpath:spring/application*.xml"})
public class ServiceApplicationClient
{
    private static  final Logger LOGGER = LoggerFactory.getLogger(ServiceApplicationClient.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceApplicationClient.class);
        app.setWebEnvironment(false);
        app.run(args);
        LOGGER.info(">>>>>> hello-service 启动完成 <<<<<<");
        while (true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.info("Error",e);
            }
        }
    }
}
