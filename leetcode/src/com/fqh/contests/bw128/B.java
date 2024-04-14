package com.fqh.contests.bw128;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/14 10:25
 **/
public class B {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int ans = 1;
        int endx = points[0][0];
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            if (x - endx > w) {
                endx = x;
                ans += 1;
            }
        }
        return ans;
    }
}
