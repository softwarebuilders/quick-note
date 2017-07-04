package cz.softwarebuilders.quicknote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ImportResource("classpath:applicationContext.xml")
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
