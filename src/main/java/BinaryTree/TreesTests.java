package BinaryTree;

import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreesTests {

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BinaryTree bt = new BinaryTree();
        bt = bt.createBinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(1);
        bt.add(10);
        bt.add(5);
        bt.add(2);
        bt.add(15);

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));
        assertTrue(bt.containsNode(2));
        assertTrue(bt.containsNode(15));

        //assertFalse(bt.containsNode(1));

        bt.preOrderTraverseDepthTree();
        System.out.println("-------------------------- break ------------------------------------------");
        bt.traverseBreadthFirstTree();

        System.out.println("Number of paths: " + bt.getNumberOfUniquePaths());

        //bt.populatePathsList();
        /*for(UniquePath path: bt.getUniquePaths()){
            System.out.println("p -" + path);
        }*/
        System.out.println("-------------------------- break 2-----------------------------------------");
        bt.populatePathsList();

        for(UniquePath path: bt.getUniquePaths()){
            System.out.println("p -" + path);
        }

        System.out.println("--------------------- brake 3 ----------------------------------------------");

        bt.deleteNode(15);
        bt.preOrderTraverseDepthTree();
        System.out.println("is a b-tree correct: " + bt.checkIfHasTreeFeatures());
    }


    @Test
    public void testBinarySearch(){

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 10 is present at index 3.
        long startTime = System.currentTimeMillis();
        int index = Collections.binarySearch(al, 10);
        System.out.println(index);
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds1: " + timeElapsed);

        startTime = System.currentTimeMillis();
        int index2 = Collections.binarySearch(al, 133);
        System.out.println(index2);
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds2: " + timeElapsed);
        ///Collections.synchronizedNavigableMap();


        //Collections.binarySearch()

    }

    @Test
    public void sortingRev(){

        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        // 1 3 5 6 4 2

        List<Integer> list1 = al.stream().filter(e -> e%2 != 0).sorted().collect(Collectors.toList());
        List<Integer> list2 = al.stream().filter(e -> e%2 == 0).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        list1.addAll(list2);

        System.out.println(list1);

        System.out.println("avaailable prcessors " + Runtime.getRuntime().availableProcessors());

    }
}