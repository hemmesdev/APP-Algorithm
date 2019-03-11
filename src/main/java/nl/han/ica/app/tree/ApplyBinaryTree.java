package nl.han.ica.app.tree;

public interface ApplyBinaryTree<T, U> {

    U apply(BinaryTree<T> bt);
    U apply(BinaryNode<T> node);

}
