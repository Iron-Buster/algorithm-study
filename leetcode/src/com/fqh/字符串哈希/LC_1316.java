package com.fqh.字符串哈希;

import java.util.HashSet;

public class LC_1316 {


    public static void main(String[] args) {
        String text = "abcabcabc";
        System.out.println(new LC_1316().distinctEchoSubstrings(text));
    }

    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        var hash = new StringHash(n, 0, text);
        hash.init();
        int ans = 0;
        // 枚举每个偶数长度的字符串
        var set = new HashSet<Long>();
        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i + len - 1 < n; i++) {
                int l = i + 1, r = i + len;
                int mid = l + r >> 1;
                long hv1 = hash.get(l, mid);
                if (hash.substr(l, mid, mid + 1, r) && !set.contains(hv1)) {
                    ans++;
                    set.add(hv1);
                }
            }
        }
        return ans;
    }


    class StringHash {
        static final int N = 2010;
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
        }
    }
}
