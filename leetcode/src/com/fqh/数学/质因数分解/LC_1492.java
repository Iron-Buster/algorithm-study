package com.fqh.数学.质因数分解;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/4 23:43
 **/
public class LC_1492 {

    static int s;
    public int kthFactor(int n, int k) {
        List<Integer> divisors = primeDivisors(n);
        return s < k ? -1 : divisors.get(k-1);
    }

    // 分解因数
    public static List<Integer> primeDivisors(int x) {
        s = 0;
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0) { // 如果 i 能够整除 x，说明 i 为 x 的一个质因子。
                primes.add(i);
                s++;
            }
        }
        s++;
        primes.add(x);
        return primes;
    }


//    1492. n 的第 k 个因子
//    第 29 场双周赛
//            Q2
//1232
//    相关标签
//            相关企业
//    提示
//    给你两个正整数 n 和 k 。
//
//    如果正整数 i 满足 n % i == 0 ，那么我们就说正整数 i 是整数 n 的因子。
//
//    考虑整数 n 的所有因子，将它们 升序排列 。请你返回第 k 个因子。如果 n 的因子数少于 k ，请你返回 -1 。
}
