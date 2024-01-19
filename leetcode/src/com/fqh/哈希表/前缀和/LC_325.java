package com.fqh.哈希表.前缀和;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 00:15
 **/
public class LC_325 {

//    325. 和等于 k 的最长子数组长度
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
//

//    示例 1:
//
//    输入: nums = [1,-1,5,-2,3], k = 3
//    输出: 4
//    解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。

    // 哈希表 + 前缀和
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int ans = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += nums[i];
            if (map.containsKey(s - k)) {
                int j = map.get(s - k);
                ans = Math.max(ans, i - j);
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }
        }
        return ans;
    }
}
