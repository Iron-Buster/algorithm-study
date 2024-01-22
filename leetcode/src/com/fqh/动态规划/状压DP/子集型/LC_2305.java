package com.fqh.动态规划.状压DP.子集型;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 12:17
 **/
public class LC_2305 {

//    2305. 公平分发饼干
//            已解答
//    第 297 场周赛
//            Q3
//1887
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 cookies ，其中 cookies[i] 表示在第 i 个零食包中的饼干数量。
//    另给你一个整数 k 表示等待分发零食包的孩子数量，所有 零食包都需要分发。
//    在同一个零食包中的所有饼干都必须分发给同一个孩子，不能分开。
//
//    分发的 不公平程度 定义为单个孩子在分发过程中能够获得饼干的最大总数。
//
//    返回所有分发的最小不公平程度。
//
//
//
//    示例 1：
//
//    输入：cookies = [8,15,10,20,8], k = 2
//    输出：31
//    解释：一种最优方案是 [8,15,8] 和 [10,20] 。
//            - 第 1 个孩子分到 [8,15,8] ，总计 8 + 15 + 8 = 31 块饼干。
//            - 第 2 个孩子分到 [10,20] ，总计 10 + 20 = 30 块饼干。
//    分发的不公平程度为 max(31,30) = 31 。
//    可以证明不存在不公平程度小于 31 的分发方案。

//            2 <= cookies.length <= 8
//            1 <= cookies[i] <= 105
//            2 <= k <= cookies.length

    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        // f[i][s]表示第i个小朋友分到的🍪集合为s的最优解
        int[][] f = new int[k][1<<n];
        int[] sum = new int[1<<n];
        // 预处理出所有状态的🍪个数
        for (int s = 0; s < 1<<n; s++) { // 枚举状态
            for (int j = 0; j < n; j++) {
                if ((s >>j & 1) == 1) { // 饼干j在集合s中
                    sum[s] += cookies[j];
                }
            }
        }
        // 初始化分个1个小朋友的🍪数量
        for (int s = 0; s < 1<<n; s++) {
            f[0][s] = sum[s];
        }
        for (int i = 1; i < k; i++) {         // 枚举小朋友
            for (int s = 0; s < 1<<n; s++) {  // 枚举🍪集合
                f[i][s] = 0x3f3f3f;
                for (int sub = s; sub > 0; sub=(sub-1)&s) {  //枚举s的子集 sub
                    f[i][s] = Math.min(f[i][s], Math.max(f[i-1][s^sub], sum[sub]));
                }
            }
        }
        return f[k-1][(1<<n)-1];
    }

    public static void main(String[] args) {
        int[] cookies = {8,15,10,20,8};
        int k = 2;
        System.out.println(new LC_2305().distributeCookies(cookies, k));
    }
}
