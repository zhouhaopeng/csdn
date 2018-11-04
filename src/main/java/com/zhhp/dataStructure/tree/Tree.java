package com.zhhp.dataStructure.tree;

public interface Tree<T extends Comparable<T>> {

    boolean isEmpty();

    int size();

    void preOrder();

    void inOrder();

    void postOrder();

    /**
     *  广度优先遍历
     */
    void levelOrder();

    BinaryTreeNode<T> root();

    BinaryTree<T> createTree(BinaryTreeNode<T> root);
}
