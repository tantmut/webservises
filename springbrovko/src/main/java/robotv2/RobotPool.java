package main.java.robotv2;

import java.util.Collection;
import java.util.Map;

public interface RobotPool {

    Collection<Robot> getRobotCollection();
    Map<Integer, Robot> getRobotMap();
}
