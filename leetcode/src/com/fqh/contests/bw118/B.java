package com.fqh.contests.bw118;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/11/25 20:11
 * @Version V1.0
 */
public class B {

//    分组循环
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int size = Math.min(f(hBars), f(vBars));
        return size * size;
    }

    int f(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        int mx = 0, i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && a[i] - a[i - 1] == 1; i++) ;
            mx = Math.max(mx, i - st + 1);
        }
        return mx;
    }
    public static void main(String[] args) {

    }
}
