package antonioloiacono.tesi.msaggregator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsAggregatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsAggregatorApplication.class, args);
    }

}
