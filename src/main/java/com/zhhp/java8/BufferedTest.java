package com.zhhp.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;

public class BufferedTest {


    public static String processFile(BufferedReader c,BufferedReaderProcess b) throws IOException {
        return b.process(c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = null;
        processFile(reader,(BufferedReader b) -> b.readLine());
    }

}
