package com.fqh.二分查找;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 17:09
 **/
public class LC_1182 {
//    1182. 与目标颜色间的最短距离
//    第 8 场双周赛
//            Q3
//1627
//    相关标签
//            相关企业
//    提示
//    给你一个数组 colors，里面有  1、2、 3 三种颜色。
//
//    我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。
//
//    现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。
//
//    如果不存在解决方案，请返回 -1。
//
//
//
//    示例 1：
//
//    输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//    输出：[3,0,3]
//    解释：
//    距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//    距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//    距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。


    // 下标分组 + 二分查找（这里使用平衡树代替）
    public List<Integer> shortestDistanceColor(int[] c, int[][] queries) {
        Map<Integer, TreeSet<Integer>> group = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            group.computeIfAbsent(c[i], v -> new TreeSet<>());
            group.get(c[i]).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int idx = q[0];
            TreeSet<Integer> tset = group.get(q[1]);
            if (tset == null) {
                ans.add(-1);
                continue;
            }
            Integer ceiling = tset.ceiling(idx);
            Integer floor = tset.floor(idx);
            int v = Integer.MAX_VALUE;
            if (ceiling != null) v = Math.min(v, ceiling - idx);
            if (floor != null) v = Math.min(v, idx - floor);
            ans.add(v == Integer.MAX_VALUE ? -1 : v);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] colors = {1,1,2,1,3,2,2,3,3};
        int[][] queries = {{1,3},{2,2},{6,1}};
        System.out.println(new LC_1182().shortestDistanceColor(colors, queries));
    }
}
