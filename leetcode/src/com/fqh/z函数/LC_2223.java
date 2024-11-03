package com.fqh.z函数;

import java.util.Arrays;

public class LC_2223 {

    // https://leetcode.cn/problems/sum-of-scores-of-built-strings/description/



    public long sumScores(String s) {
        ZFunc zFunc = new ZFunc(s);
        int[] z = zFunc.getZ();
        return Arrays.stream(z).sum();
    }


    class ZFunc {
        char[] s;

        public ZFunc(String str) {
            this.s = str.toCharArray();
        }
        // z[i]表示 s[i:]与s的LCP(最长公共前缀)的长度
        public int[] getZ() {
            int n = s.length;
            int[] z = new int[n];
            for (int i = 0, l = 0, r = 0; i < n; i++) {
                if (i <= r && z[i - l] < r - i + 1) {
                    z[i] = z[i - 1];
                } else {
                    z[i] = Math.max(0, r - i + 1);
                    while (i + z[i] < n && s[z[i]] == s[i + z[i]]) z[i]++;
                }
                if (i + z[i] - 1 > r) {
                    l = i;
                    r = i + z[i] - 1;
                }
            }
            return z;
        }
    }

}
