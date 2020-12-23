package ServiceLane;

import java.util.List;

public class ServiceLaneDriver {
    private List<TestCase> testCases;
    private int[] freeway;

    public ServiceLaneDriver(List<TestCase> testCases, int[] freeway) {
        this.testCases = testCases;
        this.freeway = freeway;
    }

    public int[] driveTroughLane() {
        int[] results = new int[testCases.size()];
        int index = 0;

        for (TestCase testCase : testCases) {
            int minimum = findMinLaneWidth(testCase.getBeginning(), testCase.getEnd(), freeway);
            int min = 4;
            for (Vehicle vehicle : Vehicle.values()) {
                if(vehicle.getWidth() <= minimum) {
                    min = vehicle.getWidth();
                }
                results[index] = min;
            }
            index++;
        }
        return results;
    }

    private int findMinLaneWidth(int beginning, int end, int [] array) {
        int min = Integer.MAX_VALUE;
        for(int i = beginning; i < end; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
