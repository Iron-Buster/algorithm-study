package com.fqh.contests.wk419;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class D {

    TreeSet<int[]> L = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]); // 维护出现次数前x大
    TreeSet<int[]> R = new TreeSet<>(L.comparator());
    Map<Integer, Integer> cnt = new HashMap<>();
    long sumL = 0;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] ans = new long[n - k + 1];
        for (int r = 0; r < nums.length; r++) {
            // 入
            int in = nums[r];
            del(in);
            cnt.merge(in, 1, Integer::sum);
            add(in);

            int l = r + 1 - k;
            if (l < 0) continue;

            while (!R.isEmpty() && L.size() < x) r2l();
            while (L.size() > x) l2r();
            ans[l] = sumL;
            // 出
            int out = nums[l];
            del(out);
            cnt.merge(out, -1, Integer::sum);
            add(out);
        }
        return ans;
    }

    void add(int val) {
        int c = cnt.getOrDefault(val, 0);
        if (c == 0) return;
        int[] p = new int[]{c, val};
        if (!L.isEmpty() && L.comparator().compare(p, L.first()) > 0) {
            sumL += (long) p[0] * p[1];
            L.add(p);
        } else {
            R.add(p);
        }
    }

    void del(int val) {
        int c = cnt.getOrDefault(val, 0);
        if (c == 0) return;
        int[] p = new int[]{c, val};
        if (L.contains(p)) {
            sumL -= (long) p[0] * p[1];
            L.remove(p);
        } else {
            R.remove(p);
        }
    }

    void l2r() {
        int[] p = L.pollFirst();
        sumL -= (long) p[0] * p[1];
        R.add(p);
    }

    void r2l() {
        int[] p = R.pollLast();
        sumL += (long) p[0] * p[1];
        L.add(p);
    }
}
