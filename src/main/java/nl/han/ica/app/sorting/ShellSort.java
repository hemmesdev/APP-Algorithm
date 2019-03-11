package nl.han.ica.app.sorting;

import java.util.Arrays;

public class ShellSort implements ISortingAlgorithm {


    @Override
    public int[] sortIntegerArray(int[] integerArray) {

        if(integerArray == null || integerArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        return shellShort(integerArray, 1);
    }

    //http://sun.aei.polsl.pl/~mciura/publikacje/shellsort.pdf -- Knuth’s
    private int[] shellShort(int[] integerArray, int length) {

        if(length < integerArray.length / 3) {
            // Knuth’s
            integerArray = shellShort(integerArray, length * 3 + 1);
        }

        System.out.println("length: " + length);
        System.out.println("Before: " + Arrays.toString(integerArray));

        for (int i = length; i < integerArray.length; i++) {
            int toBeInserted = integerArray[i];
            int j = i;

            while(j > length - 1 && toBeInserted < integerArray[j-length]) {
                integerArray[j] = integerArray[j-length];
                j = j - length;
            }
            integerArray[j] = toBeInserted;
        }

        System.out.println("After: " + Arrays.toString(integerArray));
        return integerArray;
    }


}
