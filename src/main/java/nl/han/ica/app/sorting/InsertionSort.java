package nl.han.ica.app.sorting;

public class InsertionSort implements ISortingAlgorithm {

    @Override
    public int[] sortIntegerArray(int[] integerArray) {
        if(integerArray == null || integerArray.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        //insertionSortNonRecursive(integerArray);
        insertionSortRecursive(integerArray, integerArray.length);
        return integerArray;
    }


    private void insertionSortNonRecursive(int[] integerArray) {

        for(int i = 1; i< integerArray.length; i++) {

            int toBeInserted = integerArray[i];
            int j = i;

            while(j > 0 && toBeInserted < integerArray[j-1]) {
                integerArray[j] = integerArray[j-1];
                j--;
            }

            integerArray[j] = toBeInserted;
        }
    }

    private void insertionSortRecursive(int[] integerArray, int length) {

        if (length <= 1)
            return;

        insertionSortRecursive( integerArray, length-1 );

        int last = integerArray[length-1];
        int j = length-2;

        while (j >= 0 && integerArray[j] > last)
        {
            integerArray[j+1] = integerArray[j];
            j--;
        }
        integerArray[j+1] = last;
    }

}
