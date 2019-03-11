package nl.han.ica.app.generics.sorting;

import java.util.Arrays;


public class ShellSort implements ISortingAlgorithm {


    @Override
    public <T extends Comparable<T>> T[] sortArray(T[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        shellShort(array, 1);
        return array;
    }

    //http://sun.aei.polsl.pl/~mciura/publikacje/shellsort.pdf -- Knuth’s
    private <T extends Comparable<T>> void shellShort(T[] array, int length) {

        if(length < array.length / 3) {
            // Knuth’s
            shellShort(array, length * 3 + 1);
        }

        System.out.println("length: " + length);
        System.out.println("Before: " + Arrays.toString(array));

        for (int i = length; i < array.length; i++) {
            T toBeInserted = array[i];
            int j = i;

            while(j > length - 1 && toBeInserted.compareTo(array[j-length]) < 0) {
                array[j] = array[j-length];
                j = j - length;
            }
            array[j] = toBeInserted;
        }

        System.out.println("After: " + Arrays.toString(array));
    }


}
