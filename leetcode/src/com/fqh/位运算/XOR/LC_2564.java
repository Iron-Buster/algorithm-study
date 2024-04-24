package com.fqh.位运算.XOR;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/24 22:24
 **/
public class LC_2564 {

//    https://leetcode.cn/problems/substring-xor-queries/description/

    // 预处理出s的所有子串数字
    // val ^ first == second -> val == first ^ second
    public int[][] substringXorQueries(String s, int[][] queries) {
        var map = new HashMap<Integer, int[]>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int up = Math.min(n, i + 31);
            int x = 0;
            for (int j = i; j < up; j++) {
                x |= (s.charAt(j) - '0');
//                int x = Integer.parseInt(s.substring(i, j + 1), 2);
                int[] b = map.get(x);
                if (b == null || b[1] - b[0] > j - i) {
                    map.put(x, new int[]{i, j});
                }
                x = x << 1;
            }
        }
        int m = queries.length;
        var ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            ans[i] = map.getOrDefault(first ^ second, new int[]{-1, -1});
        }
        return ans;
    }
}
