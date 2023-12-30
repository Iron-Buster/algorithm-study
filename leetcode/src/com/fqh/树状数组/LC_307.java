package com.fqh.树状数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 00:12
 **/
public class LC_307 {

    class NumArray {

        FenwickTree ft;
        int[] a;

        public NumArray(int[] nums) {
            int n = nums.length;
            a = nums;
            ft = new FenwickTree(n + 1);
            for (int i = 0; i < n; i++) {
                ft.change(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            ft.change(index + 1, val - a[index]);
            a[index] = val;
        }

        public int sumRange(int left, int right) {
            return ft.query(right + 1) - ft.query(left);
        }

        // 树状数组模板
        class FenwickTree {
            int n;
            int[] s = new int[30001]; // 区间和
            int[] a = new int[30001];

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
    }

    //    307. 区域和检索 - 数组可修改
//            已解答
//    中等
//            相关标签
//    相关企业
//    给你一个数组 nums ，请你完成两类查询。
//
//    其中一类查询要求 更新 数组 nums 下标对应的值
//    另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
//    实现 NumArray 类：
//
//    NumArray(int[] nums) 用整数数组 nums 初始化对象
//    void update(int index, int val) 将 nums[index] 的值 更新 为 val
//    int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]）

}
