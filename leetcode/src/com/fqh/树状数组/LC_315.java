package com.fqh.树状数组;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 12:03
 **/
public class LC_315 {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : nums) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        FenwickTree ft = new FenwickTree(tset.size() + 1);
        var ans = new ArrayList<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            Integer index = map.get(nums[i]);
            ft.change(index, 1);
            ans.add(ft.query(index - 1));
        }
        Collections.reverse(ans);
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
                s[x] += k;
                x += lowbit(x);
            }
        }
        public int query(int x) { // 向前查（前缀和）
            int t = 0;
            while (x > 0) {
                t += s[x];
                x -= lowbit(x);
            }
            return t;
        }
    }


//    315. 计算右侧小于当前元素的个数
//            困难
//    相关标签
//            相关企业
//    给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
//
//
//
//    示例 1：
//
//    输入：nums = [5,2,6,1]
//    输出：[2,1,1,0]
//    解释：
//            5 的右侧有 2 个更小的元素 (2 和 1)
//2 的右侧仅有 1 个更小的元素 (1)
//6 的右侧有 1 个更小的元素 (1)
//1 的右侧有 0 个更小的元素

    public static void main(String[] args) {

        int[] a = {5, 2, 6, 1};
        System.out.println(new LC_315().countSmaller(a));
    }
}
