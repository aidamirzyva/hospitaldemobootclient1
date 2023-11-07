package az.orient.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HospitaldemobootclientApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(HospitaldemobootclientApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HospitaldemobootclientApplication.class);
    }
}
