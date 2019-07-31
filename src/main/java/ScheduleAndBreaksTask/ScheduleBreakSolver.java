package ScheduleAndBreaksTask;

import java.time.Duration;
import java.time.LocalTime;

public class ScheduleBreakSolver {

    public long solution(String scheduleString){

        String [] scheduleLines = scheduleString.split("\\r?\\n");
        long currentBiggestBreak = 0;

        for(int i = 1; i < scheduleLines.length; i++){
            long currentBreak = calculateBreakBetweenMeetings(scheduleLines[i-1], scheduleLines[i]);
            if(currentBreak > currentBiggestBreak){
                currentBiggestBreak = currentBreak;
            }
        }

        String firstMeeting = scheduleLines[0];
        String lastMeeting = scheduleLines[scheduleLines.length - 1];
        long breakBetweenStartAndFirstMeeting =  calculateBreakBetweenStartAndFirstMeeting(firstMeeting);
        long breakBetweenLastMeetingAndEnd = calculateBreakBetweenEndAndLastMeeting(lastMeeting);

        if(currentBiggestBreak < breakBetweenStartAndFirstMeeting)
            currentBiggestBreak = breakBetweenStartAndFirstMeeting;

        if(currentBiggestBreak < breakBetweenLastMeetingAndEnd)
            currentBiggestBreak = breakBetweenLastMeetingAndEnd;

        System.out.println("BiggestBreak: " + currentBiggestBreak);
        return currentBiggestBreak;
    }

    private long calculateBreakBetweenStartAndFirstMeeting(String firstScheduleLine){
        String startHourOfMeeting = getStartHourFromScheduleLine(firstScheduleLine);
        LocalTime parsedStartHourOfMeeting = LocalTime.parse(startHourOfMeeting);
        LocalTime parsedStartOfWeek = LocalTime.parse("00:00");
        Duration duration = Duration.between(parsedStartOfWeek, parsedStartHourOfMeeting);

        return duration.toMinutes();
    }

    private long calculateBreakBetweenEndAndLastMeeting(String lastScheduleLine){
        String startHourOfMeeting = getEndHourFromScheduleLine(lastScheduleLine);
        LocalTime parsedEndHourOfMeeting = LocalTime.parse(startHourOfMeeting);
        LocalTime parsedEndOfWeek = LocalTime.parse("23:59");
        Duration duration = Duration.between(parsedEndHourOfMeeting, parsedEndOfWeek);

        return duration.toMinutes();
    }

    private long calculateBreakBetweenMeetings(String previousScheduleLine, String nextScheduleLine){

        boolean areLinesFromTheSameDay = checkIfScheduleLinesAreFromTheSameDay(previousScheduleLine, nextScheduleLine);
        String endHourOfPreviousMeeting = getEndHourFromScheduleLine(previousScheduleLine);
        String startHourOfNextMeeting = getStartHourFromScheduleLine(nextScheduleLine);
        LocalTime parsedEndHourOfPreviousMeeting = LocalTime.parse(endHourOfPreviousMeeting);
        LocalTime parsedStartHourOfNextMeeting = LocalTime.parse(startHourOfNextMeeting);

        Duration duration = Duration.between(parsedEndHourOfPreviousMeeting, parsedStartHourOfNextMeeting);
        long breakBetweenMeetings;
        breakBetweenMeetings = areLinesFromTheSameDay ? duration.toMinutes() : duration.plusMinutes(1440).toMinutes();

        return breakBetweenMeetings;
    }

    private boolean checkIfScheduleLinesAreFromTheSameDay(String previousScheduleLine, String nextScheduleLine){
        String dayOfPreviousMeeting = getDayFromScheduleLine(previousScheduleLine);
        String dayOfNextMeeting = getDayFromScheduleLine(nextScheduleLine);
        return dayOfPreviousMeeting.equals(dayOfNextMeeting);
    }

    private String getDayFromScheduleLine(String scheduleLine){
        String [] data = scheduleLine.split(" ");
        return data[0];
    }

    private String getHoursRangeFromScheduleLine(String scheduleLine){
        String [] data = scheduleLine.split(" ");
        return data[1];
    }

    private String getEndHourFromScheduleLine(String scheduleLine){

        String hours = getHoursRangeFromScheduleLine(scheduleLine);
        String [] data = hours.split("-");
        return data[1];
    }

    private String getStartHourFromScheduleLine(String scheduleLine){

        String hours = getHoursRangeFromScheduleLine(scheduleLine);
        String [] data = hours.split("-");
        return data[0];
    }
}
