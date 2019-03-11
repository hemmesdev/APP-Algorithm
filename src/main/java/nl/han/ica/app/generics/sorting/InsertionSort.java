package nl.han.ica.app.generics.sorting;

@SuppressWarnings("Duplicates")
public class InsertionSort implements ISortingAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sortArray(T[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        insertionSortRecursive(array, array.length);
        return array;
    }

    private <T extends Comparable<T>> void insertionSortRecursive(T[] array, int length) {

        if (length <= 1)
            return;

        insertionSortRecursive( array, length-1 );

        T last = array[length-1];
        int j = length-2;

        while (j >= 0 && array[j].compareTo(last) > 0)
        {
            array[j+1] = array[j];
            j--;
        }
        array[j+1] = last;
    }

    private <T extends Comparable<T>> void insertionSortNonRecursive(T[] array) {

        for(int i = 1; i< array.length; i++) {

            T toBeInserted = array[i];
            int j = i;

            while(j > 0 && toBeInserted.compareTo(array[j-1]) < 0) {
                array[j] = array[j-1];
                j--;
            }

            array[j] = toBeInserted;
        }
    }


}
