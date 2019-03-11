package nl.han.ica.app;

import nl.han.ica.app.sorting.ISortingAlgorithm;
import nl.han.ica.app.sorting.InsertionSort;
import nl.han.ica.app.sorting.MergeSort;
import nl.han.ica.app.sorting.QuickSort;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        //8.1
        exercise8_1();

        //8.4
        exercise8_4();

        //8.5
        exercise8_5();

        //8.6
        exercise8_6();


    }


    private static void exercise8_1() {

        //8.1
        ISortingAlgorithm sortingAlgorithm = new InsertionSort();
        int[] a = sortingAlgorithm.sortIntegerArray(new int[]{8, 1, 4, 1, 5, 9, 2, 6, 5});
        System.out.println(Arrays.toString(a));

        sortingAlgorithm = new MergeSort();
        int[] c = sortingAlgorithm.sortIntegerArray(new int[]{8, 1, 4, 1, 5, 9, 2, 6, 5});
        System.out.println(Arrays.toString(c));

        sortingAlgorithm = new QuickSort();
        int[] e = sortingAlgorithm.sortIntegerArray(new int[]{8, 1, 4, 1, 5, 9, 2, 6, 5});
        System.out.println(Arrays.toString(e));

    }

    private static void exercise8_4() {

        System.out.println("Equal keys sorting test:");
        System.out.println();

        int[] input = new int[5000];
        for(int i = 0; i< input.length; i++) {
            input[i] = 99;
        }

        algorithmTest("insertionSort", input);
        algorithmTest("mergeSort", input);
        algorithmTest("quickSort", input);
    }



    private static void exercise8_5() {
        System.out.println("Sorted keys sorting test:");
        System.out.println();

        int[] input = new int[5000];
        for(int i = 0; i< input.length; i++) {
            input[i] = i;
        }

        algorithmTest("insertionSort", input);
        algorithmTest("mergeSort", input);
        algorithmTest("quickSort", input);

    }

    private static void exercise8_6() {
        System.out.println("Reverse sorted keys sorting test:");
        System.out.println();

        int[] input = new int[5000];
        for(int i = input.length - 1; i > 0; i--) {
            input[i] = i;
        }

        algorithmTest("insertionSort", input);
        algorithmTest("mergeSort", input);
        algorithmTest("quickSort", input);

    }

    private static void algorithmTest(String type, int[] input) {

        ISortingAlgorithm sortingAlgorithm;
        if("insertionSort".equals(type)) {
            sortingAlgorithm = new InsertionSort();
        } else if ("mergeSort".equals(type)) {
            sortingAlgorithm = new MergeSort();
        } else {
            sortingAlgorithm = new QuickSort();
        }

        Long start   = System.currentTimeMillis();
        int[] result = sortingAlgorithm.sortIntegerArray(input);
        Long end     = System.currentTimeMillis();
        System.out.println(type);
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Execution Time: " + (end - start) + "ms");
        System.out.println();

    }


}
