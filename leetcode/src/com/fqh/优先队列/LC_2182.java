package com.fqh.优先队列;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 09:29
 **/
public class LC_2182 {

    public String repeatLimitedString(String ss, int limit) {
        char[] s = ss.toCharArray();
        Arrays.sort(s);
        int cnt = 1;
        var pq = new PriorityQueue<Node>((a, b) -> b.ch - a.ch);
        for (int i = 1; i < s.length; i++) {
            if (s[i] != s[i-1]) {
                pq.offer(new Node(s[i-1], cnt));
                cnt = 1;
            } else {
                cnt++;
            }
        }
        if (cnt > 0) {
            pq.offer(new Node(s[s.length-1], cnt));
        }
        // 贪心构造，记录字符当前连续的次数，如果大于了limit，则需选择下一个大的字符。
        cnt = 0;
        char pre = ' ';
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var p1 = pq.poll();
            if (p1.ch == pre) {
                if (++cnt > limit) {
                    if (pq.isEmpty()) break;
                    var p2 = pq.poll();
                    sb.append(p2.ch);
                    pre = p2.ch;
                    p2.cnt -= 1;
                    if (p2.cnt > 0) {
                        pq.offer(p2);
                    }
                    cnt = 1;
                } else {
                    sb.append(p1.ch);
                    pre = p1.ch;
                    p1.cnt -= 1;
                }
            } else {
                cnt = 1;
                sb.append(p1.ch);
                pre = p1.ch;
                p1.cnt -= 1;
            }
            if (p1.cnt > 0) {
                pq.offer(p1);
            }
        }
        return sb.toString();
    }


    class Node {
        char ch;
        int cnt;

        public Node(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }


//    2182. 构造限制重复的字符串
//    第 281 场周赛
//            Q3
//1680
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。
//
//    返回 字典序最大的 repeatLimitedString 。
//
//    如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。
//
//
//
//    示例 1：
//
//    输入：s = "cczazcc", repeatLimit = 3
//    输出："zzcccac"
//    解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
//    字母 'a' 连续出现至多 1 次。
//    字母 'c' 连续出现至多 3 次。
//    字母 'z' 连续出现至多 2 次。
//    因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
//    该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
//    注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。

    public static void main(String[] args) {
        System.out.println(new LC_2182().repeatLimitedString("cczazcc", 3));
    }
}
