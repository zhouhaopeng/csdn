package com.zhhp.dataStructure.tree;

import org.junit.Test;

public class TreeTest {

    /**
     *                A
     *           B         C
     *        D        E       F
     *              H   I    j   K
     */

    @Test
    public void test1(){
        BinaryTreeNode<String> A = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> B = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> C = new BinaryTreeNode<>("C");
        A.setLeft(B);
        A.setRight(C);

        BinaryTreeNode<String> D = new BinaryTreeNode<>("D");
        B.setLeft(D);

        BinaryTreeNode<String> E = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> F = new BinaryTreeNode<>("F");
        C.setLeft(E);
        C.setRight(F);

        BinaryTreeNode<String> H = new BinaryTreeNode<>("H");
        BinaryTreeNode<String> I = new BinaryTreeNode<>("I");
        E.setLeft(H);
        E.setRight(I);

        BinaryTreeNode<String> J = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> K = new BinaryTreeNode<>("K");
        F.setLeft(J);
        F.setRight(K);

        Tree<String> tree = new BinaryTree<>(A);


        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();

        //        A B D C E H I F J K
        //        D B A H E I C J F K
        //        D B H I E J K F C A
    }

    @Test
    public void test2(){
        BinaryTreeNode<String> A = new BinaryTreeNode<>("A");
        BinaryTreeNode<String> B = new BinaryTreeNode<>("B");
        BinaryTreeNode<String> C = new BinaryTreeNode<>("C");
        A.setLeft(B);
        A.setRight(C);

        BinaryTreeNode<String> D = new BinaryTreeNode<>("D");
        B.setLeft(D);

        BinaryTreeNode<String> E = new BinaryTreeNode<>("E");
        BinaryTreeNode<String> F = new BinaryTreeNode<>("F");
        C.setLeft(E);
        C.setRight(F);

        BinaryTreeNode<String> H = new BinaryTreeNode<>("H");
        BinaryTreeNode<String> I = new BinaryTreeNode<>("I");
        E.setLeft(H);
        E.setRight(I);

        BinaryTreeNode<String> J = new BinaryTreeNode<>("J");
        BinaryTreeNode<String> K = new BinaryTreeNode<>("K");
        F.setLeft(J);
        F.setRight(K);

        Tree<String> tree = new BinaryTree2<>(A);
        tree.preOrder();
        System.out.println();
        tree.inOrder();
        System.out.println();
        tree.postOrder();
        System.out.println();
        tree.levelOrder();
        //        A B D C E H I F J K
        //        D B A H E I C J F K
        //        D B H I E J K F C A
        //        A B C D E F H I J K
    }
}
