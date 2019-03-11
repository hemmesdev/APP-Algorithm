package nl.han.ica.app.generics.sorting;

public interface ISortingAlgorithm {

    <T extends Comparable<T>> T[] sortArray(T[] array);

}
