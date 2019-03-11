package nl.han.ica.app.liststackqueue;

import java.util.Arrays;

public class ArrayBasedQueue<T> {

    private static final int INITIAL_SIZE = 5;

    private int size = 0;
    private int front = 0;
    private int back = 0;

    private T[] queueArray;

    public ArrayBasedQueue() {
        queueArray = (T[]) new Object[INITIAL_SIZE];
    }

    public void enqueue(T value) {

        if(size == queueArray.length) {
            increaseQueueSize();
        } else if(back == queueArray.length) {
            back = 0;
        }

        queueArray[back] = value;
        back++;
        size++;
    }

    private void increaseQueueSize() {
        T[] copy = (T[]) new Object[queueArray.length * 2];

        if(front == back) {
            System.arraycopy(queueArray, front, copy, 0, queueArray.length - front);
            System.arraycopy(queueArray, 0, copy, queueArray.length - front, back);
            front = 0;
            back = queueArray.length;
            queueArray = copy;
        } else {
            System.arraycopy(queueArray, 0, copy, 0, queueArray.length);
            queueArray = copy;
        }
    }

    public T dequeue() {
        T value = queueArray[front];
        queueArray[front] = null;

        if(front == queueArray.length -1) {
            front = 0;
        } else {
            front++;
        }
        size--;

        if(queueArray.length > INITIAL_SIZE && size < queueArray.length / 2) {
            decreaseQueueSize();
        }

        return value;
    }

    private void decreaseQueueSize() {
        T[] copy = (T[]) new Object[queueArray.length / 2];
        if(front < back) {
            System.arraycopy(queueArray, front, copy, 0, back - front);
            back = back - front;
            front = 0;
        } else {
            System.arraycopy(queueArray, front, copy, 0, queueArray.length - front);
            System.arraycopy(queueArray, 0, copy, queueArray.length - front, back);
            back = queueArray.length - front + back;
            front = 0;
        }
        queueArray = copy;
    }

    public void makeEmpty() {
        queueArray = (T[]) new Object[INITIAL_SIZE];
        front = 0;
        back = 0;
    }

    @Override
    public String toString() {
        return "Queue size: " + size + ", next: " + queueArray[front];
    }
}
