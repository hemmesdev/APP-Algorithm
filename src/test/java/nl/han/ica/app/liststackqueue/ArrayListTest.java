package nl.han.ica.app.liststackqueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {


    @Test
    public void addSingleItemToList() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        String expected = "dit is een test value";
        stringArrayList.add(expected);

        assertEquals(1, stringArrayList.getSize());
        assertEquals(expected, stringArrayList.get(0));
    }

    @Test
    public void multipleItemsToList() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        stringArrayList.add("value 1");
        stringArrayList.add("value 2");
        stringArrayList.add("value 3");
        stringArrayList.add("value 4");
        stringArrayList.add("value 5");
        stringArrayList.add("value 6");

        assertEquals(6, stringArrayList.getSize());
        assertEquals("value 1", stringArrayList.get(0));
        assertEquals("value 3", stringArrayList.get(2));
        assertEquals("value 6", stringArrayList.get(5));
    }

    @Test
    public void setItemOnIndexInList() {
        MyArrayList<String> stringArrayList = new MyArrayList<>();
        stringArrayList.add("value 1");
        stringArrayList.add("value 2");
        stringArrayList.add("value 3");
        stringArrayList.add("value 4");
        stringArrayList.add("value 5");
        stringArrayList.add("value 6");

        stringArrayList.set(3, "value 7");

        assertEquals(7, stringArrayList.getSize());
        assertEquals("value 1", stringArrayList.get(0));
        assertEquals("value 7", stringArrayList.get(3));
        assertEquals("value 4", stringArrayList.get(4));
        assertEquals("value 5", stringArrayList.get(5));
        assertEquals("value 6", stringArrayList.get(6));
    }

}