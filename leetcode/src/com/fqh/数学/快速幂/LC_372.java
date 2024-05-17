package com.fqh.数学.快速幂;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/17 21:58
 **/
public class LC_372 {


//    https://leetcode.cn/problems/super-pow/description/

//    见py_code

//    static final int MOD = 1337;
//
//    public int superPow(int a, int[] b) {
//        int k = 0;
//        for (int x : b) k = k * 10 + x;
//        return ksmM(a, k, MOD);
//    }
//
//    // 取模快速幂
//    static int ksmM(int x, int n, int p) {
//        x %= p;
//        int res = 1;
//        while (n > 0) {
//            if (n % 2 > 0) {
//                res = res * x % p;
//            }
//            x = x * x % p;
//            n /= 2;
//        }
//        return res;
//    }
}
