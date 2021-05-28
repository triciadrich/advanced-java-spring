package platform.codingnomads.co.ioc.examples.constructorinjection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConstructorInjectionDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(LaptopConfiguration.class);
        Laptop laptop = ctx.getBean(Laptop.class);
        System.out.println(laptop.printLaptopConfiguration());
    }
}
