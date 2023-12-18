package com.fqh.前缀和.前缀异或和;

import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/18 21:51
 * @Version V1.0
 */
public class LC_1738 {


    // 二维前缀异或和 + 优先队列
    public int kthLargestValue(int[][] a, int k) {
        int n = a.length;
        int m = a[0].length;
        int[][] sum = new int[n + 1][m + 1];
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int v = a[i][j];
                sum[i + 1][j + 1] = sum[i + 1][j] ^ sum[i][j + 1] ^ sum[i][j] ^ v;
                if (pq.size() < k) {
                    pq.offer(sum[i + 1][j + 1]);
                } else {
                    if (sum[i + 1][j + 1] > pq.peek()) {
                        pq.poll();
                        pq.offer(sum[i + 1][j + 1]);
                    }
                }
            }
        }
        return pq.peek();
    }

//    1738. 找出第 K 大的异或坐标值
//    第 225 场周赛
//            Q3
//1671
//    相关标签
//            相关企业
//    提示
//    给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
//
//    矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
//
//    请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
}
