package com.zhhp.dataStructure.binaryTree;

public interface Tree <T extends Comparable>{

    boolean isEmpty();

    int size();

    int height();

    String preOrder();

    String inOrder();

    String postOrder();

    String levelOrder();

    void insert(T data);

    void remove(T data);

    T findMin();

    T findMax();

    BinaryNode findNode(T data);

    boolean contains(T data) throws Exception;

    void clear();

}
