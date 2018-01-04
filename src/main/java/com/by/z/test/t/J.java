package com.by.z.test.t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 16、实现输入一个字符串，统计这个字符串在一个文件（c:/test.txt）中出现的次数？
 */
public class J {

    public static void main(String[] args) throws Exception{
        //afasfds
        String path = "E:/temp/test.txt";

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        File file = new File(path);
        FileInputStream fin = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
        int count = 0;
        String line = null;
        while ((line = br.readLine()) != null) {
                count += getCount(s, line);
        }

        System.out.println(count);
    }

    /**
     * 查找子串在母串中出现的次数
     *
     * @param s1 子串
     * @param s2 母串
     * @return 出现次数
     */
    public static int getCount(String s1, String s2) {

        int f = 0;
        int count = 0;
        while ((f = s2.indexOf(s1)) != -1) {
            count ++;
            s2 = s2.substring(f + s1.length());
        }

        return count;
    }

}
