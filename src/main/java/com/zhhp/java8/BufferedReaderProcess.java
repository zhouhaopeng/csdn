package com.zhhp.java8;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcess {

    String process(BufferedReader b) throws IOException;
}
