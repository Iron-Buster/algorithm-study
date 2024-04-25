package com.fqh.滑动窗口;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/25 23:12
 **/
public class MST1718 {

    // https://leetcode.cn/problems/shortest-supersequence-lcci/description/

    public int[] shortestSeq(int[] big, int[] small) {
        int l = -1, r = 100001;
        var map = new HashMap<Integer, Integer>();
        for (int x : small) map.merge(x, 1, Integer::sum);
        int valid = small.length;
        int j = 0;
        for (int i = 0; i < big.length; i++) {
            int x = big[i];
            if (map.getOrDefault(x, 0) > 0) {
                valid -= 1;
            }
            map.merge(x, -1, Integer::sum); // 不在small里面的数字cnt一定 < 0
            if (valid == 0) { // 一个合法的区间
                // 尝试缩小区间，注意只移除不在small里面的数字，也就是map[x] < 0的数字
                while (j < i && map.get(big[j]) < 0) {
                    map.merge(big[j], 1, Integer::sum);
                    j++;
                }
                if (i - j < r - l) {
                    r = i;
                    l = j;
                }
                // j一定是在small里面的数字，将map[big[j]]++ valid++
                map.merge(big[j], 1, Integer::sum);
                j++;
                valid++;
            }
        }
        if (l == -1 || r == 100001) return new int[0];
        return new int[]{l, r};
    }
}
