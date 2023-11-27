package com.fqh.分组循环;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/11/27 22:23
 * @Version V1.0
 */
public class LC_228 {

//    228. 汇总区间
//                已解答
//        简单
//                相关标签
//        相关企业
//        给定一个  无重复元素 的 有序 整数数组 nums 。
//
//        返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
//
//        列表中的每个区间范围 [a,b] 应该按如下格式输出：
//
//                "a->b" ，如果 a != b
//    "a" ，如果 a == b
public List<String> summaryRanges(int[] nums) {
    return f(nums);
}

    List<String> f(int[] a) {
        int n = a.length;
        var ans = new ArrayList<String>();
        var sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int st = i;
            sb.append(a[i]).append("->");
            for (i++; i < n && a[i] - a[i - 1] == 1; i++);
            if (a[i - 1] != a[st]) {
                sb.append(a[i - 1]);
            } else {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
            ans.add(sb.toString());
            sb = new StringBuilder();
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}

