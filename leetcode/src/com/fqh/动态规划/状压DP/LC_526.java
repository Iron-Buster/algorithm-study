package com.fqh.动态规划.状压DP;


/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 21:23
 **/
public class LC_526 {

    public int countArrangement(int n) {
        int[] f = new int[1<<n];
        f[0] = 1;
        for (int s = 1; s < (1<<n); s++) {
            int num = Integer.bitCount(s);
            for (int i = 0; i < n; i++) {
                if (((s >> i) & 1) == 1 && (num % (i+1)) == 0 || (i+1) % num == 0) {
                    f[s] += f[s^(1<<i)];
                }
            }
        }
        return f[(1<<n)-1];
    }

//    526. 优美的排列
//            已解答
//    中等
//            相关标签
//    相关企业
//    假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：
//
//    perm[i] 能够被 i 整除
//    i 能够被 perm[i] 整除
//    给你一个整数 n ，返回可以构造的 优美排列 的 数量 。

    public static void main(String[] args) {
        System.out.println(new LC_526().countArrangement(2));
    }
}
