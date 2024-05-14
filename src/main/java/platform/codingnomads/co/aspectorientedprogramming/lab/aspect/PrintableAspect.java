package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PrintableAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintableAspect.class);

    @Pointcut("@annotation(Printable)")
    public void executePrinting(){

    }

    @Before("executePrinting()")
    public void printingAString(){
        System.out.println("Printable");
    }


}
