package com.fqh.competition.bw119;

import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/12/9 15:41
 * @Version V1.0
 */
public class A {

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for (int x : nums1) set.add(x);
        var set2 = new HashSet<Integer>();
        for (int x : nums2) set2.add(x);
        int[] ans = new int[2];
        for (int i = 0; i < nums1.length; ++i) {
            int x = nums1[i];
            if (set2.contains(x)) {
                ans[0] = i;
                break;
            }
        }
        for (int i = 0; i < nums2.length; ++i) {
            int y = nums2[i];
            if (set.contains(y)) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
