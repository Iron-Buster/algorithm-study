package com.fqh.字典树;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/15 15:43
 **/
public class LC_211 {

    class WordDictionary {
        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            char[] s = word.toCharArray();
            var cur = root;
            for (int i = 0; i < s.length; i++) {
                int idx = s[i] - 'a';
                if (cur.son[idx] == null) {
                    cur.son[idx] = new Node();
                }
                cur = cur.son[idx];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {
            var cur = root;
            return dfs(cur, 0, word.toCharArray());
        }

        public boolean dfs(Node cur, int idx, char[] s) {
            if (idx >= s.length) {
                return cur.isEnd;
            }
            if (s[idx] == '.') {
                Node next = cur.son[s[idx] - 'a'];
                if (next == null) return false;
                boolean sub = dfs(next, idx + 1, s);
                if (sub) return true;
            } else {
                for (int i = 0; i < cur.son.length; i++) {
                    if (cur.son[i] == null) {
                        continue;
                    }
                    boolean sub = dfs(cur.son[i], idx + 1, s);
                    if (sub) return true;
                }
            }
            return false;
        }
    }

    class Node {
        Node[] son;
        boolean isEnd;

        public Node() {
            son = new Node[26];
            isEnd = false;
        }
    }

//    211. 添加与搜索单词 - 数据结构设计
//            中等
//    相关标签
//            相关企业
//    提示
//    请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
//
//    实现词典类 WordDictionary ：
//
//    WordDictionary() 初始化词典对象
//    void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
//    bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
//
//
//    示例：
//
//    输入：
//            ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
//            [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//    输出：
//            [null,null,null,null,false,true,true,true]
//
//    解释：
//    WordDictionary wordDictionary = new WordDictionary();
//    wordDictionary.addWord("bad");
//    wordDictionary.addWord("dad");
//    wordDictionary.addWord("mad");
//    wordDictionary.search("pad"); // 返回 False
//    wordDictionary.search("bad"); // 返回 True
//    wordDictionary.search(".ad"); // 返回 True
//    wordDictionary.search("b.."); // 返回 True

    public static void main(String[] args) {
//        WordDictionary wd = new WordDictionary();
//        wd.addWord("bad");
//        wd.addWord("dad");
//        wd.addWord("mad");
//        System.out.println(wd.search("pad"));
//        System.out.println(wd.search("bad"));
//        System.out.println(wd.search(".ad"));
//        System.out.println(wd.search("b.."));
    }
}
