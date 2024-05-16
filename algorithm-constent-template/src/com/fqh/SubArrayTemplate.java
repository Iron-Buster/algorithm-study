package com.fqh;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/16 23:57
 **/


/**
 * 子数组问题模板
 */
public class SubArrayTemplate {


    /**
     * O(N) 计算所有的非空子数组和
     * @param a
     */
    public static long subArraySum(long[] a) {
        long sum = 0;
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            // 累加每个a[i]的贡献
            sum += (a[i] * (i + 1) * (n - i));
        }
        return sum;
    }
}
