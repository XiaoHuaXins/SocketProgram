package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author xhx
 * @Date 2020/7/22 16:41
 */
public class TestMain {
    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (true){
            System.out.println("请输入数据：");
            String str=bufferedReader.readLine();
            System.out.println(str);
            if(str.equalsIgnoreCase("e")||str.equalsIgnoreCase("exit")){
                break;
            }

        }

        Scanner sc = new Scanner(System.in);
        int std = sc.nextInt();
        System.out.println(std);
        bufferedReader.close();
    }
}
