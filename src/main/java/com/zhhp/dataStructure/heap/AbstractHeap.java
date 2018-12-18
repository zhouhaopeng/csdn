package com.zhhp.dataStructure.heap;

public abstract class AbstractHeap<T extends Comparable<T>> implements Heap<T>  {

    private static final int MAX_SIZE = Integer.MAX_VALUE;

    protected int size;
    protected int currentSize;

    protected T[] data;

    AbstractHeap(){
        this(0,16,null);
    }

    AbstractHeap(T[] data){
        this(data.length,data.length,data);
    }

    AbstractHeap(int currentSize,int size,T[] data){
        this.currentSize = currentSize;
        this.size = size;
        this.data = data;
        if (data != null)
            buildHeap(data);
    }

    @Override
    public T[] getData() {
        return data;
    }

    private void buildHeap(T[] t){
        if (t.length > 1){
            int pos = t.length / 2 - 1;
            for (int i = pos ; i >= 0 ; i -- ){
                siftDown(i);
            }
        }
    }

    @Override
    public int size() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean isLeaf(int pos) {
        boolean flag = false;
//        if (pos < currentSize && currentSize < p){
//
//        }
        return flag;
    }

    @Override
    public boolean leftChild(int pos) {
        return false;
    }

    @Override
    public boolean rightChild(int pos) {
        return false;
    }

    @Override
    public T parent(int pos) {
        return null;
    }

    abstract void siftDown(int pos);

    abstract void siftUp(int pos);
}
