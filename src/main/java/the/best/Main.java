package the.best;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "the.best")
public class Main extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }

}
