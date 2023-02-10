package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/via.xml"})
public class RideConfig {

    @Bean
    public Car car(){
        return new Car("Mazda", "3", "black");
    }

    @Bean
    public Destination destination(){
        return new Destination("Mt Hood");
    }
}
