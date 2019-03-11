package nl.han.ica.app;

import nl.han.ica.app.liststackqueue.*;

import java.io.File;

public class ListStackQueue {

    public static void main(String[] args) {

//        MyLinkedList<Integer> list = new MyLinkedList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//
//        list.remove(1);
//
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//
//
//        MyArrayList<String> stringArrayList = new MyArrayList<>();
//        stringArrayList.add("test");
//        stringArrayList.add("test1");
//        stringArrayList.add("test2");
//        stringArrayList.add("test3");
//        stringArrayList.add("test4");
//        stringArrayList.add("test5");
//        stringArrayList.add("test6");
//
//        stringArrayList.set(4, "test1");
//
//
//        System.out.println(stringArrayList.get(4));
//        System.out.println(stringArrayList.get(5));
//        System.out.println(stringArrayList.get(6));
//        System.out.println(stringArrayList.get(7));
//
//
//        HANLinkedList<String> hanLinkedList = new HANLinkedList<>();
//        hanLinkedList.addFirst("the first added value");
//        hanLinkedList.addFirst("the second added value");
//        hanLinkedList.insert(1, "the third added value");
//
//        System.out.println(hanLinkedList.get(0));
//        System.out.println(hanLinkedList.get(1));
//        System.out.println(hanLinkedList.get(2));
//
//        hanLinkedList.removeFirst();
//
//        System.out.println(hanLinkedList.get(0));
//        System.out.println(hanLinkedList.get(1));
//
//        hanLinkedList.remove(1);
//        hanLinkedList.remove(0);
//
//        System.out.println(hanLinkedList.get(0));
//
//
//        HANStack<String> hanStack = new HANStack<>();
//
//        hanStack.push("Tim");
//        hanStack.push("Harry");
//        hanStack.push("Anna");
//
//        System.out.println(hanStack.top());
//        hanStack.pop();
//        System.out.println(hanStack.top());
//        hanStack.pop();
//
//        hanStack.push("Bert");
//        hanStack.push("beb");
//
//        System.out.println(hanStack.top());
//        hanStack.pop();
//
//        System.out.println(hanStack.getSize());
//
//        SymbolChecker.checkSymbols(new File("resources/style.css"));

//        ArrayBasedQueue<String> arrayBasedQueue = new ArrayBasedQueue<>();
//
//        arrayBasedQueue.enqueue("Tim");
//        arrayBasedQueue.enqueue("Harry");
//        arrayBasedQueue.enqueue("Barry");
//        arrayBasedQueue.enqueue("Anna");
//
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//
//        arrayBasedQueue.enqueue("Mario");
//        arrayBasedQueue.enqueue("Benno");
//        arrayBasedQueue.enqueue("Henk");
//        arrayBasedQueue.enqueue("Ingrid");
//        arrayBasedQueue.enqueue("Teun");
//
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//        System.out.println(arrayBasedQueue.dequeue());
//
//        arrayBasedQueue.enqueue("Tim");
//        arrayBasedQueue.enqueue("Harry");
//        arrayBasedQueue.enqueue("Barry");
//        arrayBasedQueue.enqueue("Anna");
//        arrayBasedQueue.enqueue("Mario");
//        arrayBasedQueue.enqueue("Benno");

        ArrayListBasedQueue<String> queue = new ArrayListBasedQueue<>();
        queue.enqueue("Tim");
        queue.enqueue("Harry");
        queue.enqueue("Barry");
        queue.enqueue("Anna");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());




    }

}
