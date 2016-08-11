package soft.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Iwan on 11.08.2016.
 */
@SpringBootApplication
@ComponentScan
public class Application extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
