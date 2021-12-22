package tech.pragmat.geolite2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class GeoLite2ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoLite2ServiceApplication.class, args);
    }

}
