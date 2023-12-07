package com.fqh;

import com.fqh.分组循环.LC_1578;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/7 16:06
 * @Version V1.0
 */
public class LC_1593 {
//    1593. 拆分字符串使唯一子字符串的数目最大
//    第 207 场周赛
//            Q2
//    1740
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
//
//    字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。
//
//    注意：子字符串 是字符串中的一个连续字符序列。
//
//
//
//    示例 1：
//
//    输入：s = "ababccc"
//    输出：5
//    解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
//    示例 2：
//
//    输入：s = "aba"
//    输出：2
//    解释：一种最大拆分方法为 ['a', 'ba'] 。
//    示例 3：
//
//    输入：s = "aa"
//    输出：1
//    解释：无法进一步拆分字符串。

    // 1 <= s.length <= 16 数据范围较小 直接回溯

    int ans = 0;
    public int maxUniqueSplit(String s) {
        dfs(0, 0, s, new HashSet<>());
        return ans;
    }

    void dfs(int pre, int i, String s, HashSet<String> set) {
        if (i >= s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        // 以i结尾划分
        String sub = s.substring(pre, i + 1);
        if (!set.contains(sub)) {
            set.add(sub);
            dfs(i + 1, i + 1, s, set);
            set.remove(sub);
        }
        // 继续追加s[i]
        dfs(pre, i + 1, s, set);
    }

    public static void main(String[] args) {
        System.out.println(new LC_1593().maxUniqueSplit("aa"));
    }
}
