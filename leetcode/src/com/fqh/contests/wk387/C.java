package com.fqh.contests.wk387;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:14
 **/
public class C {

    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        var map = new HashMap<Integer, Integer>();
        int mid = (n / 2) + 1;
        int j = 0;
        int k = n - 1;
        var set = new HashSet<String>();
        int idx1 = 0;
        for (int i = 0; i < mid; i++) {
            if (j == k) {
                map.merge(grid[i][j], 1, Integer::sum);
            } else {
                map.merge(grid[i][j], 1, Integer::sum);
                map.merge(grid[i][k], 1, Integer::sum);
            }
            set.add(i + "_" + j);
            set.add(i + "_" + k);
            j++;
            k--;
            idx1 = i;
        }
        idx1++;
        j--;
        while (idx1 < n) {
            map.merge(grid[idx1][j], 1, Integer::sum);
            set.add(idx1 + "_" + j);
            idx1++;
        }

        var cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                String p = i + "_" + j;
                if (set.contains(p)) continue;
                cnt.merge(grid[i][j], 1, Integer::sum);
            }
        }
        int[] p = {0, 1, 2};
        int tot = n * n;
        int ans = Integer.MAX_VALUE;
        for (int x : p) {
            int need1 = set.size() - map.getOrDefault(x, 0);
            for (int y : p) {
                if (y == x) continue;
                int need2 = (tot - set.size()) - cnt.getOrDefault(y, 0);
                ans = Math.min(ans, need1 + need2);
            }
        }
        return ans;
    }
}
