package ShufflingTask;

import org.junit.Test;

public class ShufflingTask {


    @Test
    public void test(){

        int A = 123456;
        String str1 = Integer.toString(A);

        char[] number = str1.toCharArray();
        int numberLenght = number.length;
        char[] newNumber = number.clone();

        for(int i = 0; i < newNumber.length; i++){
            System.out.print(newNumber[i] + " ");
        }

        char[] newNumberTemp = number.clone();
        int counter = 0;
        for(int i = numberLenght; i > 1  ; i--){
            char moveThis = newNumberTemp[numberLenght -1];

            int newIndex = (counter * 2) + 1;

            for(int j = newIndex; j < numberLenght -1; j++) {
                newNumber[j+1] = newNumberTemp[j];
            }
            if(newIndex > numberLenght -1)
                break;


            newNumber[newIndex] = moveThis;
            counter++;
            for(int z = 0; z < newNumber.length; z++){
                System.out.print(" | " + newNumber[z] + " ");
            }
            System.out.println(" ");
            newNumberTemp = newNumber.clone();

        }


        System.out.println(" ");
        for(int i = 0; i < newNumber.length; i++){
            System.out.print(newNumber[i] + " ");
        }

        String resultString = new String(newNumber);
        int result = Integer.parseInt(resultString);

    }
}
