package com.fqh.contests.wk416;

public class B {

    // https://leetcode.cn/problems/minimum-number-of-seconds-to-make-mountain-height-zero/description/
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 0;
        long r = (long) 1e16;
        while (l < r) {
            long mid = (l + r) / 2;
            long tot = 0;
            for (int wtime : workerTimes) {
                tot += calc(mid, wtime, mountainHeight);
                if (tot >= mountainHeight) break;
            }
            if (tot >= mountainHeight) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 二分计算一个工人在给定时间内能减少的最大高度
    long calc(long time, int wtime, int h) {
        long l = 0;
        long r = h;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            // wtime * (1 + 2 + 3 + ... + x) 公差为mid
            // 等差数列求和：项数 * (首项 + 尾项) / 2
            // mid * (wtime + wtime * mid) / 2
            // 变形为 wtime * mid * (mid + 1) / 2
            if ((long) wtime * mid * (mid + 1) / 2 <= time) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
