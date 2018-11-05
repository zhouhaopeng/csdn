//package com.zhhp.dataStructure.binaryTree;
//
//public class BinarySearchTree<T extends Comparable> implements Tree<T> {
//
//    protected BinaryNode<T> root;
//
//    public BinarySearchTree(){
//        root = null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public int size() {
//        return size(root);
//    }
//
//    public int size(BinaryNode<T> p){
//        if (p == null)
//            return 0;
//        return size(p.getLeft()) + 1 + size(p.getRight());
//    }
//
//    @Override
//    public int height() {
//        return height(root);
//    }
//
//    public int height(BinaryNode<T> p){
//        if (p == null)
//            return 0;
//        int l = height(p.getLeft());
//        int r = height(p.getRight());
//        return (l > r) ? l + 1 : r + 1;
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public String preOrder() {
//        String sb=preOrder(root);
//        if(sb.length()>0){
//            //去掉尾部","号
//            sb=sb.substring(0,sb.length()-1);
//        }
//        return sb;
//    }
//
//    public String preOrder(BinaryNode<T> p){
//        StringBuilder builder = new StringBuilder();
//        if (p != null){
//            builder.append(p.getData()+",");
//            builder.append(preOrder(p.getLeft()));
//            builder.append(preOrder(p.getRight()));
//        }
//        return builder.toString();
//    }
//
//    @Override
//    public String inOrder() {
//        return null;
//    }
//
//    @Override
//    public String postOrder() {
//        return null;
//    }
//
//    @Override
//    public String levelOrder() {
//        return null;
//    }
//
//    @Override
//    public void insert(T data) {
//        if (data == null)
//            throw new RuntimeException("data is null");
//        root = insert(data,root);
//    }
//
//
//    private BinaryNode<T> insert(T data,BinaryNode<T> p){
//        if (p == null)
//            p = new BinaryNode<>(data,null,null);
//
//        int compareResult = data.compareTo(p.getData());
//        if (compareResult < 0)
//            p.setLeft(insert(data,p.getRight()));
//        else if (compareResult > 0)
//            p.setRight(insert(data,p.getRight())); ;
//        else ;
//
//        return p;
//    }
//
//    @Override
//    public void remove(T data) {
//        if (data == null)
//            throw new RuntimeException("data is null");
//        root = remove(data,root);
//    }
//
//    private BinaryNode<T> remove(T data,BinaryNode<T> p){
//        if (p == null){
//            return p;
//        }
//        int compareResult = p.getData().compareTo(data);
//        if (compareResult < 0){
//            p.setLeft(remove(data,p.getRight()));
//        }
//        else if (compareResult > 0){
//            p.setRight(remove(data,p.getRight()));
//        }
//        else if (p.left != null && p.right != null){
//            p.data = findMin(p.right).data;
//            p.right = remove(p.data,p.right);
//        }
//        else{
//            p = (p.left != null) ? p.left : p.right;
//        }
//        return p;
//
//    }
//
//    @Override
//    public T findMin() {
//        if (isEmpty())
//            throw new RuntimeException("tree is empty");
//        return findMin(root).data;
//    }
//
//    public BinaryNode<T> findMin(BinaryNode<T> p){
//        if (p == null)
//            return null;
//        if (p.left == null)
//            return p;
//        return findMin(p.left);
//    }
//
//    @Override
//    public T findMax() {
//        if (isEmpty())
//            throw new RuntimeException("tree is empty");
//        return findMax(root).data;
//    }
//
//    public BinaryNode<T> findMax(BinaryNode<T> p){
//        if (p == null)
//            return p;
//        if (p.right == null)
//            return p;
//        return findMin(p.right);
//    }
//
//    @Override
//    public BinaryNode findNode(T data) {
//        return null;
//    }
//
//    @Override
//    public boolean contains(T data) throws Exception {
//        return false;
//    }
//
//    @Override
//    public void clear() {
//
//    }
//}
