package CuttingTreesTask;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class CuttingTreesTask {

    @Test
    public void CuttingTreesTask(){

        int []A = {3,4,5,4};
        //int []A = {4,5,2,3,4};
        //int []A = {1,2,3,3,5,6,7};


        int counter = 0;

        for(int i = 0; i < A.length; i++){
            List<Integer> list  = Arrays.stream(A).boxed().collect(toList());
            list.remove(i);
            for(int j = 0; j < list.size()-1; j++){
                if(list.get(j) > list.get(j+1)){
                    counter++;
                    System.out.println(list.get(j)+ " : " + list.get(j+1));
                    break;
                }
            }

        }

        int number = A.length - counter;
        System.out.println("counter: " + number);
    }
}
