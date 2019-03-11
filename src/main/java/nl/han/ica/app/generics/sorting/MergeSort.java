package nl.han.ica.app.generics.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class MergeSort implements ISortingAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sortArray(T[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        T[] tmpArray = Arrays.copyOf(array, array.length);
        return mergeSort(array, tmpArray, 0, array.length-1);
    }

    private <T extends Comparable<T>> T[] mergeSort(T[] array, T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tmpArray, left, center);
            mergeSort(array, tmpArray, center+1, right);
            merge(array, tmpArray, left, center + 1, right);
        }
        return tmpArray;
    }

    private <T extends Comparable<T>> void merge(T[] array, T[] tmpArray, int left, int center, int right) {
        int min, max;

        if(center == right) {
            min = left;
            max = right;
        } else {
            min = center;
            max = right;
        }

        for(int i = min; i <= max; i++) {
            T number = array[i];
            int j = i;
            while(j > 0 && j > left && number.compareTo(tmpArray[j - 1]) < 0) {
                tmpArray[j] = tmpArray[j-1];
                j--;
            }
            tmpArray[j] = number;
        }
        System.out.println("MergeSort: " + Arrays.toString(tmpArray));
    }


}
