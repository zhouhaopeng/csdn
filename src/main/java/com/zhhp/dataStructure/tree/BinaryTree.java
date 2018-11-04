package com.zhhp.dataStructure.tree;

/**
 * 递归实现
 * @param <T>
 */
public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private BinaryTreeNode<T> root;

    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 先根访问
     */
    @Override
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(BinaryTreeNode<T> p) {
        if (p == null)
            return;
        visit(p);
        preOrder(p.leftChild());
        preOrder(p.rightChild());
    }

    /**
     * 中根访问
     */
    @Override
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(BinaryTreeNode<T> p) {
        if (p == null)
            return;
        inOrder(p.leftChild());
        visit(p);
        inOrder(p.rightChild());
    }

    /**
     * 后根访问
     */
    @Override
    public void postOrder() {
        postOrder(root);
    }

    @Override
    public void levelOrder() {

    }

    private void postOrder(BinaryTreeNode<T> p) {
        if (p == null)
            return;
        postOrder(p.leftChild());
        postOrder(p.rightChild());
        visit(p);
    }

    @Override
    public BinaryTreeNode<T> root() {
        return this.root;
    }

    @Override
    public BinaryTree<T> createTree(BinaryTreeNode<T> root) {
        return new BinaryTree<T>(root);
    }

    public void visit(BinaryTreeNode<T> node){
        if (node != null){
            System.out.print(node.getData()+" ");
        }
    }
}
