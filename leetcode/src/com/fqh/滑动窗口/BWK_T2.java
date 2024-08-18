package com.fqh.滑动窗口;

//https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/

public class BWK_T2 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        var tset = new TreeSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        int pre = nums[0] - 1;
        int kcnt = 0; // 标记一个场长度为k的子数组连续上升的元素个数
        int j = 0;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (nums[i] == pre + 1) kcnt++;
            tset.add(nums[i]);
            map.merge(nums[i], 1, Integer::sum);
            if (i - j + 1 == k) {
                if (kcnt == k) {
                    ans[j] = tset.last();
                } else {
                    ans[j] = -1;
                }
                map.merge(nums[j], -1, Integer::sum);
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                    tset.remove(nums[j]);
                }
                if (j + 1 < n && nums[j] + 1 == nums[j+1]) kcnt--;
                j++;
                
            } 
            pre = nums[i];
        }
        return ans;
    }
}
