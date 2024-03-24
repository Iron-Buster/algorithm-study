package com.fqh.contests.wk390;

import org.w3c.dom.Node;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/24 19:39
 **/
public class D {

    //https://leetcode.cn/problems/longest-common-suffix-queries/description/
    Node root = new Node();

    //字典树 + 维护最短长度 ，最小下标
    public int[] stringIndices(String[] w, String[] q) {
        for (int i = 0; i < w.length; i++) {
            insert(w[i], i);
        }
        int n = q.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = find(q[i]);
        }
        return ans;
    }

    public void insert(String s, int index) {
        var cur = root;
        if (s.length() < cur.len) {
            cur.len = s.length();
            cur.index = index;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            int next = s.charAt(i) - 'a';
            if (cur.son[next] == null) {
                cur.son[next] = new Node();
            }
            cur = cur.son[next];
            if (s.length() < cur.len) {
                cur.len = s.length();
                cur.index = index;
            }
        }
    }

    public int find(String s) {
        var cur = root;
        for (int i = s.length() - 1; i >= 0; i--) {
            int next = s.charAt(i) - 'a';
            if (cur.son[next] == null) {
                break;
            }
            cur = cur.son[next];
        }
        return cur.index;
    }


    class Node {
        Node[] son;
        int index;
        int len;

        public Node() {
            this.son = new Node[26];
            this.index = Integer.MAX_VALUE;
            this.len = Integer.MAX_VALUE;
        }
    }
}
