package com.fqh.math.容斥原理;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 15:08
 **/
public class LC_1201 {

    // 设能被a整除的数字集合大小为A
    // 设能被b整除的数字集合大小为B
    // 设能被c整除的数字集合大小为C
    // 容斥原理 |AUBUC| = |A| + |B| + |C| - |A∩B| - |A∩C| - |B∩C| + |A∩B∩C|
    public int nthUglyNumber(int n, int a, int b, int c) {
        long v1 = lcm(a, b);
        long v2 = lcm(a, c);
        long v3 = lcm(b, c);
        long v4 = lcm(a, (int) v3);
        long l = 0, r = (long) 1e27;
        while (l < r) {
            long mid = (l + r) >> 1;
            if (mid / a + mid / b + mid / c - mid / v1 - mid / v2 - mid / v3 + mid / v4 < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return (int) l;
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

//    1201. 丑数 III
//    已解答
//    第 155 场周赛
//            Q2
//2039
//    相关标签
//            相关企业
//    提示
//    给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
//
//    丑数是可以被 a 或 b 或 c 整除的 正整数 。
//
//
//
//    示例 1：
//
//    输入：n = 3, a = 2, b = 3, c = 5
//    输出：4
//    解释：丑数序列为 2, 3, 4, 5, 6, 8, 9, 10... 其中第 3 个是 4。

}
