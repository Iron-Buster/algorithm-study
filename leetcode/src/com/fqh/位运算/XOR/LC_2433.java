package com.fqh.位运算.XOR;

/**
 * @Author: vq
 * @Date: 2023/12/13 12:12
 * @Version V1.0
 */
public class LC_2433 {

//    2433. 找出前缀异或的原始数组
//    第 314 场周赛
//            Q2
//1367
//    相关标签
//            相关企业
//    提示
//    给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ：
//
//    pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
//    注意 ^ 表示 按位异或（bitwise-xor）运算。
//
//    可以证明答案是 唯一 的。
//
//
//
//    示例 1：
//
//    输入：pref = [5,2,0,3,1]
//    输出：[5,7,2,3,2]
//    解释：从数组 [5,7,2,3,2] 可以得到如下结果：
//            - pref[0] = 5
//            - pref[1] = 5 = 2 ^ 7
//            - pref[2] = 5 ^ 7 ^ 2 = 0
//            - pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
//            - pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1

    // 1.pre[i] = arr[i] ^ (arr[i-1] ... ^ arr[0])
    // 把(arr[i-1] ... ^ arr[0])看成一个整体，用一个变量维护
    // 2.pre[i] ^ (arr[i-1] ... ^ arr[0]) = arr[i]

    public int[] findArray(int[] pref) {
        int n = pref.length;
        var ans = new int[n];
        ans[0] = pref[0];
        int s = ans[0];
        for (int i = 1; i < n; ++i) {
            ans[i] = s ^ pref[i];
            s ^= ans[i];
        }
        return ans;
    }
}
