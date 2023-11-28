package com.fqh.分组循环;

/**
 * @Author: vq
 * @Date: 2023/11/28 9:33
 * @Version V1.0
 */
public class LC_1759 {
//    1759. 统计同质子字符串的数目
//                已解答
//        第 228 场周赛
//                Q2
//    1491
//    相关标签
//            相关企业
//    提示
//    给你一个字符串 s ，返回 s 中 同质子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
//
//    同质字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同质字符串。
//
//    子字符串 是字符串中的一个连续字符序列。
//
//
//
//    示例 1：
//
//    输入：s = "abbcccaa"
//    输出：13
//    解释：同质子字符串如下所列：
//            "a"   出现 3 次。
//            "aa"  出现 1 次。
//            "b"   出现 2 次。
//            "bb"  出现 1 次。
//            "c"   出现 3 次。
//            "cc"  出现 2 次。
//            "ccc" 出现 1 次。
//            3 + 1 + 2 + 1 + 3 + 2 + 1 = 13

    static final int MOD = 1000000007;
    public int countHomogenous(String s) {
        return (int) f(s.toCharArray());
    }

    long f(char[] s) {
        int n = s.length;
        long ans = 0;
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[i-1]; i++) {
                ans += i - st;
            }
            ans += i - st;
            ans %= MOD;
        }
        return ans;
    }
}
