package com.fqh.数论.容斥原理;

/**
 * @Author: vq
 * @Date: 2023/12/22 18:38
 * @Version V1.0
 */
public class LC_878 {

    // 设能被a整除的数字集合大小为A
    // 设能被b整除的数字集合大小为B
    // 容斥原理 |AUB| = |A| + |B| - |A∩B|
    public int nthMagicalNumber(int n, int a, int b) {
        int lcm = lcm(a, b);
        int l = 0, r = (int) 1e9;
        while (l < r) {
            int mid = (l + r) >> 1;
            if ((mid / a + mid / b - mid / lcm) < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l % 1000000007;
    }

    // 最大公约数
    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    // 最小公倍数
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }


//    878. 第 N 个神奇数字
//    第 95 场周赛
//            Q3
//1897
//    相关标签
//            相关企业
//    一个正整数如果能被 a 或 b 整除，那么它是神奇的。
//
//    给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 109 + 7 取模 后的值。
//
//
//
//    示例 1：
//
//    输入：n = 1, a = 2, b = 3
//    输出：2
//    示例 2：
//
//    输入：n = 4, a = 2, b = 3
//    输出：6

    public static void main(String[] args) {

    }
}
