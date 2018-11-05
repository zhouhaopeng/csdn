package com.zhhp.dataStructure.binaryTree;

/**
 * bst 二叉搜索树  递归实现
 * @param <T>
 */

public class BinarySearchTree3<T extends Comparable<T>> implements Tree<T>  {

    private BinaryNode<T> root;

    private int size;

    public BinarySearchTree3(){}


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public String preOrder() {
        StringBuilder builder = new StringBuilder();
        return preOrder(root,builder);
    }

    private String preOrder(BinaryNode<T> node,StringBuilder builder){
        if (node == null){
            return null;
        }
        builder.append(node.getData()+" ");
        builder.append(preOrder(node.getLeft(),builder));
        builder.append(preOrder(node.getRight(),builder));
        return builder.toString();
    }

    @Override
    public String inOrder() {
        return null;
    }

    @Override
    public String postOrder() {
        return null;
    }

    @Override
    public String levelOrder() {
        return null;
    }

    @Override
    public void insert(T data) {
        if (data == null){
            return;
        }
        if (root == null){
            root = new BinaryNode<>(data);
            return;
        }
        insert(root,data);
    }

    private void insert(BinaryNode<T> node ,T data){
        int rst = data.compareTo(node.getData());
        if (rst == 0){
            return ;
        }
        if (rst == 1){
            if (node.getRight() == null){
                node.setRight(new BinaryNode<>(data));
            }else {
                insert(node.getRight(),data);
            }
        }else {
            if (node.getLeft() == null){
                node.setLeft(new BinaryNode<>(data));
            }else {
                insert(node.getLeft(),data);
            }
        }
    }

    @Override
    public void remove(T data) {

    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public BinaryNode findNode(T data) {
        return null;
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
