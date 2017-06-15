package com.org.chomsky;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chomsky {
    public static void main(String args[]) {
        String str;
        Scanner scanner = new Scanner(System.in);
        List<Principle> principleList = new ArrayList<Principle>();
        System.out.println("请输入文法产生式");
        while(true) {
            str = scanner.nextLine();
            if(str.equals("exit")){
                break;
            }else{
                str = str.trim();
                principleList.add(new Principle(str.split("->")[0], str.split("->")[1]));
            }
        }
        scanner.close();
        isThird(principleList);
    }

    //满足0型文法的条件：1.推导式左侧不能全为终结符
    public static boolean isZero (List<Principle> principleList) {
        int i, j;
        for (i = 0; i < principleList.size(); i ++) {
            for (j = 0; j < principleList.get(i).getLeft().length(); j ++) {
                if (principleList.get(i).getLeft().charAt(j) >= 'A' && principleList.get(i).getLeft().charAt(j) <= 'Z') {
                    break;
                }
            }
            if (j == principleList.get(i).getLeft().length()) {
                System.out.println("不属于0型文法!");
                return false;
            }
        }
        System.out.println("属于0型文法!");
        return true;
    }
    //满足1型文法的条件：推导式左侧长度小于等于右侧或者右侧为空
    public static boolean isFirst (List<Principle> principleList) {
        if (isZero(principleList)) {
            int i;
            for (i = 0; i < principleList.size(); i ++) {
                if (principleList.get(i).getLeft().length() > principleList.get(i).getRight().length() && principleList.get(i).getRight().length() != 0) {
                    break;
                }
            }
            if (i == principleList.size()) {
                System.out.println("属于1型文法!");
                return true;
            } else {
                System.out.println("不属于1型文法!");
                return false;
            }
        } else {
            System.out.println("不属于1型文法!");
            return false;
        }
    }
    //满足2型文法的条件：推导式左侧长度为1并且为非终结符
    public static boolean isSecond (List<Principle> principleList) {
        if (isFirst(principleList)) {
            int i;
            for (i = 0; i < principleList.size(); i ++) {
                if ((principleList.get(i).getLeft().length() != 1) || !(principleList.get(i).getLeft().charAt(0) >= 'A' && principleList.get(i).getLeft().charAt(0) <= 'Z')) {
                    break;
                }
            }
            if (i == principleList.size()) {
                System.out.println("属于2型文法!");
                return true;
            } else {
                System.out.println("不属于2型文法!");
                return false;
            }
        } else {
            System.out.println("不属于2型文法!");
            return false;
        }
    }
    //满足3型文法的条件
    public static boolean isThird (List<Principle> principleList) {
        if (isSecond(principleList)) {
            int i;
            for (i = 0; i < principleList.size(); i ++) {
                if (principleList.get(i).getRight().length() == 0 || principleList.get(i).getRight().length() >= 3 || (principleList.get(i).getRight().charAt(0) >= 'A' && principleList.get(i).getRight().charAt(0) <= 'Z')) {
                    break;
                }
            }
            if (i == principleList.size()) {
                for (i = 0; i < principleList.size(); i ++) {
                    if (principleList.get(i).getRight().length() == 2 && !(principleList.get(i).getRight().charAt(0) >= 'A' && principleList.get(i).getRight().charAt(0) <= 'Z')) {
                        break;
                    }
                }
                if (i == principleList.size()) {
                    System.out.println("属于3型文法!");
                    return true;
                } else {
                    System.out.println("不属于3型文法!");
                    return false;
                }
            } else {
                System.out.println("不属于3型文法!");
                return false;
            }
        } else {
            System.out.println("不属于3型文法!");
            return false;
        }
    }
}
