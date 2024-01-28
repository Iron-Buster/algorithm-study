package com.fqh.contests.wk382;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/28 10:25
 **/
public class B {

    public int maximumLength(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        for (int x : nums) map.merge(x, 1, Integer::sum);
        Integer c1 = map.remove(1);
        int ans = c1 != null ? c1 - (c1 % 2 ^ 1) : 0;
        for (int x : map.keySet()) {
            long res = 0;
            for (; map.getOrDefault(x, 0) > 1; x *= x) {
                res += 2;
            }
            ans = (int) Math.max(ans, res + (map.containsKey(x) ? 1 : -1)); // 保证 res 是奇数
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] a = {14,14,196,196,38416,38416};
        System.out.println(new B().maximumLength(a));
    }
}
