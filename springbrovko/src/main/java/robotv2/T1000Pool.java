package main.java.robotv2;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Map;

public class T1000Pool implements RobotPool {

     private Collection<Robot> robotCollection;
    private Map<Integer, Robot> robotMap;

    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }

    public T1000Pool(Map<Integer, Robot> robotMap) {
        this.robotMap = robotMap;
    }

    @Override
    public Map<Integer, Robot> getRobotMap() {
        return robotMap;
    }

    public void setRobotCollection(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    public T1000Pool() {
//        robotCollection.add(new Model1000("green", 2003,true));
    }

    public void actionCollection() {
        for (Robot robot : robotCollection) {
            robot.action();
            robot.getInfo();

        }
    }

    public void actionMap() {
        for (Map.Entry<Integer, Robot> entry : robotMap.entrySet()) {
            entry.getKey();
            entry.getValue().action();
            entry.getValue().getInfo();
        }


    }

}

