package nl.han.ica.app.generics.sorting;

import java.util.Arrays;


public class QuickSort implements ISortingAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sortArray(T[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {

        if(right - left >= 3) {

            T[] tmpArray = Arrays.copyOf(array, array.length);
            int pivotIndex = getPivotIndex(array, left, right);
            T pivot = array[pivotIndex];

            int amountLeft = left;
            int amountRight = right;
            for (int i = left; i <= right; i++) {
                if (i != pivotIndex) {
                    T number = tmpArray[i];
                    if (number.compareTo(pivot) <= 0) {
                        array[amountLeft] = number;
                        amountLeft++;
                    } else {
                        array[amountRight] = number;
                        amountRight--;
                    }
                }
            }
            array[amountLeft] = pivot;
            quickSort(array, left, amountLeft - 1);
            quickSort(array, amountRight + 1, right);

        } else {
            for(int i = left + 1; i <= right; i++) {
                T number = array[i];
                int j = i;
                while(j > left && number.compareTo(array[j - 1]) < 0) {
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = number;
            }
        }
    }


    private <T extends Comparable<T>> int getPivotIndex(T[] array, int leftIndex, int rightIndex) {

        int middleIndex = ((rightIndex - leftIndex) / 2) + leftIndex;

        T left = array[leftIndex];
        T middle = array[middleIndex];
        T right = array[rightIndex];

        if (left.compareTo(middle) > 0) {
            if (middle.compareTo(right) > 0) {
                return middleIndex;
            } else if (left.compareTo(right) > 0) {
                return rightIndex;
            } else {
                return leftIndex;
            }
        } else {
            if (left.compareTo(right) > 0) {
                return leftIndex;
            } else if (middle.compareTo(right) > 0) {
                return rightIndex;
            } else {
                return middleIndex;
            }
        }
    }



}
