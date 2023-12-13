package com.fqh.位运算.XOR;

/**
 * @Author: vq
 * @Date: 2023/12/13 11:11
 * @Version V1.0
 */
public class LC_1720 {

//    1720. 解码异或后的数组
//            简单
//    相关标签
//            相关企业
//    提示
//    未知 整数数组 arr 由 n 个非负整数组成。
//
//    经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
//
//    给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
//
//    请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
//
//
//
//    示例 1：
//
//    输入：encoded = [1,2,3], first = 1
//    输出：[1,0,2,1]
//    解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]

    // encoded[i] = arr[i] XOR arr[i + 1]
    // encoded[i - 1] = arr[i - 1] XOR arr[i]
    // 两边同时异或 arr[i - 1]后  arr[i] = encoded[i - 1] ^ arr[i - 1]
    public int[] decode(int[] encoded, int first) {
        int n = encoded.length + 1;
        var ans = new int[n];
        ans[0] = first;
        for (int i = 1; i < n; i++) {
            ans[i] = encoded[i - 1] ^ ans[i - 1];
        }
        return ans;
    }
}
