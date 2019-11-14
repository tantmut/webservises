package main.java.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");

        Service service = (Service) context.getBean("service");

        double val = service.divideNumbers(7,1);


    }
}
