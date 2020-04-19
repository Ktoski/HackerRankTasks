package RoverTask;

import RoverTask.interfaces.RoverManipulationInterface;

import java.util.LinkedList;
import java.util.List;

public class RoverUnit implements RoverManipulationInterface {

    private List<Directions> listPreviousDirections = new LinkedList<>();
    private Coordinates lastCoordinates;

    public RoverUnit(Coordinates initialCoordinates, Directions initialDirection) {
        this.lastCoordinates = initialCoordinates;
        listPreviousDirections.add(initialDirection);
    }

    @Override
    public void spinRover(String spinDirection) {
        Directions lastDirection = getLastDirection();
        if(spinDirection.equals("R")){
            listPreviousDirections.add(lastDirection.turnRight());
        }else if(spinDirection.equals("L")){
            listPreviousDirections.add(lastDirection.turnLeft());
        }
    }

    @Override
    public void moveForward() {

        Directions lastDirection = getLastDirection();
        if(lastDirection.equals(Directions.NORTH)){
            lastCoordinates = lastCoordinates.moveNorth();
        }else if(lastDirection.equals(Directions.EAST)){
            lastCoordinates = lastCoordinates.moveEast();
        }else if(lastDirection.equals(Directions.SOUTH)){
            lastCoordinates = lastCoordinates.moveSouth();
        }else if(lastDirection.equals(Directions.WEST)){
            lastCoordinates = lastCoordinates.moveWest();
        }
    }

    public Directions getLastDirection(){
        return listPreviousDirections.get(listPreviousDirections.size() - 1);
    }

    public List<Directions> getListPreviousDirections() {
        return listPreviousDirections;
    }

    public Coordinates getCurrentPosition() {
        return lastCoordinates;
    }
}
