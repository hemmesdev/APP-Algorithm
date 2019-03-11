package nl.han.ica.app.liststackqueue;


import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{

    private int size = 0;

    private ListNode<T> header = new ListNode<>();

    public void add(T value) {

        ListNode<T> listNode = new ListNode<>(value);
        ListNode<T> currentLast = header.getLast();
        if(currentLast == null) {
            this.header.setNext(listNode);
        } else {
            currentLast.setNext(listNode);
        }
        this.header.setLast(listNode);
        size++;
    }

    public T get(int index){
        ListNode<T> listNode = header.getNext();
        int position = 0;
        while(position < index) {
            listNode = listNode.getNext();
            position++;
        }
        return listNode.getValue();
    }

    public void remove(int index) {
        ListNode<T> listNode = header.getNext();
        int position = 0;
        while(position < index - 1) {
            listNode = listNode.getNext();
            position++;
        }
        listNode.setNext(listNode.getNext().getNext());
        size--;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;
            private ListNode<T> node = header;

            @Override
            public boolean hasNext() {
                return currentIndex < size && node.getNext() != null;
            }

            @Override
            public T next() {
                currentIndex++;
                node = node.getNext();
                return node.getValue();
            }
        };
    }

    public int getSize() {
        return size;
    }
}
