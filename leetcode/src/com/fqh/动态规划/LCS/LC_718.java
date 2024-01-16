package com.fqh.动态规划.LCS;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 23:09
 **/
public class LC_718 {

    public int findLength(int[] a, int[] b) {
        // LCS 最长公共子序列模型
        int m = a.length;
        int n = b.length;
        int[] aa = new int[m+1];
        int[] bb = new int[n+1];
        for (int i = 1; i <= m; i++) aa[i] = a[i-1];
        for (int i = 1; i <= n; i++) bb[i] = b[i-1];
        int[][] f = new int[m+1][n+1];
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (aa[i] == bb[j]) {
                    f[i][j] = f[i-1][j-1] + 1;
                } else {
                    f[i][j] = 0;
                }
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }

//    718. 最长重复子数组
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
//
//
//
//    示例 1：
//
//    输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//    输出：3
//    解释：长度最长的公共子数组是 [3,2,1] 。
//    示例 2：
//
//    输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//    输出：5
}
