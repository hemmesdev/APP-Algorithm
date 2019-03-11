package nl.han.ica.app.sorting;

import static org.junit.Assert.*;

public class QuickSortTest extends SortingAlgorithmTest {

    @Override
    public ISortingAlgorithm createInstance() {
        return new QuickSort();
    }
}