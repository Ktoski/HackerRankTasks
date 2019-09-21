package RadioTransmittersTask;

import java.util.Arrays;

public class RadioTransmittersTask {

    public int setTrasnmitters(int [] hausesLocations, int range){

        int [] sortedHausesLocations = Arrays.stream(hausesLocations).sorted().toArray();
        int numOfTransmitters = 0;
        int i = 0;

        while(i <  sortedHausesLocations.length ){

            numOfTransmitters++;
            int currentOriginLocation = sortedHausesLocations[i];
            boolean isInRange = true;
            while(isInRange && i < sortedHausesLocations.length){
                i++;
                if(i < sortedHausesLocations.length) {
                    int nextLocation = sortedHausesLocations[i];
                    isInRange = nextLocation - currentOriginLocation <= range;
                }
            }

            int locationToInstallTrans = sortedHausesLocations[i-1];
            i = i-1;
            currentOriginLocation = locationToInstallTrans;
            isInRange = true;

            while(isInRange && i < sortedHausesLocations.length){
                i++;
                if(i < sortedHausesLocations.length) {
                    int nextLocation = sortedHausesLocations[i];
                    isInRange = nextLocation - currentOriginLocation <= range;
                }
            }
        }
        return numOfTransmitters;
    }

    public int getRange(String inputMap){
        String [] digitsInFirstLine =  getFirstLineOfInput(inputMap).split(" ");
        String range = digitsInFirstLine[1];
        return Integer.parseInt(range);
    }

    private String getFirstLineOfInput(String inputMap){
        String [] inputLines = inputMap.split("\\r?\\n");
        return inputLines[0];
    }

    private String getSecondLineOfInput(String inputMap){
        String [] inputLines = inputMap.split("\\r?\\n");
        return inputLines[1];
    }

    public int [] getHausesLoacations(String inputMap){
        String [] hausesLocationsInString = getSecondLineOfInput(inputMap).split(" ");
        return Arrays.stream(hausesLocationsInString).map(Integer::parseInt).mapToInt(location -> location).toArray();
    }
}
