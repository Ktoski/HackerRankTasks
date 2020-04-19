package RoverTask;

import RoverTask.interfaces.InstructionSenderInterface;
import RoverTask.interfaces.RoverManipulationInterface;
import org.jetbrains.annotations.NotNull;

public class InstructionsSender implements InstructionSenderInterface {

    private RoverManipulationInterface roverManipulationInterface;

    public InstructionsSender(RoverManipulationInterface roverManipulationInterface) {
        this.roverManipulationInterface = roverManipulationInterface;
    }

    @Override
    public void sendInstructions(@NotNull String instructions) {
        char[] splittedInstructions = instructions.toCharArray();
        for(char instruction: splittedInstructions){
            switch (instruction) {
                case 'M': roverManipulationInterface.moveForward(); break;
                case 'L':
                case 'R': roverManipulationInterface.spinRover(String.valueOf(instruction)); break;
                default: throw new RuntimeException("Instruction not recognized");
            }

        }
    }
}
