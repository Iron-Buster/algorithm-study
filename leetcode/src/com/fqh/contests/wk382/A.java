package com.fqh.contests.wk382;

import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/28 10:25
 **/
public class A {

    public int countKeyChanges(String p) {
        String s = p.toLowerCase();
        char[] cs = s.toCharArray();
        int ans = 0;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] != cs[i-1]) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
