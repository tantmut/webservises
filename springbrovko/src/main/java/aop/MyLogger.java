package main.java.aop;

import org.springframework.stereotype.Component;

@Component
public class MyLogger {

    public void printValue(Object obj){
        System.out.println(obj);
    }

    public void init(){
        System.out.println("init");

    }

    public void close(){
        System.out.println("close");

    }

    public void inCaseOfExceptionThrowAdvice(ArithmeticException e) {
        System.out.println("We have an exception here: " + e.toString());
    }
}
