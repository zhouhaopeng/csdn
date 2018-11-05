package com.zhhp.dataStructure.binaryTree;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    protected BinaryNode<T> root;

    public BinarySearchTree(){
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(BinaryNode<T> p){
        if (p == null)
            return 0;
        return size(p.left) + 1 + size(p.right);
    }

    @Override
    public int height() {
        return height(root);
    }

    public int height(BinaryNode<T> p){
        if (p == null)
            return 0;
        int l = height(p.left);
        int r = height(p.right);
        return (l > r) ? l + 1 : r + 1;
    }

    /**
     *
     * @return
     */
    @Override
    public String preOrder() {
        String sb=preOrder(root);
        if(sb.length()>0){
            //去掉尾部","号
            sb=sb.substring(0,sb.length()-1);
        }
        return sb;
    }

    public String preOrder(BinaryNode<T> p){
        StringBuilder builder = new StringBuilder();
        if (p != null){
            builder.append(p.data+",");
            builder.append(preOrder(p.left));
            builder.append(preOrder(p.right));
        }
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
        if (data == null)
            throw new RuntimeException("data is null");
        root = insert(data,root);
    }


    private BinaryNode<T> insert(T data,BinaryNode<T> p){
        if (p == null)
            p = new BinaryNode<>(data,null,null);

        int compareResult = data.compareTo(p.data);
        if (compareResult < 0)
            p.left = insert(data,p.left);
        else if (compareResult > 0)
            p.right = insert(data,p.right);
        else ;

        return p;
    }

    @Override
    public void remove(T data) {
        if (data == null)
            throw new RuntimeException("data is null");
        root = remove(data,root);
    }

    private BinaryNode<T> remove(T data,BinaryNode<T> p){
        if (p == null){
            return p;
        }
        int compareResult = p.data.compareTo(data);
        if (compareResult < 0){
            p.left = remove(data,p.left);
        }
        else if (compareResult > 0){
            p.right = remove(data,p.right);
        }
        else if (p.left != null && p.right != null){
            p.data = findMin(p.right).data;
            p.right = remove(p.data,p.right);
        }
        else{
            p = (p.left != null) ? p.left : p.right;
        }
        return p;

    }

    @Override
    public T findMin() {
        if (isEmpty())
            throw new RuntimeException("tree is empty");
        return findMin(root).data;
    }

    public BinaryNode<T> findMin(BinaryNode<T> p){
        if (p == null)
            return null;
        if (p.left == null)
            return p;
        return findMin(p.left);
    }

    @Override
    public T findMax() {
        if (isEmpty())
            throw new RuntimeException("tree is empty");
        return findMax(root).data;
    }

    public BinaryNode<T> findMax(BinaryNode<T> p){
        if (p == null)
            return p;
        if (p.right == null)
            return p;
        return findMin(p.right);
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
