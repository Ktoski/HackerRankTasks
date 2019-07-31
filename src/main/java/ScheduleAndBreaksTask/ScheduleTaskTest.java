package ScheduleAndBreaksTask;

import org.junit.Assert;
import org.junit.Test;

public class ScheduleTaskTest {

    @Test
    public void test1(){

        String scheduleString = "Mon 01:00-23:00" + "\n" +
                "Tue 01:00-23:00" + "\n" +
                "Wed 01:00-23:00" + "\n" +
                "Thu 01:00-23:45" + "\n" +
                "Fri 01:00-23:00" + "\n" +
                "Sat 01:00-23:00" + "\n" +
                "Sun 01:00-21:00";

        ScheduleBreakSolver scheduleBreakSolver = new ScheduleBreakSolver();
        long solution = scheduleBreakSolver.solution(scheduleString);
        System.out.println("solution " + solution);
        Assert.assertEquals(179, solution);
    }
}
