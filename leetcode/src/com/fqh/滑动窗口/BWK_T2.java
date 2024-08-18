package com.fqh.滑动窗口;

//https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/

import java.util.Arrays;
import java.util.HashMap;

public class BWK_T2 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();
        int pre = nums[0] - 1;
        int kcnt = 0; // 标记一个场长度为k的子数组连续上升的元素个数
        int j = 0;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == pre + 1) kcnt++;
            map.merge(nums[i], 1, Integer::sum);
            if (i - j + 1 == k) {
                if (kcnt == k) ans[j] = nums[i]; // 既然是递增的那么nums[i]就是这一段最大的值
                map.merge(nums[j], -1, Integer::sum);
                if (map.get(nums[j]) == 0) map.remove(nums[j]);
                if (j + 1 < n && nums[j] + 1 == nums[j+1]) kcnt--;
                j++;
            }
            pre = nums[i];
        }
        return ans;
    }
}
