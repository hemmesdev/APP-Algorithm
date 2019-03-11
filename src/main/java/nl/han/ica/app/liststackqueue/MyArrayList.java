package nl.han.ica.app.liststackqueue;

public class MyArrayList<T> {

    private int size = 0;

    private T[] contents = (T[]) new Object[1];

    public void add(T value) {
        doubleArraySize();
        contents[size] = value;
        incrementSize();
    }

    public T get(int index) {
        return contents[index];
    }

    public void set(int index, T value) {
        doubleArraySize();
        T[] copy = (T[]) new Object[size - index];
        System.arraycopy(contents, index, copy, 0, size - index);
        contents[index] = value;
        System.arraycopy(copy, 0, contents, index + 1, copy.length);
        incrementSize();
    }

    private void doubleArraySize() {
        if(size == contents.length) {
            T[] newContents = (T[]) new Object[contents.length * 2];
            System.arraycopy(contents,0, newContents, 0, size);
            contents = newContents;
        }
    }

    private void incrementSize() {
        size++;
    }

    public int getSize() {
        return size;
    }



}
