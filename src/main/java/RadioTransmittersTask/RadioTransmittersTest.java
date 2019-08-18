package RadioTransmittersTask;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadioTransmittersTest {

    @Test
    public void test1(){

        //String inputMap = "8 2" + "\n" +
        //                 "7 2 4 6 5 9 12 11";  // correct output 3

        //String inputMap = "5 1" + "\n" +
        //        "1 2 3 4 5";

        String inputMap = "7 2" + "\n" +
                "9 5 4 2 6 15 12";  // 4

        //String inputMap = "8 2" + "\n" +
        //        "9 5 4 2 6 22 15 30";  // 5

        Path pathToFile = Paths.get("src/main/java/RadioTransmittersTask/radioTransInputTest.txt");   // correct result 494
        List<String> linesOfFile = new ArrayList<>();
        try {
            linesOfFile = Files.readAllLines(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(linesOfFile.get(0)).append("\n").append(linesOfFile.get(1));
        String inputMap2 = sb.toString();

        RadioTransmittersTask radioTransmittersTask = new RadioTransmittersTask();

        int range =  radioTransmittersTask.getRange(inputMap);
        int [] hausesLocations = radioTransmittersTask.getHausesLoacations(inputMap);

        int result = radioTransmittersTask.setTrasnmitters(hausesLocations, range);
        System.out.println("number of transmitters: " + result);
    }
}
