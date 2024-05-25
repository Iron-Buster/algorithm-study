package com.fqh.contests.bw131;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/25 23:31
 **/
public class C {

    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        var ans = new int[n];
        var map = new HashMap<Integer, Integer>();
        var map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (map.containsKey(x)) {
                Integer c = map.get(x);
                map2.merge(c, -1, Integer::sum);
                if (map2.get(c) == 0) map2.remove(c);
            }
            map2.merge(y, 1, Integer::sum);
            map.put(x, y);
            ans[i] = map2.size();
        }
        return ans;
    }
}
