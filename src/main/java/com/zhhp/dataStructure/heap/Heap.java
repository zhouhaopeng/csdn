package com.zhhp.dataStructure.heap;

public interface Heap<T extends Comparable<T>> {


    int size();

    boolean isEmpty();

    boolean isLeaf(int pos);

    boolean leftChild(int pos);

    boolean rightChild(int pos);

    T parent(int pos);

    boolean insert(T t);

    boolean popMin();

    boolean popMax();

    T[] getData();
}
