package com.zhhp.dataStructure.heap;

public class MinHeap<T extends Comparable<T>> extends AbstractHeap<T> {

    public MinHeap(){
        super();
    }

    public MinHeap(int size){
        super(0,size,null);
    }

    public MinHeap(T[] data){
        super(data.length,data.length,data);
    }

    @Override
    void siftDown(int pos) {
        int tmp = pos;
        int j = tmp * 2 + 1;
        T tmpNode = data[tmp];
        while ( j < currentSize){
            if (j < currentSize - 1 && data[j].compareTo(data[j+1]) == 1){
                j++;
            }
            if (tmpNode.compareTo(data[j]) == 1){
                data[tmp] = data[j];
                tmp = j;
                j = j * 2 + 1;
            }else break;
            data[tmp] = tmpNode;
        }
    }

    @Override
    void siftUp(int pos) {
        int tmp = pos;
        int j = (pos - 1) / 2;
        T tmpNode = data[tmp];
        while (j >= 0){
            if (tmpNode.compareTo(data[j]) == -1){
                data[tmp] = data[j];
                tmp = j;
                j = j / 2 - 1;
            }else break;
            tmpNode = data[tmp];
        }
    }


    @Override
    public boolean insert(T t) {
        if (t == null){
            return false;
        }
        if (currentSize == size){
            return false;
        }
        data[currentSize] = t;
        siftUp(currentSize);
        currentSize ++;
        return true;
    }

    @Override
    public boolean popMin() {
        return false;
    }

    @Override
    public boolean popMax() {
        return false;
    }
}
