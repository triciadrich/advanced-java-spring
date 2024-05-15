package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Slf4j
@Aspect
@Component
public class GreetingServiceAspect {


        @Pointcut(value = "execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.goodbye())")
        private void goodbyePoint(){

        }


        @Before("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
        private void logBeforeGreeting(JoinPoint joinPoint){
          log.info("Before method : " + joinPoint.getSignature().getName());
        }

        @AfterReturning("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
        private void logAfterReturning(JoinPoint joinPoint){
            log.info("After returning : "+ joinPoint.getSignature().getName());
        }

        @Before("goodbyePoint()")
        private void logBeforeGoodbye(JoinPoint joinPoint){
            log.info("Before goodbye : " + joinPoint.getSignature().getName());
        }
}
