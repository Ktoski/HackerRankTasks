package GamingArray;

import java.util.List;

class Result {

    public String gamingArray(List<Integer> arr) {
        System.out.println("lista: " + arr);
        int iteration = 0;
        if(arr.isEmpty())
            return "BOB";
        return play(arr, iteration);
    }

    private String play(List<Integer> arr, int iteration) {
        int maxIndex = findIndexOfMaxValue(arr);
        List<Integer> result = subArrayFrom(arr, maxIndex);
        iteration++;
        System.out.println("current array: " + result);
        if(result.isEmpty()) {
            System.out.println("End game");
            if(iteration % 2 == 1) {
                System.out.println("BOB");
                return "BOB";
            }
            else {
                System.out.println("ANDY");
                return "ANDY";
            }
        } else {
            System.out.println("iteration " + iteration);
            return play(result, iteration);
        }
    }

    private int findIndexOfMaxValue(List<Integer> arr) {
        int maxValue = arr.stream().max(Integer::compareTo).get();
        return arr.indexOf(maxValue);
    }

    private List<Integer> subArrayFrom(List<Integer> arr, int index) {
        return arr.subList(0, index);
    }

}