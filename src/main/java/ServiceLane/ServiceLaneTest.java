package ServiceLane;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ServiceLaneTest {

    private int [] freeway;
    private List<TestCase> testCases;

    @Before
    public void setup() {
        InputParser inputParser = new InputParser();
        freeway = inputParser.getFreewayArray();
        testCases = inputParser.getTestCases();
    }

    @Test
    public  void test1(){
        ServiceLaneDriver serviceLaneDriver = new ServiceLaneDriver(testCases, freeway);
        int [] results = serviceLaneDriver.driveTroughLane();
        System.out.println("*********** Results: ");
        for (int elem: results) {
            System.out.println(elem);
        }
    }
}
