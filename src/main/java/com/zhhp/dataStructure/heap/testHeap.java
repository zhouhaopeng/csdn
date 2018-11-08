package com.zhhp.dataStructure.heap;

import org.junit.Test;

public class testHeap {


    @Test
    public void test1(){
        Integer[] a = {9,8,7,6,5,4,3,2,1};
        Heap<Integer> heap = new MinHeap<>(a);
        Integer[] data = heap.getData();
        for (int i = 0 ; i < data.length ; i ++){
            System.out.print(data[i]+", ");
        }


    }
}
