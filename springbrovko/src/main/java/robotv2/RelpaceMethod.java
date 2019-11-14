package main.java.robotv2;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class RelpaceMethod  implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        // new property of Car.breaks() method.
        System.out.println("New car break.");

        return o;
    }
}
