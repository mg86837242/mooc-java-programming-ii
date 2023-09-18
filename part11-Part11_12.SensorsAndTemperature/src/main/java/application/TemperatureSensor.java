package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn() {
        isOn = true;
    }

    public void setOff() {
        isOn = false;
    }

    public int read() {
        if (isOn == false) {
            throw new IllegalStateException();
        }

        Random rand = new Random();
        return rand.nextInt(61) - 30;
    }
}
