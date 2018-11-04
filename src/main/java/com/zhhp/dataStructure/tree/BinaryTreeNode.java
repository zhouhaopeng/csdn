package com.zhhp.dataStructure.tree;

//树的节点
public class BinaryTreeNode<T extends Comparable<T>> {

    public static final int LEFT_FLAG = 0;
    public static final int RIGHT_FLAG = 1;

    //左指针
    private BinaryTreeNode<T> left;
    //右指针
    private BinaryTreeNode<T> right;
    //数据
    private T data;
    //标志位  用于后序遍历
    private int tag;

    public BinaryTreeNode(){

    }

    public BinaryTreeNode(T data){
        this(null,null,data);
    }

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTreeNode<T> leftChild(){
        return this.left;
    }

    public BinaryTreeNode<T> rightChild(){
        return this.right;
    }

    public T value(){
        return this.data;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
