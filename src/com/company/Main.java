package com.company;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args)  {
	    //1.实例化File类的对象，指明要操作的文件
        File file = new File("src/hello.txt");
        //2.提供具体的流
        FileReader fileReader = null;
        try {
             fileReader = new FileReader(file);
            //3.数据的读入
            int data;
            while ((data=fileReader.read())!=-1){
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader!=null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void FileWrite() throws IOException {

        String srcFile = "C:\\Users\\pro\\Desktop\\wlop\\39se.jpg";
        String desFile = "C:\\Users\\pro\\Desktop\\wlop\\39se1.jpg";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream); 
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte cbuf[] = new byte[1024];
        int len;
        while ((len=bufferedInputStream.read(cbuf))!=-1){
            bufferedOutputStream.write(cbuf,0,len);
        }
        bufferedInputStream.close();
    }
    //找出字符的个数
    @Test
    public void findChar(){
        String srcFile = "src/hello.txt";
        String desFile = "src/hello1.txt";

        Map<Character,Integer> dic = new HashMap<>();

        try {
            FileReader fileReader = new FileReader(srcFile);
            FileWriter fileWriter = new FileWriter(desFile,true);

            int data;
            while ((data=fileReader.read()) != -1){
                char c = (char)data;
                if(dic.get(c)==null){
                    dic.put(c,1);
                }else {
                    dic.put(c,dic.get(c)+1);
                }
            }

            BufferedWriter bw = new BufferedWriter(fileWriter);

            Set<Map.Entry<Character,Integer>> entrySet = dic.entrySet();
            Iterator<Map.Entry<Character,Integer>> iterator = entrySet.iterator();
            while (iterator.hasNext()){
                Map.Entry<Character,Integer> entry =  iterator.next();
                System.out.println(entry.getKey()+" = "+entry.getValue());

                bw.write(entry.getKey()+" = "+entry.getValue());
                bw.newLine();
            }
            bw.close();
            fileReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 转换流操作
     * @throws IOException
     */
    @Test
    public void transferStream() throws IOException {

        String src = "src/hello.txt";

        try {
            //字节流
            FileInputStream fileInputStream = new FileInputStream(src);

            //转换流
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");

            int len;
            char[] cbuf = new char[1024];
            while ((len = inputStreamReader.read(cbuf))!=-1){

                System.out.println(cbuf);

            }
            inputStreamReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Test
    public void testPrint() {
        PrintStream bos = null;
        try {
            bos = new PrintStream(new FileOutputStream("hello.txt",true));
            System.setOut(bos);

            System.out.println("我是神");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
