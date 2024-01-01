package com.fqh.二分答案;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 17:08
 **/
public class LC_1552 {

    public int maxDistance(int[] p, int m) {
        long l = 0;
        long r = (long) 1e14;
        Arrays.sort(p);
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(mid, m, p)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    // check 当磁力为x时，能否将m个小球放完
    public boolean check(long x, int m, int[] p) {
        int j = 0;
        int cnt = 0;
        for (int i = 1; i < p.length; i++) {
            if (Math.abs(p[j] - p[i]) >= x) {
                cnt += 1;
                j = i;
            }
        }
        return cnt + 1 >= m;
    }

//    1552. 两球之间的磁力
//            已解答
//    第 202 场周赛
//            Q3
//1920
//    相关标签
//            相关企业
//    提示
//    在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
//
//    已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
//
//    给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。

//    输入：position = [1,2,3,4,7], m = 3
//    输出：3
//    解释：将 3 个球分别放入位于 1，4 和 7 的三个篮子，两球间的磁力分别为 [3, 3, 6]。最小磁力为 3 。我们没办法让最小磁力大于 3 。
}
