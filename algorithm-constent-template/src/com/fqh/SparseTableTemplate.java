package com.fqh;

/**
 * ST表模板
 * O(1)求区间（最大 & 最小）值
 */
public class SparseTableTemplate {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 7, 9, 11};
        SparseTable st = new SparseTable(arr);

        // 查询区间 [1, 4] 的最大值
        System.out.println(st.query(1, 4)); // 输出 9
    }
}

class SparseTable {
    private int[][] st; // st[i][j] 表示区间 [i, i + 2^j - 1] 的最大值
    private int[] log;
    private int n;

    public SparseTable(int[] arr) {
        n = arr.length;
        int logN = Integer.highestOneBit(n) * 2 - 1; // log2(n)
        log = new int[n + 1];
        st = new int[n][logN + 1];

        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        for (int i = 0; i < n; i++) {
            st[i][0] = arr[i];
        }

        // 构建 st表
        for (int j = 1; (1 << j) <= n; j++) {
            for (int i = 0; i + (1 << j) - 1 < n; i++) {
                st[i][j] = Math.max(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    // 查询区间 [L, R] 的最大值
    public int query(int L, int R) {
        int j = log[R - L + 1];
        return Math.max(st[L][j], st[R - (1 << j) + 1][j]);
    }
}