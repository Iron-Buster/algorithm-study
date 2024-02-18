package com.fqh.字典树;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/18 16:25
 **/
public class LC_100229 {

//    https://leetcode.cn/problems/find-the-length-of-the-longest-common-prefix/description/

    Node root = new Node();
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        var a = new HashSet<Integer>();
        var b = new HashSet<Integer>();
        for (int x : arr1) a.add(x);
        for (int x : arr2) b.add(x);
        HashSet<Integer> p1, p2;
        if (a.size() > b.size()) {
            p1 = b;
            p2 = a;
        } else {
            p1 = a;
            p2 = b;
        }
        for (int x : p1) {
            insert(String.valueOf(x));
        }
        int ans = 0;
        for (int y : p2) {
            ans = Math.max(ans, search(String.valueOf(y)));
        }
        return ans;
    }

    int search(String w) {
        int res = 0;
        char[] s = w.toCharArray();
        var cur = root;
        for (int i = 0; i < s.length; i++) {
            int idx = s[i] - '0';
            if (cur.son[idx] == null) {
                return res;
            }
            cur = cur.son[idx];
            res += 1;
        }
        return res;
    }

    void insert(String w) {
        char[] s = w.toCharArray();
        var cur = root;
        for (int i = 0; i < s.length; i++) {
            int idx = s[i] - '0';
            if (cur.son[idx] == null) {
                cur.son[idx] = new Node();
            }
            cur = cur.son[idx];
        }
        cur.isEnd = true;
    }

    class Node {
        Node[] son;
        boolean isEnd;

        public Node() {
            this.son = new Node[10];
            this.isEnd = false;
        }
    }
}
