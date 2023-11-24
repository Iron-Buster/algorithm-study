package com.fqh.competition.bw85;

/**
 * @Author: vq
 * @Date: 2023/11/24 15:22
 * @Version V1.0
 */
public class C {

//2381. 字母移位 II
//    第 85 场双周赛
//            Q3
//1793
//    相关标签
//            相关企业
//    提示
//    给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，如果 directioni = 0 将字符向前移位。
//
//    将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
//
//    请你返回对 s 进行所有移位操作以后得到的最终字符串。
//
//
//
//    示例 1：
//
//    输入：s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
//    输出："ace"
//    解释：首先，将下标从 0 到 1 的字母向前移位，得到 s = "zac" 。
//    然后，将下标从 1 到 2 的字母向后移位，得到 s = "zbd" 。
//    最后，将下标从 0 到 2 的字符向后移位，得到 s = "ace" 。
//    示例 2:
//
//    输入：s = "dztz", shifts = [[0,0,0],[1,1,1]]
//    输出："catz"
//    解释：首先，将下标从 0 到 0 的字母向前移位，得到 s = "cztz" 。
//    最后，将下标从 1 到 1 的字符向后移位，得到 s = "catz" 。

    static final int MOD = 260000;
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        var diff = new int[n + 1];
        for (var ss : shifts) {
            int l = ss[0], r = ss[1], x = ss[2] == 0 ? -1 : 1;
            diff[l] += x;
            diff[r + 1] -= x;
        }
        // 前缀和还原差分数组
        for (int i = 1; i <= n; i++) diff[i] += diff[i - 1];
        var ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 负数取模
            int temp = 'a' + (s.charAt(i) - 'a' + diff[i] + MOD) % 26;
            ans.append((char) temp);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        String res = new C().shiftingLetters(s, shifts);
        System.out.println(res);
    }
}
