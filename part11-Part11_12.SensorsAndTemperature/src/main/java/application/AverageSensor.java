package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }

    public boolean isOn() {
        return sensors.stream().map(sensor -> sensor.isOn()).reduce(true, (acc, cv) -> acc && cv);
    }

    public void setOn() {
        sensors.stream().forEach(sensor -> sensor.setOn());
    }

    public void setOff() {
        sensors.stream().forEach(sensor -> sensor.setOff());
    }

    public int read() {
        if (sensors.isEmpty()) {
            throw new IllegalStateException();
        }

        int reading = (int) Math.floor(sensors
                .stream()
                .mapToInt(sensor -> sensor.read())
                .average()
                .getAsDouble());
        readings.add(reading);
        return reading;
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }

    public List<Integer> readings() {
        return readings;
    }
}
