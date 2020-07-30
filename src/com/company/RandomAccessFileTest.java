package com.company;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author xhx
 * @Date 2020/7/25 11:27
 */
public class RandomAccessFileTest {
    @Test
    public void testRandomAccessFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("hello.txt","rw");

        byte[] buf = new byte[20];
        int len;
        while ((len = raf.read(buf)) != -1){
            raf.seek(new File("hello.txt").length());
            raf.write(buf,0,len);
        }
        raf.close();

    }
}
