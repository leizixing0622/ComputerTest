package com.org;

import java.util.Scanner;

public class Chomsky {
    public static void main(String args[]) {
        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("exit")) break;
            System.out.println(">>>" + line);
        }
    }
}
