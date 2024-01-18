package com.fqh.树状数组;

import java.util.TreeMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/18 12:18
 **/
public class MST_10_10 {

//    面试题 10.10. 数字流的秩
//            中等
//    相关标签
//            相关企业
//    提示
//    假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
//
//    实现 track(int x) 方法，每读入一个数字都会调用该方法；
//
//    实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
//
//    注意：本题相对原题稍作改动
//
//    示例:
//
//    输入:
//            ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
//            [[], [1], [0], [0]]
//    输出:
//            [null,0,null,1]


    class StreamRank {
        FenwickTree ft = new FenwickTree(50010);

        public StreamRank() {

        }

        public void track(int x) {
            ft.change(x + 1, 1);    // 因为x会等于0，所以让x从1开始
        }

        public int getRankOfNumber(int x) {
            return ft.query(x + 1);
        }
    }

    class FenwickTree {
        int n;
        int[] s = new int[50010]; // 区间和

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
 * Your StreamRank object will be instantiated and called as such:
 * StreamRank obj = new StreamRank();
 * obj.track(x);
 * int param_2 = obj.getRankOfNumber(x);
 */
}
