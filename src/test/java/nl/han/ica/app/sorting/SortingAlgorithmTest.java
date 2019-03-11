package nl.han.ica.app.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;


public abstract class SortingAlgorithmTest {

    public abstract ISortingAlgorithm createInstance();

    @Test
    public final void regularInputSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[] {5,2,9,8,2,3,3,8,5,8,5,1,0,1,7,3,0,6,1,6,8,4,7,7,2};
        int[] expectedArray = new int[] {0,0,1,1,1,2,2,2,3,3,3,4,5,5,5,6,6,7,7,7,8,8,8,8,9};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void nullSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        sortingAlgorithm.sortIntegerArray(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void EmptyArraySortTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        sortingAlgorithm.sortIntegerArray(new int[]{});
    }

    @Test
    public final void sortedValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void equalValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(inputArray, sortedArray);
    }

    @Test
    public final void reverseOrderValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[]{101,99,93,85,81,77,76,70,66,65,64,63,50,49,48,40,36,35,34,30,26,24,22,20,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,20,22,24,26,30,34,35,36,40,48,49,50,63,64,65,66,70,76,77,81,85,93,99,101};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void largeNumbersValuesSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[]{4028951,5450386,2793694,3847894,1695179,9006729,1486442,2522821,5972404,7695462,6092450,2217796,2953333,1603800,8175061};
        int[] expectedArray = new int[]{1486442,1603800,1695179,2217796,2522821,2793694,2953333,3847894,4028951,5450386,5972404,6092450,7695462,8175061,9006729};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);
    }

    @Test
    public final void positiveNegativeNumbersSortArrayTest() {
        ISortingAlgorithm sortingAlgorithm = createInstance();
        int[] inputArray    = new int[]{-13,45,3,-21,-45,45,1,16,-9,25,4,-6,-7,-8,31};
        int[] expectedArray = new int[]{-45,-21,-13,-9,-8,-7,-6,1,3,4,16,25,31,45,45};
        int[] sortedArray   = sortingAlgorithm.sortIntegerArray(inputArray);
        assertArrayEquals(expectedArray, sortedArray);

    }
}