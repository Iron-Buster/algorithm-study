package com.fqh;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/12 11:26
 * @Version V1.0
 */
public class MonotoneStackTemplate {

}


/**
 * 对于每个数，寻找右侧第k个比自己大的数
 */
class KthGreaterElement {

    /**
     * - 求每个数右侧下一个`严格大于`它的第k个数的`索引` (kth next greater)
     * - `不存在为n`
     * - 时间复杂度 O(n*k)
     * <p>
     * !k次单调栈
     * !第一个单调栈pop出去的元素放到第二个单调栈里面
     * !第二个单调栈pop出去的元素放到第三个单调栈里面
     * !...
     * !第k个单调栈再被pop时统计
     */

    public static int[] kthGreaterElement(int[] nums, int k) {

        return null;
    }
}
