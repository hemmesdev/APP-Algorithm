package nl.han.ica.app.generics.sorting;

public class InsertionSortTest extends SortingAlgorithmTest {

    @Override
    public ISortingAlgorithm createInstance() {
        return new InsertionSort();
    }
}