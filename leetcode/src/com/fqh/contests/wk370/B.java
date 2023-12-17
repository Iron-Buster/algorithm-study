package com.fqh.contests.wk370;

/**
 * @Author: vq
 * @Date: 2023/11/4 21:18
 * @Version V1.0
 */
public class B {


    public int findChampion(int n, int[][] edges) {
        var rd = new int[n];
        for (var e : edges) {
            int x = e[0], y = e[1];
            rd[y]++;
        }
        boolean ok = false;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            if (rd[i] == 0) {
                if (ok) return -1;
                ok = true;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
