package nl.han.ica.app.tree;


public class TreeNode<T> {

    public T value;

    public TreeNode<T> sibling;

    public TreeNode<T> child;

    public TreeNode(T value, TreeNode<T> sibling, TreeNode<T> child) {
        this.value = value;
        this.sibling = sibling;
        this.child = child;
    }

    public void prettyPrint(int depth) {

        String tab = "\t";
        String tabs = new String(new char[depth]).replace("\0", tab);

        System.out.println(tabs + value.toString());

        if(child != null) {
            child.prettyPrint(depth + 1);
        }

        if(sibling != null) {
            sibling.prettyPrint(depth);
        }

    }


}
