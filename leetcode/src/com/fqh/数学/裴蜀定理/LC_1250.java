package com.fqh.数学.裴蜀定理;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/2 21:38
 **/
public class LC_1250 {


    public boolean isGoodArray(int[] nums) {
        // 裴蜀定理：一定存在正数x，y 满足ax + by = gcd(a, b)
        // 根据题目要求，如果数组中有gcd=1的子数组，那么该数组是一个好数组
        int g = 0;
        for (int x : nums) {
            g = gcd(g, x);
        }
        return g == 1;
    }

    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

//    1250. 检查「好数组」
//    已解答
//    第 161 场周赛
//            Q4
//1983
//    相关标签
//            相关企业
//    提示
//    给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
//
//    假如该和结果为 1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
//
//
//
//    示例 1：
//
//    输入：nums = [12,5,7,23]
//    输出：true
//    解释：挑选数字 5 和 7。
//            5*3 + 7*(-2) = 1
}
