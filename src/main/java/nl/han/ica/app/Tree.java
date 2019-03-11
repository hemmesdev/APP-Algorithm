package nl.han.ica.app;

import nl.han.ica.app.tree.BinaryTree;
import nl.han.ica.app.tree.BinaryNode;
import nl.han.ica.app.tree.TreeNode;

public class Tree {

    public static void main(String[] args) {

        TreeNode<String> nodeK = new TreeNode<>("K", null, null);
        TreeNode<String> nodeJ = new TreeNode<>("J", null, nodeK);
        TreeNode<String> nodeI = new TreeNode<>("I", nodeJ, null);
        TreeNode<String> nodeE = new TreeNode<>("E", null, nodeI);
        TreeNode<String> nodeH = new TreeNode<>("H", null, null);
        TreeNode<String> nodeD = new TreeNode<>("D", nodeE, nodeH);
        TreeNode<String> nodeC = new TreeNode<>("C", nodeD, null);
        TreeNode<String> nodeG = new TreeNode<>("G", null, null);
        TreeNode<String> nodeF = new TreeNode<>("F", nodeG, null);
        TreeNode<String> nodeB = new TreeNode<>("B", nodeC, nodeF);
        nl.han.ica.app.tree.Tree<String> firstChildNextSiblingTree = new nl.han.ica.app.tree.Tree<>("A", nodeB);
        firstChildNextSiblingTree.prettyPrint();


        BinaryNode<String> binaryTreeNodeG = new BinaryNode<>("G", null, null);
        BinaryNode<String> binaryTreeNodeH = new BinaryNode<>("H", null, null);
        BinaryNode<String> binaryTreeNodeD = new BinaryNode<>("D", binaryTreeNodeG, binaryTreeNodeH);
        BinaryNode<String> binaryTreeNodeL = new BinaryNode<>("L", null, null);
        BinaryNode<String> binaryTreeNodeM = new BinaryNode<>("M", null, null);
        BinaryNode<String> binaryTreeNodeJ = new BinaryNode<>("J", binaryTreeNodeL, binaryTreeNodeM);
        BinaryNode<String> binaryTreeNodeI = new BinaryNode<>("I", null, null);
        BinaryNode<String> binaryTreeNodeE = new BinaryNode<>("E", binaryTreeNodeI, binaryTreeNodeJ);
        BinaryNode<String> binaryTreeNodeB = new BinaryNode<>("B", binaryTreeNodeD, binaryTreeNodeE);
        BinaryNode<String> binaryTreeNodeK = new BinaryNode<>("K", null, null);
        BinaryNode<String> binaryTreeNodeF = new BinaryNode<>("F", null, binaryTreeNodeK);
        BinaryNode<String> binaryTreeNodeC = new BinaryNode<>("C", null, binaryTreeNodeF);
        BinaryTree<String> binaryTree = new BinaryTree<>("A", binaryTreeNodeB, binaryTreeNodeC);

        binaryTree.prettyPrint();

        System.out.println("leaves: " + binaryTree.getNumberOfLeaves());
        System.out.println("half empty nodes: " + binaryTree.getNumberOfHalfEmptyNodes());
        System.out.println("non empty nodes: " + binaryTree.getNumberOfNonEmptyNodes());

        BinaryNode<String> binaryTreeNodeEx1_3 = new BinaryNode<>("1", null, null);
        BinaryNode<String> binaryTreeNodeEx1_4 = new BinaryNode<>("2", null, null);
        BinaryNode<String> binaryTreeNodeEx1_5 = new BinaryNode<>("3", null, null);
        BinaryNode<String> binaryTreeNodeEx1_2 = new BinaryNode<>("*", binaryTreeNodeEx1_3, binaryTreeNodeEx1_4);
        BinaryTree<String> postFixEx1 = new BinaryTree<>("*", binaryTreeNodeEx1_2, binaryTreeNodeEx1_5);
        //postFixEx1.print(INORDER);
        System.out.println(postFixEx1.calc());


        BinaryNode<String> binaryTreeNodeEx2_3 = new BinaryNode<>("4", null, null);
        BinaryNode<String> binaryTreeNodeEx2_4 = new BinaryNode<>("6", null, null);
        BinaryNode<String> binaryTreeNodeEx2_5 = new BinaryNode<>("5", null, null);
        BinaryNode<String> binaryTreeNodeEx2_2 = new BinaryNode<>("*", binaryTreeNodeEx2_3, binaryTreeNodeEx2_4);
        BinaryTree<String> postFixEx2 = new BinaryTree<>("+", binaryTreeNodeEx2_2, binaryTreeNodeEx2_5);
        //postFixEx2.print(INORDER);
        System.out.println(postFixEx2.calc());

        BinaryNode<String> binaryTreeNodeEx3_3 = new BinaryNode<>("4", null, null);
        BinaryNode<String> binaryTreeNodeEx3_4 = new BinaryNode<>("6", null, null);
        BinaryNode<String> binaryTreeNodeEx3_5 = new BinaryNode<>("5", null, null);
        BinaryNode<String> binaryTreeNodeEx3_2 = new BinaryNode<>("+", binaryTreeNodeEx3_4, binaryTreeNodeEx3_5);
        BinaryTree<String> postFixEx3 = new BinaryTree<>("*", binaryTreeNodeEx3_3, binaryTreeNodeEx3_2);
        //postFixEx3.print(INORDER);
        System.out.println(postFixEx3.calc());



    }


}
