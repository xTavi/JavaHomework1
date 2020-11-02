package Aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* service.Library.addBook(..))")
    public void logMessage(ProceedingJoinPoint jointPoint) throws Throwable{
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
        jointPoint.proceed();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println(jointPoint.getSignature());
    }
}
