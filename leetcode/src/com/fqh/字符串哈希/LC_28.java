package com.fqh.字符串哈希;

public class LC_28 {

    // https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        var hash1 = new StringHash(n1, 0, haystack);
        var hash2 = new StringHash(n2, 0, needle);
        for (int i = 0; i + n2 - 1 < n1; i++) {
            int l = i + 1, r = i + n2;
            if (hash1.get(l, r) == hash2.get(1, n2)) {
                return i;
            }
        }
        return -1;
    }


    class StringHash {
        static final int N = 10010;
        static final int P = 131;
        int n, m;
        // p[i]=P^i, h[i]=s[1~i]的hash值
        long[] p = new long[N];
        long[] h = new long[N];
        char[] s = new char[N];

        // 预处理 hash函数的前缀和
        void init() {
            p[0] = 1;
            h[0] = 0;
            for(int i = 1; i <= n; i ++){
                p[i] = p[i-1]*P;
                h[i] = h[i-1]*P+s[i];
            }
        }

        // 计算s[l~r]的 hash值
        long get(int l, int r) {
            return h[r]-h[l-1]*p[r-l+1];
        }

        // 计算串的哈希值
        long calc(char[] s, int n) {
            h[0] = 0;
            for (int i = 1; i <= n; i++) {
                h[i] = h[i-1]*P+s[i];
            }
            return h[n];
        }

        // 判断两子串是否相同
        boolean substr(int l1,int r1,int l2,int r2){
            return get(l1, r1) == get(l2, r2);
        }

        public StringHash(int n, int m, String str) {
            this.n = n;
            this.m = m;
            for (int i = 0; i < n; i++) {
                s[i+1] = str.charAt(i);
            }
            init();
        }
    }

}
