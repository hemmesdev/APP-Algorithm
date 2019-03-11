package nl.han.ica.app.liststackqueue;

public class ListNode<T> {

    private T value;

    private ListNode<T> next;

    private ListNode<T> last;

    public ListNode() {

    }

    public ListNode(T value) {
        this.value = value;
    }


    public ListNode<T> getNext() {
        return next;
    }

    public ListNode<T> getLast() {
        return last;
    }

    public void setNext(ListNode<T> listNode) {
        this.next = listNode;
    }

    public void setLast(ListNode<T> listNode) {
        this.last = listNode;
    }

    public T getValue() {
        return value;
    }

}
