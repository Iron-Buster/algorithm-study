package com.fqh.数据结构设计;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/4/23 23:41
 **/
public class LC_1381 {


//    https://leetcode.cn/problems/design-a-stack-with-increment-operation/description/

    class CustomStack {
        int maxSize;
        int size;
        FenwickTree ft;

        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            this.ft = new FenwickTree(maxSize);
        }

        public void push(int x) {
            if (size < maxSize) {
                size++;
                ft.change(size, x);
                ft.change(size + 1, -x);
            }
        }

        public int pop() {
            if (size <= 0) return -1;
            int val = ft.query(size);
            ft.change(size, -val);
            ft.change(size + 1, val);
            size--;
            return val;
        }

        // [1,k]区间修改
        public void increment(int k, int val) {
            int r = Math.min(k, size);
            ft.change(1, val);
            ft.change(r + 1, -val);
        }
    }

    class FenwickTree {
        int n;
        int[] s = new int[1005]; // 区间和

        public FenwickTree(int n) {
            this.n = n;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) { // 向后修
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

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
