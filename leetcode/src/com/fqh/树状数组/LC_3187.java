package com.fqh.树状数组;

import java.util.*;



public class LC_3187 {


    class Solution {
      public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
          int n = nums.length;
          FenwickTree ft = new FenwickTree(n + 1);
          for (int i = 1; i < n - 1; i++) {
              if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                  ft.change(i, 1);
              }
          }
          var ans = new ArrayList<Integer>();
          for (int[] q : queries) {
              int op = q[0];
              if (op == 1) {
                  int l = q[1], r = q[2];
                  ans.add(ft.rangeQuery(l + 1, r - 1));
              } else {
                  int i = q[1], val = q[2];
                  for (int j = Math.max(i - 1, 1); j <= Math.min(i + 1, n - 2); j++) {
                      if (nums[j] > nums[j-1] && nums[j] > nums[j+1]) ft.change(j, -1);
                  }
                  nums[i] = val;
                  for (int j = Math.max(i - 1, 1); j <= Math.min(i + 1, n - 2); j++) {
                      if (nums[j] > nums[j-1] && nums[j] > nums[j+1]) ft.change(j, 1);
                  }
              }
          }
          return ans;
      }
  
  
      class FenwickTree {
          int n;
          int[] s = new int[100005]; // 区间和
  
          public FenwickTree(int n) {
              this.n = n;
              //如果s是维护前缀最值，那么需要初始化s = -INF
  //        for (int i = 0; i <= n; i++) {
  //            s[i] = Integer.MIN_VALUE;
  //        }
          }
  
          public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
              return x & -x;
          }
  
          public void change(int x, int k) {    // 向后修
              while (x <= n) {
                  s[x] += k;
                  s[x] = Math.max(s[x], 0);
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
  
          public int rangeQuery(int l, int r) { // 区间查询
              if (r < l) return 0;
              return query(r) - query(l - 1);
          }
      }
  }
}
