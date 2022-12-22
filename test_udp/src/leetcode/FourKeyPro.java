package leetcode;


import com.sun.javafx.image.impl.IntArgb;

import java.util.HashMap;

/**
 * 假设你有一个特殊的键盘，上面只有四个键，它们分别是：
 *
 * 1、A 键：在屏幕上打印一个 A。
 *
 * 2、Ctrl-A 键：选中整个屏幕。
 *
 * 3、Ctrl-C 键：复制选中的区域到缓冲区。
 *
 * 4、Ctrl-V 键：将缓冲区的内容输入到光标所在的屏幕上。
 *
 * 这就和我们平时使用的全选复制粘贴功能完全相同嘛，只不过题目把 Ctrl 的组合键视为了一个键。现在要求你只能进行 N 次操作，请你计算屏幕上最多能显示多少个 A？
 */




public class FourKeyPro {
    /**
     * 思路1：将上述操作描述为状态值
     * n剩下步数 a_num A的数量 cpoy粘贴板的东西
     * 1.当只是按下A键 n-1 a_num+1
     * 2.当使用ctrl+V n-1 a_num+copy
     * 3.当全选复制ctrl+CV n-2 a_num copy = a_num
     * 下面使用最基础的动态规划来看一下
     */
    public static HashMap<String, Integer> map = new HashMap<>();
    public static int dp1(int n,int a_num,int copy){
        //上界
        if (n <= 0)return a_num;

        String key = n+"-"+a_num+"-"+copy;
        if (map.containsKey(key))return map.get(key);

        int val =  Math.max(dp1(n-1,a_num+1,copy),
                   Math.max(dp1(n-1,a_num+copy,copy),
                           dp1(n-2,a_num, a_num)));


        map.put(key,val);

        return val;
    }


    /**
     * 思路2：其实还是分情况来说但这次不是三个而是两种情况
     * 1.n比较小所以ctrl+CV还不如一直按A n-1 a_num+1
     * 2.n比较大时就是按一些A然后ctrl+A ctrl+CV组合 (a_num)*(i-(j-2)-1)
     *
     */
    public static int dp2(int n){
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            //第一种情况
            dp[i] = dp[i-1]+1;
            //第二种情况
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i],dp[j-2]*(i-(j-2)-1));
            }

        }
        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(dp1(7,0,0));
        System.out.println(dp2(7));


    }





}
