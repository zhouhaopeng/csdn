package com.zhhp.dataStructure.binaryTree;

import java.io.Serializable;

public class BinaryNode<T extends Comparable> implements Serializable {

    private BinaryNode<T> left;

    private BinaryNode<T> right;

    private T data;

    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data){
        this(data,null,null);
    }

    public boolean isLeaf(){
        return this.left==null&&this.right==null;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
