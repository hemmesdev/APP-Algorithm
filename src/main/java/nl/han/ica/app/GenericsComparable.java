package nl.han.ica.app;

import nl.han.ica.app.generics.Address;
import nl.han.ica.app.generics.MemoryCell;

import java.util.Arrays;

public class GenericsComparable {

    public static void main(String[] args) {

//        Address[] addresses = {
//                new Address("Kappitelweg", 35),
//                new Address("Kappitelweg", 37),
//                new Address("Heyendaalseweg", 98)
//        };
//
//        Arrays.sort(addresses);
//        for(Address address: addresses){
//            System.out.println(address);
//        }


        String[] stringArray = {"test", "harry", "tim", "buikloop"};

        System.out.println(min(stringArray));

        MemoryCell<String> stringMemoryCell1 = new MemoryCell<>();
        stringMemoryCell1.setStoredValue("test");

        MemoryCell<String> stringMemoryCell2 = new MemoryCell<>();
        stringMemoryCell2.setStoredValue("harry");

        System.out.println(stringMemoryCell1.compareTo(stringMemoryCell2));


    }

    private static <T extends Comparable<T>> T min(T[] array) {

        if(array.length == 0) {
            throw new IllegalArgumentException("Empty Array");
        }

        T min = array[0];
        for(int i = 1; i < array.length; i++ ) {
            if(array[i].compareTo(min) < 0) {
                min = array[i];
            }
        }
        return min;
    }


}
