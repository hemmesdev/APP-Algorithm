package nl.han.ica.app.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort implements ISortingAlgorithm {

    @Override
    public int[] sortIntegerArray(int[] integerArray) {

        if(integerArray == null || integerArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        quickSortArray(integerArray, 0, integerArray.length - 1);
        return integerArray;
        //MyArrayList<Integer> integerArrayList = Arrays.stream(integerArray).boxed().collect(Collectors.toCollection(MyArrayList::new));
        //return quickSort(integerArrayList).stream().mapToInt(Integer::intValue).toArray();
    }

    private void quickSortArrayList(ArrayList<Integer> integerArrayList) {
        int[] integerArray = integerArrayList.stream().mapToInt(Integer::intValue).toArray();
        quickSortArray(integerArray, 0, integerArray.length - 1);

//        int listSize = integerArrayList.size();
//
//        if(listSize <= 3) {
//            for(int i = 1; i< integerArrayList.size(); i++) {
//                int toBeInserted = integerArrayList.get(i);
//                int j = i;
//                while(j > 0 && toBeInserted < integerArrayList.get(j-1)) {
//                    integerArrayList.set(j, integerArrayList.get(j-1));
//                    j--;
//                }
//                integerArrayList.set(j, toBeInserted);
//            }
//            return integerArrayList;
//        } else {
//
//            int pivotIndex = getPivotIndexArrayList(integerArrayList);
//            int pivot = integerArrayList.get(pivotIndex);
//
//            MyArrayList<Integer> leftList = new MyArrayList<>();
//            MyArrayList<Integer> rightList = new MyArrayList<>();
//
//            for (int i = 0; i < listSize; i++) {
//                if (i != pivotIndex) {
//                    int number = integerArrayList.get(i);
//                    if (number <= pivot) {
//                        leftList.add(number);
//                    } else {
//                        rightList.add(number);
//                    }
//                }
//            }
//
//            MyArrayList<Integer> sortedList = new MyArrayList<>(quickSort(leftList));
//            sortedList.add(pivot);
//            sortedList.addAll(quickSort(rightList));
//            return sortedList;
//        }
    }

    private void quickSortArray(int[] integerArray, int left, int right) {

        if(right - left >= 3) {

            int[] tmpArray = Arrays.copyOf(integerArray, integerArray.length);
            int pivotIndex = getPivotIndexArray(integerArray, left, right);
            int pivot = integerArray[pivotIndex];

            int amountLeft = left;
            int amountRight = right;
            for (int i = left; i <= right; i++) {
                if (i != pivotIndex) {
                    int number = tmpArray[i];
                    if (number <= pivot) {
                        integerArray[amountLeft] = number;
                        amountLeft++;
                    } else {
                        integerArray[amountRight] = number;
                        amountRight--;
                    }
                }
            }
            integerArray[amountLeft] = pivot;
            quickSortArray(integerArray, left, amountLeft - 1);
            quickSortArray(integerArray, amountRight + 1, right);

        } else {
            for(int i = left + 1; i <= right; i++) {
                int number = integerArray[i];
                int j = i;
                while(j > 0 && j > left && number < integerArray[j - 1]) {
                    integerArray[j] = integerArray[j-1];
                    j--;
                }
                integerArray[j] = number;
            }
        }
    }


    private int getPivotIndexArray(int[] integerArray, int left, int right) {

        int middle = ((right - left) / 2) + left;

        ISortingAlgorithm sortingAlgorithm = new InsertionSort();
        int[] sortedPivotNumbers = sortingAlgorithm.sortIntegerArray(new int[]{integerArray[left], integerArray[middle], integerArray[right]});

        if(sortedPivotNumbers[1] == integerArray[left]) {
            return left;
        } else if(sortedPivotNumbers[1] == integerArray[middle]) {
            return middle;
        } else {
            return right;
        }

    }

    private int getPivotIndexArrayList(ArrayList<Integer> integerArrayList) {
        int listSize = integerArrayList.size();
        if(listSize < 3) {
            throw new IllegalArgumentException("List is to short");
        }
        int middleIndex = listSize / 2;

        ISortingAlgorithm sortingAlgorithm = new InsertionSort();
        int[] sortedPivotNumbers = sortingAlgorithm.sortIntegerArray(new int[]{integerArrayList.get(0), integerArrayList.get(middleIndex), integerArrayList.get(listSize - 1)});

        if(sortedPivotNumbers[1] == integerArrayList.get(0)) {
            return 0;
        } else if(sortedPivotNumbers[1] == integerArrayList.get(middleIndex)) {
            return middleIndex;
        } else {
            return listSize - 1;
        }

    }
}
