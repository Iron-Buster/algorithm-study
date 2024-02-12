package com.fqh.前缀和.状态压缩;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 16:27
 **/
public class LC_1177 {

//    1177. 构建回文串检测
//            已解答
//    第 152 场周赛
//            Q3
//    1848
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s，请你对 s 的子串进行检测。
//
//    每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。
//
//    如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。
//
//    返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            sum[i+1] = sum[i] ^ bit;
        }
        var ans = new ArrayList<Boolean>(queries.length);
        for (var q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int m = Integer.bitCount(sum[right+1] ^ sum[left]);
            ans.add(m / 2 <= k); // m个出现次数为奇数的字符只需要 m/2次修改
        }
        return ans;
    }
}
