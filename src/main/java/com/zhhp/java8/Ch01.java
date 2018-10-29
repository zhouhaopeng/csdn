package com.zhhp.java8;

import org.junit.Test;

import java.io.File;

public class Ch01 {


    @Test
    public void test1(){
        File[] files = new File(".").listFiles(File::isHidden);
        System.out.println(files.length+"--"+files[0].getName());
        System.out.println();
    }
}
