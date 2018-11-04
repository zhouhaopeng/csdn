package com.zhhp.dataStructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 非递归方法遍历
 * @param <T>
 */
public class BinaryTree2 <T extends Comparable<T>> implements Tree<T>{


    private BinaryTreeNode<T> root;

    private Stack<BinaryTreeNode<T>> stack = new Stack<>();

    private Queue<BinaryTreeNode<T>> queue = new LinkedList<>();

    public BinaryTree2(BinaryTreeNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void preOrder() {
        BinaryTreeNode<T> current = root;
        while ( !stack.isEmpty() || current != null){
            if (current != null){
                visit(current);
                stack.push(current);
                current = current.leftChild();
            }else {
                BinaryTreeNode<T> node = stack.pop();
//先根访问可以加
//                while (!stack.isEmpty()&&node.rightChild() == null){
//                    node = stack.pop();
//                }
                current = node.rightChild();
            }
        }

    }

    @Override
    public void inOrder() {
        BinaryTreeNode<T> current = root;
        while ( !stack.isEmpty() || current != null){
            if (current != null){
                stack.push(current);
                current = current.leftChild();
            }else {
                BinaryTreeNode<T> node = stack.pop();
                visit(node);
                current = node.rightChild();
            }
        }
    }

    @Override
    public void postOrder()  {
        BinaryTreeNode<T> current = root;
        while (true){
            while (current != null){
                current.setTag(BinaryTreeNode.LEFT_FLAG);
                stack.push(current);
                current = current.leftChild();
            }
            current = stack.pop();
            while (current.getTag() == BinaryTreeNode.RIGHT_FLAG){
                visit(current);
                if (stack.empty()){
                    return;
                }else {
                    current = stack.pop();
                }
            }
            current.setTag(BinaryTreeNode.RIGHT_FLAG);
            stack.push(current);
            current = current.rightChild();
        }
    }

    @Override
    public void levelOrder(){
        BinaryTreeNode<T> current = root;
        queue.offer(current);
        while (!queue.isEmpty()){
            current = queue.poll();
            visit(current);
            if (current.leftChild() != null){
                queue.offer(current.leftChild());
            }
            if (current.rightChild() != null){
                queue.offer(current.rightChild());
            }
        }
    }

    @Override
    public BinaryTreeNode<T> root() {
        return null;
    }

    @Override
    public BinaryTree<T> createTree(BinaryTreeNode<T> root) {
        return null;
    }

    public void visit(BinaryTreeNode<T> node){
        if (node != null){
            System.out.print(node.getData()+" ");
        }
    }
}
