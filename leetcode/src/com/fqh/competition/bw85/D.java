package com.fqh.competition.bw85;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/24 17:04
 * @Version V1.0
 */
public class D {

//    2382. 删除操作后的最大子段和
//    第 85 场双周赛
//            Q4
//2136
//    相关标签
//            相关企业
//    提示
//    给你两个下标从 0 开始的整数数组 nums 和 removeQueries ，两者长度都为 n 。对于第 i 个查询，nums 中位于下标 removeQueries[i] 处的元素被删除，将 nums 分割成更小的子段。
//
//    一个 子段 是 nums 中连续 正 整数形成的序列。子段和 是子段中所有元素的和。
//
//    请你返回一个长度为 n 的整数数组 answer ，其中 answer[i]是第 i 次删除操作以后的 最大 子段和。
//
//    注意：一个下标至多只会被删除一次。
//
//
//
//    示例 1：
//
//    输入：nums = [1,2,5,6,1], removeQueries = [0,3,2,4,1]
//    输出：[14,7,2,2,0]
//    解释：用 0 表示被删除的元素，答案如下所示：
//    查询 1 ：删除第 0 个元素，nums 变成 [0,2,5,6,1] ，最大子段和为子段 [2,5,6,1] 的和 14 。
//    查询 2 ：删除第 3 个元素，nums 变成 [0,2,5,0,1] ，最大子段和为子段 [2,5] 的和 7 。
//    查询 3 ：删除第 2 个元素，nums 变成 [0,2,0,0,1] ，最大子段和为子段 [2] 的和 2 。
//    查询 4 ：删除第 4 个元素，nums 变成 [0,2,0,0,0] ，最大子段和为子段 [2] 的和 2 。
//    查询 5 ：删除第 1 个元素，nums 变成 [0,0,0,0,0] ，最大子段和为 0 ，因为没有任何子段存在。
//    所以，我们返回 [14,7,2,2,0] 。
//    示例 2：
//
//    输入：nums = [3,2,11,1], removeQueries = [3,2,1,0]
//    输出：[16,5,3,0]
//    解释：用 0 表示被删除的元素，答案如下所示：
//    查询 1 ：删除第 3 个元素，nums 变成 [3,2,11,0] ，最大子段和为子段 [3,2,11] 的和 16 。
//    查询 2 ：删除第 2 个元素，nums 变成 [3,2,0,0] ，最大子段和为子段 [3,2] 的和 5 。
//    查询 3 ：删除第 1 个元素，nums 变成 [3,0,0,0] ，最大子段和为子段 [3] 的和 3 。
//    查询 5 ：删除第 0 个元素，nums 变成 [0,0,0,0] ，最大子段和为 0 ，因为没有任何子段存在。
//    所以，我们返回 [16,5,3,0]

    /**
     逆序并查集
     先将所有点删除，再倒序连接，维护最大和
     */
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        var u = new InReverseUnionFind(n);
        for (int i = 0; i < n; ++i) {
            u.sum[i] = nums[i];
        }
        int m = removeQueries.length;
        long[] res = new long[m];
        long ans = 0;
        for (int i = m - 1; i >= 0; --i) {
            res[i] = ans;
            int q = removeQueries[i];
            u.vis[q] = true;
            if (q - 1 >= 0 && u.vis[q - 1]) {
                u.merge(q, q - 1);
            }
            if (q + 1 < n && u.vis[q + 1]) {
                u.merge(q, q + 1);
            }
            ans = Math.max(ans, u.sum[u.find(q)]);
        }
        return res;
    }

    static class InReverseUnionFind {
        int[] fa;
        long[] sum;      // sum[i]表示第i个集合的和
        boolean[] vis;  // 标记第i个数是否已添加

        public InReverseUnionFind(int n) {
            this.fa = new int[n]; // n大小从1开始 -> n+1
            this.sum = new long[n];
            this.vis = new boolean[n];
            for (int i = 0; i < n; ++i) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int x, int y) {
            int f_x = find(x);
            int f_y = find(y);
            if (f_x != f_y) {
                fa[f_y] = f_x;
                sum[f_x] += sum[f_y];
            }
        }
    }


    public static void main(String[] args) {
//        nums = [1,2,5,6,1], removeQueries = [0,3,2,4,1]
        int[] nums = {1,2,5,6,1};
        int[] removeQueries = {0,3,2,4,1};
        long[] res = new D().maximumSegmentSum(nums, removeQueries);
        System.out.println(Arrays.toString(res));
    }
}
