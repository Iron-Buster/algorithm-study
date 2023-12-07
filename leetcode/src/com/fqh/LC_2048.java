package com.fqh;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/6 18:36
 * @Version V1.0
 */
public class LC_2048 {

//    2048. 下一个更大的数值平衡数
//    第 264 场周赛
//            Q2
//1734
//    相关标签
//            相关企业
//    提示
//    如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
//
//    给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
//
//    示例 1：
//
//    输入：n = 1
//    输出：22
//    解释：
//            22 是一个数值平衡数，因为：
//            - 数字 2 出现 2 次
//    这也是严格大于 1 的最小数值平衡数。
//    示例 2：
//
//    输入：n = 1000
//    输出：1333
//    解释：
//            1333 是一个数值平衡数，因为：
//            - 数字 1 出现 1 次。
//            - 数字 3 出现 3 次。
//    这也是严格大于 1000 的最小数值平衡数。
//    注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
//    示例 3：
//
//    输入：n = 3000
//    输出：3133
//    解释：
//            3133 是一个数值平衡数，因为：
//            - 数字 1 出现 1 次。
//            - 数字 3 出现 3 次。
//    这也是严格大于 3000 的最小数值平衡数。

    static int[] a = {0, 1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444,
            22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144,
            44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232,
            133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233,
            231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444,
            244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332,
            322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322,
            332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424,
            424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551,
            666666, 1224444, 1242444, 1244244, 1244424, 1244442, 1422444, 1424244, 1424424, 1424442, 1442244,
            1442424, 1442442, 1444224, 1444242, 1444422, 1666666};

    public int nextBeautifulNumber(int n) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (a[mid] > n) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return a[l];
    }



    public static void main(String[] args) {
        int number = new LC_2048().nextBeautifulNumber(748601);
        System.out.println(number);
    }
}
