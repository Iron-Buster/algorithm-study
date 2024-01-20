package com.fqh.前缀和;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 12:26
 **/
public class LC_1788 {
//    1788. 最大化花园的美观度
//            困难
//    相关标签
//            相关企业
//    提示
//    有一个花园，有 n 朵花，这些花都有一个用整数表示的美观度。这些花被种在一条线上。给定一个长度为 n 的整数类型数组 flowers ，每一个 flowers[i] 表示第 i 朵花的美观度。
//
//    一个花园满足下列条件时，该花园是有效的。
//
//    花园中至少包含两朵花。
//    第一朵花和最后一朵花的美观度相同。
//    作为一个被钦定的园丁，你可以从花园中去除任意朵花（也可以不去除任意一朵）。你想要通过一种方法移除某些花朵，使得剩下的花园变得有效。花园的美观度是其中所有剩余的花朵美观度之和。
//
//    返回你去除了任意朵花（也可以不去除任意一朵）之后形成的有效花园中最大可能的美观度。
//
//
//
//    示例 1：
//
//    输入: flowers = [1,2,3,1,2]
//    输出: 8
//    解释: 你可以修整为有效花园 [2,3,1,2] 来达到总美观度 2 + 3 + 1 + 2 = 8。
//    示例 2：
//
//    输入: flowers = [100,1,1,-3,1]
//    输出: 3
//    解释: 你可以修整为有效花园 [1,1,1] 来达到总美观度 1 + 1 + 1 = 3。

    // 下标分组 + 前缀和枚举
    public int maximumBeauty(int[] flowers) {
        // 将下标按照美观度分组
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i < flowers.length; i++) {
            group.computeIfAbsent(flowers[i], v -> new ArrayList<>());
            group.get(flowers[i]).add(i);
        }
        int n = flowers.length;
        int[] s = new int[n+1];
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + Math.max(0, flowers[i]); // 小于零的不计入前缀和
        }
        int ans = Integer.MIN_VALUE;
        for (List<Integer> g : group.values()) {
            if (g.size() < 2) continue;
            int l = g.get(0);
            int r = g.get(g.size() - 1);
            if (flowers[l] > 0) { // 说明两端都是正数，直接取s[l:r+1]这端的前缀和即可
                ans = Math.max(ans, s[r+1] - s[l]);
            } else {
                // 说明两端是负数，那么中的前缀和取s[l+1:r]，这段的和一定>=0，因为负数没有入前缀和
                ans = Math.max(ans, 2 * flowers[l] + (s[r] - s[l+1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] flowers = {-1,-2,0,-1};
        System.out.println(new LC_1788().maximumBeauty(flowers));
    }
}
