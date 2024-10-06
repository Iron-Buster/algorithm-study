package com.fqh.图论.BFS;

import java.util.*;

public class LC_3310 {

    // https://leetcode.cn/problems/remove-methods-from-project/description/

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] inv : invocations) {
            int a = inv[0];
            int b = inv[1];
            g[a].add(b);
        }
        var set = new HashSet<Integer>();
        var q = new ArrayDeque<Integer>();
        q.offer(k);
        set.add(k);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (!set.contains(v)) {
                    q.offer(v);
                    set.add(v);
                }
            }
        }
        var ans = new ArrayList<Integer>();
        for (int[] inv : invocations) {
            int a = inv[0];
            int b = inv[1];
            if (set.contains(b) && !set.contains(a)) {
                for (int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;

    }
}
