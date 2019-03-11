package nl.han.ica.app.generics;

public class MemoryCell<T extends Comparable<T>> implements Comparable<MemoryCell<T>> {

    private T storedValue;

    public T getStoredValue() {
        return storedValue;
    }

    public void setStoredValue(T storedValue) {
        this.storedValue = storedValue;
    }

    @Override
    public int compareTo(MemoryCell<T> other) {
        return this.storedValue.compareTo(other.storedValue);
    }
}
