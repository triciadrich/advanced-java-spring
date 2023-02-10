package platform.codingnomads.co.corespring.lab;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@SpringBootApplication
public class CoreLabApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RideConfig.class);

        Car car = context.getBean(Car.class);
        Destination destination = context.getBean(Destination.class);

        System.out.println("Time to head to " + destination.getLocation() + " in my " + car.getMake() + " "
                + car.getModel());

        String[] via = context.getBeanNamesForType(Via.class);

        for (String vias : via){
            System.out.println("Chilling driving down a " + context.getBean(vias, Via.class).getPath());
        }

        System.out.println("Reached " + destination.getLocation() + " Shred the slopes!");
    }

}
