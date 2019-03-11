package nl.han.ica.app;

import nl.han.ica.app.binarysearch.BinarySearchTree;
import nl.han.ica.app.binarysearch.BinarySearchTreeNode;

public class BinarySearch {

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(3);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(10);
        binarySearchTree.insert(14);
        binarySearchTree.insert(13);

        binarySearchTree.prettyPrint();

        System.out.println("Min: " + binarySearchTree.findMin());
        System.out.println("Max: " + binarySearchTree.findMax());
        BinarySearchTreeNode node = binarySearchTree.find(7);


        binarySearchTree.remove(4);
        binarySearchTree.prettyPrint();



    }


}
