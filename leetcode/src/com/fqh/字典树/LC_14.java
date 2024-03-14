package com.fqh.字典树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/14 14:12
 **/
public class LC_14 {

//    https://leetcode.cn/problems/longest-common-prefix/
    Node root = new Node();
    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        String t = "";
        for (String s : strs) {
            insert(s);
            if (s.length() < minLen) {
                t = s;
                minLen = s.length();
            }
        }
        String ans = "";
        for (int i = 0; i < minLen; i++) {
            String p = t.substring(0, i + 1);
            if (!search(p)) {
                break;
            }
            ans = p;
        }
        return ans;
    }
    void insert(String s) {
        var cur = root;
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (cur.son[j] == null) {
                cur.son[j] = new Node();
            }
            cur = cur.son[j];
        }
        cur.isEnd = true;
    }

    boolean check(Node[] son, int j) {
        for (int i = 0; i < 26; i++) {
            if (i == j) continue;
            if (son[i] != null) return true;
        }
        return false;
    }
    boolean search(String prefix) {
        var cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (cur.son[j] == null || check(cur.son, j)) {
                return false;
            }
            cur = cur.son[j];
        }
        return true;
    }

    class Node {
        Node[] son;
        boolean isEnd;

        public Node() {
            this.son = new Node[26];
            this.isEnd = false;
        }
    }
}
