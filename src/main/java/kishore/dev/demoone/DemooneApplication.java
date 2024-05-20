package kishore.dev.demoone;

import model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemooneApplication {

    public static void main(String[] args) {
        Product p = new Product();
        p.setTitle("xyz");
        SpringApplication.run(DemooneApplication.class, args);
    }

}
