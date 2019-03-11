package nl.han.ica.app.tree;

public class BinaryTree<T> {

    public BinaryNode<T> root;

    public BinaryTree(T value, BinaryNode<T> left, BinaryNode<T> right) {
        this.root = new BinaryNode<>(value, left, right);
    }

    public int getNumberOfLeaves() {
        return BinaryNode.numberOfLeaves(root);
    }

    public int getNumberOfHalfEmptyNodes() {
        return BinaryNode.numberOfHalfEmptyNodes(root);
    }

    public int getNumberOfNonEmptyNodes() {
        return BinaryNode.numberOfNonEmptyNodes(root);
    }

    public void print(int order) {
        root.print(order);
    }

    public double calc() {
        return root.calc();
    }

    public void prettyPrint() {
        root.prettyPrint(BinaryNode.INORDER);
    }

}
