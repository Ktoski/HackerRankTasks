package PlaneSeatsTask;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PlaneSeatsTask {

    private String getRowNumberFromSeatNumber(String seat){
        return seat.substring(0, seat.length()-1);
    }

    @Test
    public void PlaneSeatsTask(){

        //String S = "1A 3C 2B 4G 5A 1B 2K";
        String S = "1A 2F 1C";
        int N = 2;
        String [] tab = S.split(" ");
        for(String s: tab)
            System.out.print(s + " | ");


        List<String> list2Sorted = Arrays.stream(tab).sorted().collect(Collectors.toList());
        Object [] tab3Sorted = Arrays.stream(tab).sorted().collect(toList()).toArray();

        for(Object s: tab3Sorted){
            System.out.print(s + " | ");
        }

        System.out.println(list2Sorted);
        Map<String, List<String>> seatsMapping = new HashMap<>();

        for(int i = 1; i <= N; i++){
            seatsMapping.put(Integer.toString(i), new ArrayList<>());
        }
        System.out.println("seatsMapping " + seatsMapping);

        for(int j = 0; j < list2Sorted.size(); j++){
            String currentSeat = list2Sorted.get(j);
            String currentSeatRow = getRowNumberFromSeatNumber(currentSeat);
            seatsMapping.get(currentSeatRow).add(currentSeat);
        }


        Set<String> seatsSets = new HashSet<>();
        for(int seatsRow = 1; seatsRow <= N; seatsRow++){
            for(int j = 0 ; j < seatsMapping.get(Integer.toString(seatsRow)).size(); j++){
                String currentSeat = seatsMapping.get(Integer.toString(seatsRow)).get(j);
                System.out.println("currentSeat " + currentSeat);

                if(!currentSeat.equals(seatsRow+"A") &&  !currentSeat.equals(seatsRow+"B") && !currentSeat.equals(seatsRow+"C")) {
                    System.out.println("mathced ABC currentSeat " + currentSeat + " | " + seatsRow);
                    seatsSets.add("ABC" + seatsRow);
                }
                if((!currentSeat.equals(seatsRow+"D") && !currentSeat.equals(seatsRow+"E") && !currentSeat.equals(seatsRow+"F"))
                        || (!currentSeat.equals(seatsRow+"E") && !currentSeat.equals(seatsRow+"F") && !currentSeat.equals(seatsRow+"G") )) {
                    System.out.println("mathced  DGEF currentSeat " + currentSeat + " | " + seatsRow);
                    seatsSets.add("DEFG" + seatsRow);
                }
                if(!currentSeat.equals(seatsRow+"H") && !currentSeat.equals(seatsRow+"J") && !currentSeat.equals(seatsRow+"K")){
                    System.out.println("mathced HJK currentSeat " + currentSeat + " | " + seatsRow);
                    seatsSets.add("HJK" + seatsRow);
                }
            }
        }


        System.out.println("seatsSets - final result to return: " + seatsSets.size());   // FINAL RESULT CORRECT !!!!!!
        System.out.println("seatsMapping " + seatsMapping);

    }
}
