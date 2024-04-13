package com.fqh.数据结构设计;

import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/26 17:15
 **/
public class LC_2102 {

//    TODO I need a treap template to solve this problem😂.
    class SORTracker {
        int i;
        TreeSet<PII> tset;
        public SORTracker() {
            tset = new TreeSet<>((a, b) -> a.score != b.score ? b.score - a.score : a.name.compareTo(b.name));
        }

        public void add(String name, int score) {
            tset.add(new PII(name, score));
        }

        public String get() {
            return "";
        }
    }

    class PII {
        String name;
        int score;

        public PII(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */
}
