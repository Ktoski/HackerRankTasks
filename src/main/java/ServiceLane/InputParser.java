package ServiceLane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private final int lengthOfFreeway;
    private final int numberOfCases;
    private final int[] freewayArray;
    private final List<TestCase> testCases;
    private final static String SEPARATOR = " ";

    public InputParser() {
        Path pathToFile = Paths.get("src/main/java/ServiceLane/input/input1.txt");
        List<String>linesOfFile = new ArrayList<>();
        try {
            linesOfFile = Files.readAllLines(pathToFile);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        String [] firstLine = linesOfFile.get(0).split(SEPARATOR);
        lengthOfFreeway = Integer.parseInt(firstLine[0]);
        numberOfCases = Integer.parseInt(firstLine[1]);
        freewayArray = convertStringArrayToIntArray(linesOfFile.get(1).split(SEPARATOR));
        testCases = new ArrayList<>();
        for(int i = 2; i <  linesOfFile.size(); i++) {
            int beginning =  Integer.parseInt(linesOfFile.get(i).split(SEPARATOR)[0]);
            int end = Integer.parseInt(linesOfFile.get(i).split(SEPARATOR)[1]);
            testCases.add(new TestCase(beginning, end));
        }
    }

    private int [] convertStringArrayToIntArray(String [] stringArray) {
        int [] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }
        return array;
    }

    public int[] getFreewayArray() {
        return freewayArray;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }
}
