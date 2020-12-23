package ServiceLane;

import org.junit.After;

import java.util.Objects;

public enum Vehicle {

    BIKE(1),
    CAR(2),
    TRUCK(3);

    private int width;

    Vehicle(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
}
