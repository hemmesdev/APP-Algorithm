package nl.han.ica.app.binarysearch;

import nl.han.ica.app.tree.BinaryNode;

public class BinarySearchTree {

    private BinarySearchTreeNode root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(int value) {
        this.root = new BinarySearchTreeNode(value);
    }

    public void insert(int value) {
        if(root == null) {
            this.root = new BinarySearchTreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void remove(int value) {
        this.root.remove(value, root);
    }

    public void prettyPrint() {
        this.root.prettyPrint(BinaryNode.INORDER);
    }

    public void prettyPrint(int order) {
        this.root.prettyPrint(order);
    }

    public int findMin() {
        return root.findMin(this.root);
    }

    public int findMax() {
        return root.findMax(this.root);
    }

    public BinarySearchTreeNode find(int value) {
        return root.find(value);
    }

}
