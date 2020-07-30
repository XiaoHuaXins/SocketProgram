package com.company;

import org.junit.Test;

import java.io.File;

/**
 * @Author xhx
 * @Date 2020/7/20 9:38
 */
public class FileTest {
    public static void main(String[] args) {

        File file = new File("src/com/company/hello.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.length());

        System.out.println(file.delete());

    }
    @Test
    public void FilesTest(){
        
    }
}
