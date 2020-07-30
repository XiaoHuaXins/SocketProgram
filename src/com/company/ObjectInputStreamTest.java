package com.company;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 * @Author xhx
 * @Date 2020/7/24 15:32
 */
public class ObjectInputStreamTest {
    @Test
    public void testObjectInputStream()  {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("hello1.txt"));

            oos.writeObject(new Person("xhx",19));

            oos.flush();
        } catch (IOException e) {

        } finally {
            if (oos !=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("hello1.txt"));

        Object obj = ois.readObject();

        Person person = (Person)obj ;

        System.out.println(person);
        ois.close();
    }
}
