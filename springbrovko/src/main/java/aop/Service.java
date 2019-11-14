package main.java.aop;

import org.springframework.stereotype.Component;

@Component
public class Service {

    public int getIntValue(){
        return 5;
    }

    public double getDoubleValue(){
        return 5.6;
    }

    public int divideNumbers(int a, int b){
        return a/b;
    }
}
