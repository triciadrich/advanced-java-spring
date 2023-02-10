package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration// @Configuration annotation indicates that this class has @Bean (or other) annotated methods.
// Spring will process the class and generate Spring Beans to be used within the application.
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class CodingNomadConfiguration {
    @Bean
    public Framework framework(){
        return Framework.builder().name("Spring Boot").version("2.5").build();
    }

    @Bean
    public IDE ide(){
        return IDE.builder().name("Intellij IDEA").version("2021.1").build();
    }

    @Bean
    public JDK jdk() {
        return JDK.builder().name("OpenJDK").version("11").build();
    }

    @Bean
    public Desk dsk(){
        return Desk.builder().type("Standup").brand("Random").build();
    }
}
