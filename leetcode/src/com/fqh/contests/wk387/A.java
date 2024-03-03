package com.fqh.contests.wk387;

import java.util.ArrayList;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 12:12
 **/
public class A {

    public int[] resultArray(int[] nums) {
        var a = new ArrayList<Integer>();
        var b = new ArrayList<Integer>();
        a.add(nums[0]);
        b.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (a.get(a.size() - 1) > b.get(b.size() - 1)) {
                a.add(nums[i]);
            } else {
                b.add(nums[i]);
            }
        }
        a.addAll(b);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) ans[i] = a.get(i);
        return ans;
    }
}
