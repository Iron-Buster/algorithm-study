package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 14:11
 **/
public class LC_1964 {

    public int[] longestObstacleCourseAtEachPosition(int[] a) {
        int n = a.length;
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : a) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer index = map.get(a[i]);
            int res = ft.query(index);
            ans[i] = res + 1;
            ft.change(index, res + 1);
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和
        int[] a = new int[100005];

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n) {
                s[x] = Math.max(s[x], k); // 这里维护前缀最大值
                x += lowbit(x);
            }
        }

        public int query(int x) { // 向前查（前缀和）
            int res = 0;
            while (x > 0) {
                res = Math.max(res, s[x]);
                x -= lowbit(x);
            }
            return res;
        }
    }

    //    1964. 找出到每个位置为止最长的有效障碍赛跑路线
//    第 253 场周赛
//            Q4
//1933
//    相关标签
//            相关企业
//    提示
//    你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
//
//    对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
//
//    你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
//    在这条路线中，必须包含第 i 个障碍。
//    你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
//    除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
//    返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
// 树状数组维护前缀最大值

//    示例 1：
//
//    输入：obstacles = [1,2,3,2]
//    输出：[1,2,3,3]
//    解释：每个位置的最长有效障碍路线是：
//            - i = 0: [1], [1] 长度为 1
//            - i = 1: [1,2], [1,2] 长度为 2
//            - i = 2: [1,2,3], [1,2,3] 长度为 3
//            - i = 3: [1,2,3,2], [1,2,2] 长度为 3
}
