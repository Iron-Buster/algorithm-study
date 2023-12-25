package com.fqh.哈希表;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: vq
 * @Date: 2023/12/25 17:06
 * @Version V1.0
 */
public class LC_2975 {

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        int[] a = new int[hFences.length + 2];
        for (int i = 0; i < hFences.length; i++) {
            a[i + 1] = hFences[i];
        }
        a[hFences.length] = m;
        int[] b = new int[vFences.length + 2];
        for (int i = 0; i < vFences.length; i++) {
            b[i + 1] = vFences[i];
        }
        b[vFences.length] = n;

        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();

        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                set1.add(hFences[j] - hFences[i]);
            }
        }
        for (int i = 0; i < vFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                set2.add(vFences[j] - vFences[i]);
            }
        }
        int ans = 0;
        for (int x : set1) {
            if (set2.contains(x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans * ans % 1000000007;
    }

//    2975. 移除栅栏得到的正方形田地的最大面积
//            中等
//    相关企业
//            提示
//    有一个大型的 (m - 1) x (n - 1) 矩形田地，其两个对角分别是 (1, 1) 和 (m, n) ，田地内部有一些水平栅栏和垂直栅栏，分别由数组 hFences 和 vFences 给出。
//
//    水平栅栏为坐标 (hFences[i], 1) 到 (hFences[i], n)，垂直栅栏为坐标 (1, vFences[i]) 到 (m, vFences[i]) 。
//
//    返回通过 移除 一些栅栏（可能不移除）所能形成的最大面积的 正方形 田地的面积，或者如果无法形成正方形田地则返回 -1。
//
//    由于答案可能很大，所以请返回结果对 109 + 7 取余 后的值。
//
//    注意：田地外围两个水平栅栏（坐标 (1, 1) 到 (1, n) 和坐标 (m, 1) 到 (m, n) ）
//    以及两个垂直栅栏（坐标 (1, 1) 到 (m, 1) 和坐标 (1, n) 到 (m, n) ）所包围。这些栅栏 不能 被移除。

//    输入：m = 4, n = 3, hFences = [2,3], vFences = [2]
//    输出：4
//    解释：移除位于 2 的水平栅栏和位于 2 的垂直栅栏将得到一个面积为 4 的正方形田地。

//    3 <= m, n <= 109
//            1 <= hFences.length, vFences.length <= 600
//            1 < hFences[i] < m
//            1 < vFences[i] < n
//    hFences 和 vFences 中的元素是唯一的。
}
