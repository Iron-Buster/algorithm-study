package com.fqh.contests.wk373;

/**
 * @Author: vq
 * @Date: 2023/11/25 23:35
 * @Version V1.0
 */
public class A {

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        k %= n;
        if (k == 0) {
            // 整个矩阵是不变的
            return true;
        }
        for (int[] r : mat) {
            for (int j = 0; j < n; ++j) {
                if (r[j] != r[(j + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
