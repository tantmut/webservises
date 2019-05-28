package main.java.robot;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Model1000 extends BaseModel implements InitializingBean, DisposableBean {

    private String color;
    private int year;
    private boolean sound;

    public Model1000() {
    }

    public Model1000(Hand hand, Head head, Leg leg, String color, int year, boolean sound) {
        super(hand, head, leg);
        this.color = color;
        this.year = year;
        this.sound = sound;
    }

    public Model1000(String color, int year, boolean sound) {
        this.color = color;
        this.year = year;
        this.sound = sound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSound() {
        return sound;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }

    public void getInfo() {
        System.out.println("Information " + color + " " + year + " " + sound);
    }

    @Override
    public void action() {
        getHand().cathSomethind();
        getHead().thinking();
        getLeg().go();

    }


    @Override
    public void dance() {
        System.out.println("Robot is dancing");

    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties are set");

    }
}
