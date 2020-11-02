package Aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* service.Library.addBook(..))")
    public void logMessage(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("The method: " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass()
                + " will be executed, with the following parameters: " +
                Arrays.toString(joinPoint.getArgs()) + ". Timestamp: " +
                LocalDateTime.now());

        joinPoint.proceed();

        System.out.println("Method " + joinPoint.getSignature().getName() +
                " from " + joinPoint.getTarget().getClass() +
                " finished the execution. Timestamp: " +
                LocalDateTime.now() + "\n");
        System.out.println("A new book was added");
    }

    @Around("execution(* service.Library.returnBookById(..))")
    public void logMessageReturnedBook(ProceedingJoinPoint joinPoint) throws Throwable{
        String id = Arrays.toString(joinPoint.getArgs());
        joinPoint.proceed();
        System.out.println("The book with id: " + id + " was returned at "+ LocalDateTime.now());
    }

    @Around("execution(* service.Library.borrow(..))")
    public void logMessageBorrowedBook(ProceedingJoinPoint joinPoint) throws Throwable{
        String args = Arrays.toString(joinPoint.getArgs());
        String[] moreArgs = args.split(",",2);
        joinPoint.proceed();
        System.out.println("The book with id: " + moreArgs[0] + " was borrowed at "+ LocalDateTime.now() + " by " + moreArgs[1]);
    }

}
