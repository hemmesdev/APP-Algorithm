package nl.han.ica.app.liststackqueue;

import java.util.ArrayList;
import java.util.Queue;

public class ArrayListBasedQueue<T>  {

    private ArrayList<T> queue;

    public ArrayListBasedQueue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T value) {
        queue.add(value);
    }

    public T dequeue() {
        T value = queue.get(0);
        queue.remove(0);
        return value;
    }

    public void makeEmpty() {
        queue = new ArrayList<>();
    }

    public int getSize() {
        return queue.size();
    }

    @Override
    public String toString() {
        return "Queue size: " + queue.size() + ", next: " + queue.get(0);
    }

}
