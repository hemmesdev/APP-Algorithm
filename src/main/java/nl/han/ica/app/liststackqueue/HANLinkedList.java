package nl.han.ica.app.liststackqueue;

public class HANLinkedList<T> {

    private int size = 0;

    private ListNode<T> header = new ListNode<>();

    public void addFirst(T value) {
        ListNode<T> newEntry = new ListNode<>(value);
        ListNode<T> currentLast = header.getLast();
        if(currentLast == null) {
            header.setLast(newEntry);
        }

        newEntry.setNext(header.getNext());
        header.setNext(newEntry);
        incrementSize();
    }

    public void removeFirst() {
        ListNode currentFirst = header.getNext();
        if(currentFirst != null) {
            header.setNext(header.getNext().getNext());
            decrementSize();
        }
    }

    public void insert(int index, T value) {
        if(index > size) {
            throw new IllegalArgumentException("wrong index");
        }

        if(index == 0) {
            addFirst(value);
            return;
        }

        ListNode<T> newEntry = new ListNode<>(value);
        ListNode<T> listNode;
        if(index == size) {
            listNode = header.getLast();
            header.setLast(newEntry);
        } else {
            listNode = getNodeOnIndex(index - 1);
        }

        newEntry.setNext(listNode.getNext());
        listNode.setNext(newEntry);
        incrementSize();
    }

    public T get(int index){
        if(index == size -1) {
            return header.getLast().getValue();
        }
        ListNode<T> listNode = getNodeOnIndex(index);
        if(listNode == null) {
            return null;
        }
        return listNode.getValue();
    }

    private ListNode<T> getNodeOnIndex(int index) {
        ListNode<T> listNode = header.getNext();
        int position = 0;
        while(position < index) {
            listNode = listNode.getNext();
            position++;
        }
        return listNode;
    }

    public void remove(int index) {
        if(index == 0) {
            removeFirst();
            return;
        }

        ListNode<T> listNode = getNodeOnIndex(index - 1);
        if(index == size - 1) {
            listNode.setNext(null);
            header.setLast(listNode);
        } else {
            listNode.setNext(listNode.getNext().getNext());
        }
        decrementSize();
    }

    private void incrementSize() {
        size++;
    }

    private void decrementSize() {
        size--;
    }

    public int getSize() {
        return size;
    }
}
