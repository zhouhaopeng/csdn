package com.zhhp.dataStructure.binaryTree;

import org.junit.Test;

public class TreeTest {


    @Test
    public void test(){
        Integer[] a = {5,3,6,4,2,1,9,88,8,7,10,15,14,12};

        BinarySearchTree2<Integer> tree2 = new BinarySearchTree2<>();

        for (int i = 0 ; i < a.length ; i ++){
            tree2.insert(a[i]);
        }

        tree2.inOrder();
        System.out.println();
        System.out.println(tree2.findMax());
        System.out.println(tree2.findMin());

        BinaryNode<Integer> node = tree2.findNode(3);
        System.out.println(node.getData()+"_"+node.getLeft().getData()+"_"+node.getRight().getData());
        tree2.remove(9);
        tree2.inOrder();
        System.out.println();
        System.out.println(tree2.findMax());
        System.out.println(tree2.findMin());

    }

    @Test
    public void test2(){
        Integer[] a = {10,4,22,18,17,19,21,20,40};

        BinarySearchTree2<Integer> tree2 = new BinarySearchTree2<>();

        for (int i = 0 ; i < a.length ; i ++){
            tree2.insert(a[i]);
        }

        tree2.inOrder();
        System.out.println();
        System.out.println(tree2.findMax());
        System.out.println(tree2.findMin());


        tree2.remove(22);
        tree2.inOrder();
        System.out.println();
        System.out.println(tree2.findMax());
        System.out.println(tree2.findMin());

    }

    @Test
    public void test3() {
        Integer[] a = {10, 4, 22, 18, 17, 19, 21, 20, 40};

        Tree<Integer> tree3 = new BinarySearchTree3<>();

        for (int i = 0; i < a.length; i++) {
            tree3.insert(a[i]);
        }
        System.out.println("success");
    }
}
