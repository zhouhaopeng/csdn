package com.zhhp.dataStructure.binaryTree;

/**
 * BST 搜索二叉树，
 * @param <T>
 */

public class BinarySearchTree2<T extends Comparable<T>> implements Tree<T> {

    private BinaryNode<T> root;

    private int size;

    public BinarySearchTree2() {
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public String preOrder() {
        return null;
    }

    @Override
    public String inOrder() {
        inOrder(root);
        return null;
    }

    private void inOrder(BinaryNode<T> p){
        if (p == null){
            return;
        }
        inOrder(p.getLeft());
        System.out.print(p.getData()+" ");
        inOrder(p.getRight());
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
        BinaryNode<T> current = root;
        int rst = data.compareTo(current.getData());
        while (true){
            if (rst == 0){
                return;
            }
            if (rst == 1){
                if (current.getRight() == null){
                    current.setRight(new BinaryNode<>(data));
                    return;
                }else {
                    current = current.getRight();
                }
            }else {
                if (current.getLeft() == null){
                    current.setLeft(new BinaryNode<>(data));
                    return;
                }else {
                    current = current.getLeft();
                }
            }
            rst = data.compareTo(current.getData());
        }
    }

    @Override
    public void remove(T data) {
        if (data == null || root == null){
            return;
        }
        BinaryNode<T> parent = findParent(root,data);
        //判断是根节点或者是左右子树
        int tag ;
        BinaryNode<T> delPoint ;
        if (parent == null){
            tag = 0;
            delPoint = root;
        }else if (parent.getLeft() !=null && data.compareTo(parent.getLeft().getData()) == 0){
            //左子树
            tag = 1;
            delPoint = parent.getLeft();
        }else {
            //右子树
            tag = 2;
            delPoint = parent.getRight();
        }

        BinaryNode<T> tmpParent = null;
        BinaryNode<T> tmp = delPoint.getLeft();
        if (tmp != null){
            while (tmp.getRight() != null){
                tmpParent = tmp;
                tmp = tmp.getRight();
            }
            if (tmpParent == null){
                //左子树无右边结点
                delPoint.setLeft(tmp.getLeft());
            }else {
                //左子树有右节点
                tmpParent.setRight(tmp.getLeft());
            }
            tmp.setLeft(delPoint.getLeft());
            tmp.setRight(delPoint.getRight());
        }else {
            tmp = delPoint.getRight();
        }
        if (tag == 0){
            root = tmp;
        }else if (tag == 1){
            parent.setLeft(tmp);
        }else parent.setRight(tmp);
    }

    private BinaryNode<T> findParent(BinaryNode<T> node,T data){
        BinaryNode<T> tmpParent = null;
        BinaryNode<T> tmp = node;
        int rst = data.compareTo(tmp.getData());
        while (true){
            if (rst == 0){
                return tmpParent;
            }
            if (rst == 1){
                if (tmp.getRight() == null){
                    throw new UnsupportedOperationException("no such element");
                }else {
                    tmpParent = tmp;
                    tmp = tmp.getRight();
                }
            }else {
                if (tmp.getLeft() == null){
                    throw new UnsupportedOperationException("no such element");
                }else {
                    tmpParent = node;
                    tmp = tmp.getLeft();
                }
            }
            rst = data.compareTo(tmp.getData());
        }
    }

    @Override
    public T findMin() {
        BinaryNode<T> current = root;
        if (current == null){
            return null;
        }
        while (current.getLeft() != null){
            current = current.getLeft();
        }
        return current.getData();
    }

    @Override
    public T findMax() {
        BinaryNode<T> current = root;
        if (current == null){
            return null;
        }
        while (current.getRight() != null){
            current = current.getRight();
        }
        return current.getData();
    }

    @Override
    public BinaryNode findNode(T data) {
        if (data == null){
            return null;
        }
        BinaryNode<T> current = root;
        if (current == null){
            return null;
        }
        int rst = data.compareTo(current.getData());
        while (true){
            if (rst == 0){
                return current;
            }
            if (rst == 1){
                if (current.getRight() == null){
                    return null;
                }else {
                    current = current.getRight();
                }
            }else {
                if (current.getLeft() == null){
                    return null;
                }else {
                    current = current.getLeft();
                }
            }
            rst = data.compareTo(current.getData());
        }
    }

    @Override
    public boolean contains(T data) throws Exception {
        return false;
    }

    @Override
    public void clear() {

    }
}
