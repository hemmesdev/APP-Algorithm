package nl.han.ica.app.generics.sorting;

public class ShellSortTest extends SortingAlgorithmTest {

    @Override
    public ISortingAlgorithm createInstance() {
        return new ShellSort();
    }
}