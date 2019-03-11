package nl.han.ica.app.generics.sorting;

public class QuickSortTest extends SortingAlgorithmTest {

    @Override
    public ISortingAlgorithm createInstance() {
        return new QuickSort();
    }
}