package nl.han.ica.app.tree;

public class Tree<T> {

    public TreeNode<T> root;

    public Tree(T value, TreeNode<T> child) {
        root = new TreeNode<>(value, null, child);
    }

    public void prettyPrint() {
        root.prettyPrint(0);
    }


}
