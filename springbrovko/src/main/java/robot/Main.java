package main.java.robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        Model1000 model1000 = (Model1000) context.getBean("t1000");

        model1000.action();

    }
}
