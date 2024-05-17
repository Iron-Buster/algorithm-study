package com.fqh.数学.快速幂;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/17 21:42
 **/
public class LC_50 {

    // https://leetcode.cn/problems/powx-n/description/


    public double myPow(double x, int n) {
        return ksm(x, n);
    }

    // 快速幂
    static double ksm(double x, long n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1, t = x;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x;
            }
            x = x * x;
            n /= 2;
        }
        return res;
    }


}
