package nl.han.ica.app.generics.sorting;


public class MergeSortTest extends SortingAlgorithmTest{

    @Override
    public ISortingAlgorithm createInstance() {
        return new MergeSort();
    }
}