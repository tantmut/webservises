package main.java.robot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("allbean.xml");

        Model1000 model1000 = (Model1000) context.getBean("t1000");

        model1000.action();
        model1000.getInfo();

//        RobotConveyr t1000Conveyor = (RobotConveyr) context.getBean("t1000Conveyor");
//
//
//        Robot robot = t1000Conveyor.createRobot();
//        Robot robot1 = t1000Conveyor.createRobot();
//        Robot robot2 = t1000Conveyor.createRobot();
//
//        System.out.println("robot "+ robot);
//        System.out.println("robot1 "+ robot1);
//        System.out.println("robot2 "+ robot2);


     }
}
