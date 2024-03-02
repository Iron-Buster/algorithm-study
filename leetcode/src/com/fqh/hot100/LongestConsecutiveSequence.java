package com.fqh.hot100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 11:53
 **/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        var uf = new UnionFind(n);
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) map.put(nums[i], i);
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i] + 1)) {
                uf.merge(i, map.get(nums[i] + 1));
            }
        }
        int ans = 0;
        var count = new HashMap<Integer, Integer>();
        for (int idx : map.values()) {
            int fa = uf.find(idx);
            count.merge(fa, 1, Integer::sum);
            ans = Math.max(ans, count.get(fa));
        }
        return ans;
    }

    class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n]; // 如果n从1开始，则n+1
            for (int i = 0; i < n; i++) { // <= n
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            fa[rootB] = rootA;
        }
    }
}
