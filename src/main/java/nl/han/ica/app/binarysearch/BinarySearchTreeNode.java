package nl.han.ica.app.binarysearch;

import nl.han.ica.app.tree.BinaryNode;


public class BinarySearchTreeNode {

    private int value;

    private BinarySearchTreeNode left;

    private BinarySearchTreeNode right;

    public BinarySearchTreeNode(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if(value == this.value) {
            return;
        }

        if(value < this.value) {
            if(this.left == null) {
                this.left = new BinarySearchTreeNode(value);
            } else {
                this.left.insert(value);
            }
        } else {
            if(this.right == null) {
                this.right = new BinarySearchTreeNode(value);
            } else {
                this.right.insert(value);
            }
        }
    }

    public BinarySearchTreeNode remove(int value, BinarySearchTreeNode node) {
        if(node == null) {
            throw new RuntimeException("not found");
        }
        if(value < node.value) {
            node.left = remove(value, node.left);
        } else if(value > node.value) {
            node.right = remove(value, node.right);
        } else if(node.left != null && node.right != null) {
            node.value = findMin(node.right);
            node.right = removeMin(node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    public BinarySearchTreeNode removeMin(BinarySearchTreeNode node) {
        if(node == null) {
            throw new RuntimeException("not found");
        }

        if(node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            return node.right;
        }
    }

    public BinarySearchTreeNode find(int value) {

        if(value == this.value) {
            return this;
        }else if(value < this.value && this.left != null) {
            return this.left.find(value);
        } else if(value > this.value && this.right != null) {
            return this.right.find(value);
        }

        return null;
    }

    public int findMin(BinarySearchTreeNode node) {
        if(node.left != null) {
            return node.left.findMin(node.left);
        } else {
            return node.value;
        }
    }

    public int findMax(BinarySearchTreeNode node) {
        if(node.right != null) {
            return node.right.findMax(node.right);
        } else {
            return node.value;
        }
    }

    public void prettyPrint() {
        prettyPrint(0, BinaryNode.INORDER);
    }

    public void prettyPrint(int order) {
        prettyPrint(0, order);
    }

    private void prettyPrint(int depth, int order) {
        String tab = "\t";
        String tabs = new String(new char[depth]).replace("\0", tab);

        if(order == BinaryNode.PREORDER) {
            System.out.println(tabs + value);
        }

        if (left != null) {
            left.prettyPrint(depth + 1, order);
        }

        if(order == BinaryNode.INORDER) {
            System.out.println(tabs + value);
        }

        if (right != null) {
            right.prettyPrint(depth + 1, order);
        }

        if(order == BinaryNode.POSTORDER) {
            System.out.println(tabs + value);
        }
    }

}
