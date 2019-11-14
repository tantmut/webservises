package main.java.robotv2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("allbean.xml");

        T1000Pool t1000Pool = (T1000Pool) context.getBean("t1000Pool");


        t1000Pool.actionCollection();

     }
}
