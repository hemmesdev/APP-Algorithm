package nl.han.ica.app.sorting;

import java.util.Arrays;

public class MergeSort implements ISortingAlgorithm {

    @Override
    public int[] sortIntegerArray(int[] integerArray) {
        if(integerArray == null || integerArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }
        int[] tmpArray = new int[integerArray.length];
        return mergeSort(integerArray, tmpArray, 0, integerArray.length-1);
    }

    private int[] mergeSort(int[] array, int[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(array, tmpArray, left, center);
            mergeSort(array, tmpArray, center+1, right);
            merge(array, tmpArray, left, center + 1, right);
        }
        return tmpArray;
    }

    private void merge(int[] array, int[] tmpArray, int left, int center, int right) {
        int min, max;

        if(center == right) {
            min = left;
            max = right;
        } else {
            min = center;
            max = right;
        }

        for(int i = min; i <= max; i++) {
            int number = array[i];
            int j = i;
            while(j > 0 && j > left && number < tmpArray[j - 1]) {
                tmpArray[j] = tmpArray[j-1];
                j--;
            }
            tmpArray[j] = number;
        }
        System.out.println("MergeSort: " + Arrays.toString(tmpArray));
    }

}
