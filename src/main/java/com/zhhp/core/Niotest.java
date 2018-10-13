package com.zhhp.core;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class Niotest {

    @Test
    public void fileChanelTest() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio.txt","rw");
        FileChannel inChanel = aFile.getChannel();

        ByteBuffer  byteBuffer = ByteBuffer.allocate(48);

        int bytesRead = inChanel.read(byteBuffer);

        while (bytesRead != -1){
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.println(byteBuffer.get());
            }

            byteBuffer.clear();
            bytesRead = inChanel.read(byteBuffer);
        }
        aFile.close();
    }
    
    
    @Test
    public void transferTo() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nio.txt","rw");
        FileChannel inChanel = aFile.getChannel();
        RandomAccessFile bFile = new RandomAccessFile("src/main/resources/nio4.txt","rw");
        FileChannel outChanel = bFile.getChannel();
        
        long count = inChanel.size();

        inChanel.transferTo(0, count,outChanel);

    }

    @Test
    public void socketChannel() throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
        if (! socketChannel.finishConnect()){
        	 ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
             int n = socketChannel.read(byteBuffer);

             while (n != -1){
                 byteBuffer.flip();
                 while (byteBuffer.hasRemaining()){
                     System.out.println(byteBuffer.getChar());
                 }

                 byteBuffer.clear();
                 n = socketChannel.read(byteBuffer);
             }

        }else{
        	System.out.println("not connect");
        }
       
        socketChannel.close();

    }
}
