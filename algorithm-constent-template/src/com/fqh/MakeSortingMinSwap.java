package com.fqh;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/23 16:00
 **/
public class MakeSortingMinSwap {

    // 计算将数组排序的最小交换次数
    // 最少交换次数 = 节点数n - 形成的环数

    public static int getMinSwaps(int[] nums) {
        var nums1 = nums.clone();
        Arrays.sort(nums1);
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i); // 建立每个元素与其应放位置的映射
        }
        int r = 0;
        var vis = new boolean[n];
        // 找出交换环的个数
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    j = map.get(nums[j]); // 原序列中j的位置在有序序列中的位置
                }
                r++;
            }
        }
        return n - r;
    }
}
