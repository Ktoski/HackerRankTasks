package RoverTask;

import RoverTask.interfaces.InstructionSenderInterface;
import RoverTask.interfaces.RoverManipulationInterface;
import org.junit.Test;

public class RoverTaskTest {


    private RoverManipulationInterface roverManipulationInterface;
    private InstructionSenderInterface instructionSenderInterface;
    private Coordinates initialCoordinates;
    private Directions initialDirection;


    @Test
    public void firstTest(){
        //BEFORE
        initialCoordinates = new Coordinates(5,5);
        initialDirection = Directions.NORTH;
        roverManipulationInterface = new RoverUnit(initialCoordinates, initialDirection);
        instructionSenderInterface = new InstructionsSender(roverManipulationInterface);
        //AFTER
        instructionSenderInterface.sendInstructions("LMMMLLL");
        Coordinates currentPosition = roverManipulationInterface.getCurrentPosition();
        Directions currentDirection = roverManipulationInterface.getLastDirection();

        System.out.println(currentPosition + " " + currentDirection);

    }
}
