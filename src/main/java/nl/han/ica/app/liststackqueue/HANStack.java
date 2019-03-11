package nl.han.ica.app.liststackqueue;

public class HANStack<T> {

    private HANLinkedList<T> stack = new HANLinkedList<>();

    public void push(T value) {
        stack.addFirst(value);
    }

    public void pop() {
        stack.remove(stack.getSize() - 1);
    }

    public T top() {
        return stack.get(stack.getSize() - 1);
    }

    public int getSize() {
        return stack.getSize();
    }




}
