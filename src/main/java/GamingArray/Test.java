package GamingArray;

import java.util.List;

public class Test {

    @org.junit.Test
    public void firstTest(){

        List<Integer> array1 = List.of(1, 3, 5, 7, 9);
        List<Integer> array2 = List.of(7, 4, 6, 5, 9);
        List<Integer> array3 = List.of(5, 2, 6 ,3, 4);
        List<Integer> array4 = List.of(3, 1);
        List<Integer> array5 = List.of(5, 2, 6, 3, 4);

        Result result = new Result();
        System.out.println("test result:: " + result.gamingArray(array5));
    }

}
