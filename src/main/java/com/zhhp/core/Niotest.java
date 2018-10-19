package com.zhhp.core;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
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
        socketChannel.connect(new InetSocketAddress("localhost", 999));
        
        
        String msg = "hello world";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(msg.getBytes());

         byteBuffer.flip();
         while (byteBuffer.hasRemaining()){
             socketChannel.write(byteBuffer);
         }

         byteBuffer.clear();
         
        

        socketChannel.close();

    }
    
    
    @Test
    public void socketServer() throws IOException{
    	ServerSocketChannel serverS = ServerSocketChannel.open();
    	
    	serverS.socket().bind(new InetSocketAddress(999));
    	serverS.configureBlocking(false);
    	
    	while(true){
    		final SocketChannel sc = serverS.accept();
    		if (sc != null){
    			new Thread(new Runnable() {
					
					public void run() {
						ByteBuffer bf = ByteBuffer.allocate(512);
	    				int c;
						try {
							
							while(true){
								c = sc.read(bf);
								
								while(c != -1){
			    					bf.flip();
			    					while(bf.hasRemaining()){
			    						System.out.println((char)bf.get());
			    					}
			    					bf.clear();
			    					c = sc.read(bf);
			    				}
								sc.close();
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
    		}
    		
    	}
    	
    }

    @Test
    public void testRequest() {
        retry:// 1（行2）
        for (int i = 0; i < 10; i++) {
//            retry:
// 2（行4）
            while (i == 5) {
                continue retry;
            }
            System.out.print(i + " ");
        }

    }
}
