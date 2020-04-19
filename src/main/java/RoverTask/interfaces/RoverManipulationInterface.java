package RoverTask.interfaces;

import RoverTask.Coordinates;
import RoverTask.Directions;

public interface RoverManipulationInterface {

    void spinRover(String spinDirection);
    void moveForward();
    Coordinates getCurrentPosition();
    Directions getLastDirection();
}
