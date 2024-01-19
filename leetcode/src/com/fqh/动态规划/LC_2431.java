package com.fqh.动态规划;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 23:45
 **/
public class LC_2431 {
//    2431. 最大限度地提高购买水果的口味
//            已解答
//    中等
//            相关标签
//    相关企业
//            提示
//    你有两个非负整数数组 price 和 tastiness，两个数组的长度都是 n。同时给你两个非负整数 maxAmount 和 maxCoupons。
//
//    对于范围 [0, n - 1] 中的每一个整数 i:
//
//    price[i] 描述了第 i 个水果的价格。
//
//    tastiness[i] 描述了第 i 个水果的味道。
//    你想购买一些水果，这样总的味道是最大的，总价不超过 maxAmount。
//
//    此外，你还可以用优惠券以 半价 购买水果 (向下取整到最接近的整数)。您最多可以使用 maxCoupons 次该优惠券。
//
//    返回可购买的最大总口味。

//    输入: price = [10,20,20], tastiness = [5,8,8], maxAmount = 20, maxCoupons = 1
//    输出: 13
//    解释: 可以用以下方法来达到总口味:
//            - 无优惠券买第一个水果，总价= 0 + 10，总口味= 0 + 5。
//            - 用优惠券买第二个水果，总价= 10 + 10，总口味= 5 + 8。
//            - 不购买第三个水果，总价= 20，总口味= 13。
//    可以证明 13 是所能得到的最大总口味。

    Integer[][][] f = new Integer[105][1005][6];
    public int maxTastiness(int[] p, int[] t, int maxAmount, int maxCoupons) {
        return dfs(0, maxAmount, p, t, maxCoupons);
    }

    int dfs(int i, int remain, int[] p, int[] t, int cnt) {
        if (i >= p.length) return 0;
        if (f[i][remain][cnt] != null) {
            return f[i][remain][cnt];
        }
        int ans = dfs(i + 1, remain, p, t, cnt); // 不选
        if (remain - p[i] >= 0) {
            // 选-不用优惠
            ans = Math.max(ans, dfs(i + 1, remain - p[i], p, t, cnt) + t[i]);
        }
        if (cnt > 0 && remain - p[i] / 2 >= 0) {
            // 选-用优惠
            ans = Math.max(ans, dfs(i + 1, remain - p[i] / 2, p, t, cnt - 1) + t[i]);
        }
        return f[i][remain][cnt] = ans;
    }

    public static void main(String[] args) {
        int[] p = {10, 20, 20};
        int[] t = {5, 8, 8};
        int mx = 20;
        int mxc = 1;
        System.out.println(new LC_2431().maxTastiness(p, t, mx, mxc));
    }

}
