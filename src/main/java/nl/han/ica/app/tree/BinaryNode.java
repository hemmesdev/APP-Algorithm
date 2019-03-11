package nl.han.ica.app.tree;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class BinaryNode<T> {

    public static final int PREORDER = 0;
    public static final int POSTORDER = 1;
    public static final int INORDER = 2;

    public T value;

    public BinaryNode<T> left;

    public BinaryNode<T> right;

    public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static <T> int numberOfLeaves(BinaryNode<T> binaryTreeNode) {
        int leaves = 0;
        if(binaryTreeNode.left == null && binaryTreeNode.right == null) {
            return 1;
        }

        if(binaryTreeNode.left != null) {
            leaves += numberOfLeaves(binaryTreeNode.left);
        }

        if(binaryTreeNode.right != null) {
            leaves += numberOfLeaves(binaryTreeNode.right);
        }

        return leaves;
    }

    public static <T> int numberOfHalfEmptyNodes(BinaryNode<T> binaryTreeNode) {
        int nodes = 0;
        if((binaryTreeNode.left == null && binaryTreeNode.right != null) || (binaryTreeNode.left != null && binaryTreeNode.right == null)) {
            nodes++;
        }

        if(binaryTreeNode.left != null) {
            nodes += numberOfHalfEmptyNodes(binaryTreeNode.left);
        }

        if(binaryTreeNode.right != null) {
            nodes += numberOfHalfEmptyNodes(binaryTreeNode.right);
        }
        return nodes;
    }

    public static <T> int numberOfNonEmptyNodes(BinaryNode<T> binaryTreeNode) {
        int nodes = 0;
        if((binaryTreeNode.left != null && binaryTreeNode.right != null)) {
            nodes++;
        }

        if(binaryTreeNode.left != null) {
            nodes += numberOfNonEmptyNodes(binaryTreeNode.left);
        }

        if(binaryTreeNode.right != null) {
            nodes += numberOfNonEmptyNodes(binaryTreeNode.right);
        }
        return nodes;
    }

    public void print(int order){
        if(order == PREORDER) {
            System.out.println(value.toString());
        }

        if (left != null) {
            left.print(order);
        }

        if(order == INORDER) {
            System.out.println(value.toString());
        }

        if (right != null) {
            right.print(order);
        }

        if(order == POSTORDER) {
            System.out.println(value.toString());
        }
    }

    public void prettyPrint(int order) {
        prettyPrint(0, INORDER);
    }

    private void prettyPrint(int depth, int order) {

        String tab = "\t";
        String tabs = new String(new char[depth]).replace("\0", tab);

        if(order == PREORDER) {
            System.out.println(tabs + value.toString());
        }

        if (left != null) {
            left.prettyPrint(depth + 1, order);
        }

        if(order == INORDER) {
            System.out.println(tabs + value.toString());
        }

        if (right != null) {
            right.prettyPrint(depth + 1, order);
        }

        if(order == POSTORDER) {
            System.out.println(tabs + value.toString());
        }


    }


    public double calc() {

        if(left != null && right != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(left.calc());
            stringBuilder.append(value.toString());
            stringBuilder.append(right.calc());

            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            try {
                String math = stringBuilder.toString();
                return (Double) (engine.eval(math));
            } catch (ScriptException e) {
                return 0.0;
            }

        } else if(left != null) {
            return left.calc();
        } else if(right != null) {
            return right.calc();
        }
        return Double.parseDouble(value.toString());
    }

}
