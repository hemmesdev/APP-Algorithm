package nl.han.ica.app.generics.sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class SortingAlgorithmTest {

    public abstract ISortingAlgorithm createInstance();

    @Test
    public final <T extends Comparable<T>> void regularInputSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[] {5,2,9,8,2,3,3,8,5,8,5,1,0,1,7,3,0,6,1,6,8,4,7,7,2};
        Integer[] expectedArray = new Integer[] {0,0,1,1,1,2,2,2,3,3,3,4,5,5,5,6,6,7,7,7,8,8,8,8,9};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void nullSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        sortingAlgorithm.sortArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void EmptyArraySortTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        sortingAlgorithm.sortArray(new Integer[]{});
    }

    @Test
    public final void sortedValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        Integer[] expectedArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void equalValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(inputArray, sortedArray);
    }

    @Test
    public final void reverseOrderValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[]{101,99,93,85,81,77,76,70,66,65,64,63,50,49,48,40,36,35,34,30,26,24,22,20,13,12,11,10,9,8,7,6,5,4,3,2,1};
        Integer[] expectedArray = new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void largeNumbersValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[]{4028951,5450386,2793694,3847894,1695179,9006729,1486442,2522821,5972404,7695462,6092450,2217796,2953333,1603800,8175061};
        Integer[] expectedArray = new Integer[]{1486442,1603800,1695179,2217796,2522821,2793694,2953333,3847894,4028951,5450386,5972404,6092450,7695462,8175061,9006729};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void positiveNegativeNumbersSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Integer[] inputArray    = new Integer[]{-13,45,3,-21,-45,45,1,16,-9,25,4,-6,-7,-8,31};
        Integer[] expectedArray = new Integer[]{-45,-21,-13,-9,-8,-7,-6,1,3,4,16,25,31,45,45};
        Integer[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }


    @Test
    public final void StringSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        String[] inputArray    = new String[]{"a","z","g","d","i","q","u","r","s","b","f","j"};
        String[] expectedArray = new String[]{"a","b","d","f","g","i","j","q","r","s","u","z"};
        String[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void FloatingNumbersSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        Double[] inputArray    = new Double[]{0.88,0.74,0.97,0.81,0.53,0.40,0.50,0.76,0.41,0.63,0.91,0.23,0.81,0.61,0.79,0.47,0.40,0.64,0.00,0.72,0.88,0.15,0.02,0.96,0.23,0.63,0.12,0.99,0.44,0.44};
        Double[] expectedArray = new Double[]{0.00,0.02,0.12,0.15,0.23,0.23,0.40,0.40,0.41,0.44,0.44,0.47,0.50,0.53,0.61,0.63,0.63,0.64,0.72,0.74,0.76,0.79,0.81,0.81,0.88,0.88,0.91,0.96,0.97,0.99};
        Double[] sortedArray   = sortingAlgorithm.sortArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

}