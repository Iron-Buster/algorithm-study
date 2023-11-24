package com.fqh.competition.bw85;

/**
 * @Author: vq
 * @Date: 2023/11/24 14:55
 * @Version V1.0
 */
public class B {

//    2380. 二进制字符串重新安排顺序需要的时间
//    第 85 场双周赛
//            Q2
//1481
//    相关标签
//            相关企业
//    提示
//    给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
//
//    请你返回完成这个过程所需要的秒数。
//
//
//
//    示例 1：
//
//    输入：s = "0110101" 1100101
//    输出：4
//    解释：
//    一秒后，s 变成 "1011010" 。
//    再过 1 秒后，s 变成 "1101100" 。
//    第三秒过后，s 变成 "1110100" 。
//    第四秒后，s 变成 "1111000" 。
//    此时没有 "01" 存在，整个过程花费 4 秒。
//    所以我们返回 4 。
//    示例 2：
//
//    输入：s = "11100"
//    输出：0
//    解释：
//    s 中没有 "01" 存在，整个过程花费 0 秒。
//    所以我们返回 0 。

    public int secondsToRemoveOccurrences(String s) {
        // >>>>>> O(n^2) >>>>>
//        int ans = 0;
//        while (s.contains("01")) {
//            s = s.replaceAll("01", "10");
//            ans++;
//        }
//        return ans;

        // >>>>>>>> O(n) >>>>>>
        var ss = s.toCharArray();
        int ans = 0, cnt = 0;
        for (var x : ss) {
            if (x == '0') cnt++;
            else if (cnt > 0) ans = Math.max(ans + 1, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int res = new B().secondsToRemoveOccurrences("001011");
        System.out.println(res);
    }
}
