package com.fqh.哈希表;

import java.util.HashMap;

public class LC_3185 {


    // https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/description/?envType=daily-question&envId=2024-10-23

    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        var map = new HashMap<Integer, Integer>();
        for (int x : hours) {
            int r = x % 24;
            int c = (24 - r) % 24;
            ans += map.getOrDefault(c, 0);
            map.merge(r, 1, Integer::sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] hs = {11, 13};
        System.out.println(new LC_3185().countCompleteDayPairs(hs));
    }
}
