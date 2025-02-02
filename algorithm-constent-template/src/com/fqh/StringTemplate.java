package com.fqh;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/6 16:26
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串算法相关模板
 */
public class StringTemplate {

    public static void main(String[] args) {
        String a = "ababab";
        String b = "ab";
        KMP kmp = new KMP();
        int count = kmp.matchCount(a, b);
        System.out.println(count);
        int firstIndex = kmp.matchFirstIndex(a, b);
        System.out.println(firstIndex);
        List<Integer> matchAllIndex = kmp.matchAllIndex(a, b);
        System.out.println(matchAllIndex);
    }
}

/**
 * 字符串哈希
 */
class StringHash {
    static final int N = 100010;
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
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * P;
            h[i] = h[i - 1] * P + s[i];
        }
    }

    // 计算s[l~r]的 hash值
    long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }

    // 计算串的哈希值
    long calc(char[] s, int n) {
        h[0] = 0;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i - 1] * P + s[i];
        }
        return h[n];
    }

    // 判断两子串是否相同
    boolean substr(int l1, int r1, int l2, int r2) {
        return get(l1, r1) == get(l2, r2);
    }

    public StringHash(int n, int m, String str) {
        this.n = n;
        this.m = m;
        for (int i = 0; i < n; i++) {
            s[i + 1] = str.charAt(i);
        }
        init();
    }
}

/**
 * KMP算法
 */
class KMP {

    char[] s;
    char[] p;
    int n, m;
    int[] next;

    public KMP() {
    }

    /**
     * 返回 b在a中匹配的第一次出现的位置
     */
    int matchFirstIndex(String a, String b) {
        this.n = a.length();
        this.m = b.length();
        a = " " + a;
        b = " " + b;

        this.s = a.toCharArray();
        this.p = b.toCharArray();
        this.next = new int[m + 1];

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) {
                j = next[j];
                return i - m;
            }
        }
        return -1;
    }

    /**
     * 返回 b在a中匹配的所有位置
     *
     * @return 如果这些下标会被用来查找，则返回TreeSet。
     */
    List<Integer> matchAllIndex(String a, String b) {
        this.n = a.length();
        this.m = b.length();
        a = " " + a;
        b = " " + b;

        this.s = a.toCharArray();
        this.p = b.toCharArray();
        this.next = new int[m + 1];

        List<Integer> list = new ArrayList<>();
        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) {
                j = next[j];
                list.add(i - m);
            }
        }
        return list;
    }

    /**
     * 返回b在a中匹配的次数
     */
    int matchCount(String a, String b) {
        this.n = a.length();
        this.m = b.length();
        a = " " + a;
        b = " " + b;
        int ans = 0;
        this.s = a.toCharArray();
        this.p = b.toCharArray();
        this.next = new int[m + 1];

        int[] next = new int[m + 1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            if (s[i] == p[j + 1]) j++;
            if (j == m) {
                j = next[j];
                ans++;
            }
        }
        return ans;
    }
}

/**
 * Z函数（扩展KMP）
 */
class ZFunc {
    char[] s;

    public ZFunc(String str) {
        this.s = str.toCharArray();
    }

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

// 计算任意位置s[i:j]是否是一个回文字符串
class PalString2D {

    public boolean[][] calc(String s) {
        int n = s.length();
        boolean[][] ok = new boolean[n][n];
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                ok[l][r] = true;
                l--;
                r++;
            }
        }
        return ok;
    }
}
