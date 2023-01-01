package com.saltfish.example.leetcode;

import java.awt.*;

public class Lecode {
    /**
     * 2011. 执行操作后的变量值
     * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
     * <p>
     * ++X 和 X++ 使变量 X 的值 加 1
     * --X 和 X-- 使变量 X 的值 减 1
     * 最初，X 的值是 0
     * <p>
     * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
     * 今天的简单题我重拳出击
     */
    public static int finalValueAfterOperations(String[] operations) {
        int num = 0;
        for (String s : operations) {
            if (s.charAt(1) == '+') {
                num += 1;
            } else {
                num -= 1;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
    }
}
