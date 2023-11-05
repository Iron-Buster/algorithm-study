package com.fqh.competition.wk370;

import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/11/4 21:18
 * @Version V1.0
 */
public class A {


    public int findChampion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var set = new HashSet<Integer>();
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (grid[i][j] == 1) {
                    set.add(j);
                } else {
                    set.add(i);
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (!set.contains(i)) return i;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
