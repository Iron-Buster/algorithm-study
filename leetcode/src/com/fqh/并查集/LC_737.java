package com.fqh.并查集;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 11:57
 **/
public class LC_737 {

    //    737. 句子相似性 II
//    中等
//            相关标签
//    相关企业
//            提示
//    我们可以将一个句子表示为一个单词数组，例如，句子 I am happy with leetcode"可以表示为 arr = ["I","am",happy","with","leetcode"]
//
//    给定两个句子 sentence1 和 sentence2 分别表示为一个字符串数组，并给定一个字符串对 similarPairs ，
//    其中 similarPairs[i] = [xi, yi] 表示两个单词 xi 和 yi 是相似的。
//
//    如果 sentence1 和 sentence2 相似则返回 true ，如果不相似则返回 false 。
//
//    两个句子是相似的，如果:
//
//    它们具有 相同的长度 (即相同的字数)
//    sentence1[i] 和 sentence2[i] 是相似的
//    请注意，一个词总是与它自己相似，也请注意，相似关系是可传递的。例如，如果单词 a 和 b 是相似的，单词 b 和 c 也是相似的，那么 a 和 c 也是 相似 的。
    public boolean areSentencesSimilarTwo(String[] s1, String[] s2, List<List<String>> similarPairs) {
        if (s1.length != s2.length) { // 长度不等，不相似
            return false;
        }
        var uf = new UnionFind();
        for (var s : s1) uf.fa.put(s, s);
        for (var s : s2) uf.fa.put(s, s);
        for (var pair : similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            uf.merge(a, b);
        }
        for (int i = 0; i < s1.length; i++) {
            if (!uf.find(s1[i]).equals(uf.find(s2[i]))) {
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        Map<String, String> fa;

        public UnionFind() {
            fa = new HashMap<>();
        }

        public String find(String x) {
            if (!fa.containsKey(x)) {
                fa.put(x, x);
            }
            while (!x.equals(fa.get(x))) {
                fa.put(x, fa.get(fa.get(x))); // 路径压缩
                x = fa.get(x);
            }
            return x;
        }

        public void merge(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if (rootA.equals(rootB)) {
                return;
            }
            fa.put(rootB, rootA);
        }
    }
}
