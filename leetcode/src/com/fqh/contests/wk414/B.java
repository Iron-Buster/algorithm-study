package com.fqh.contests.wk414;

import java.util.Arrays;

public class B {

    // https://leetcode.cn/contest/weekly-contest-414/problems/maximize-score-of-numbers-in-ranges/
    // 二分答案
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        long l = 0;
        long r = (long) (1e18 + 1);

        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(start, d, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    boolean check(int[] start, int d, long mid) {
        // 0, 3, 6
        // [0, 2], [3, 5], [6, 8]
        long prev = start[0];
        for (int i = 1; i < start.length; i++) {
            long cur = Math.max(start[i], prev + mid);
            if (cur > start[i] + d) {
                return false;
            }
            prev = cur;
        }
        return true;
    }
}
