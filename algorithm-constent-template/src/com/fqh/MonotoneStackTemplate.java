package com.fqh;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: vq
 * @Date: 2023/12/12 11:26
 * @Version V1.0
 */
public class MonotoneStackTemplate {

}

/**
 * 单调栈模板
 */
class MonotoneStack {

    /**
     * left[i]表示左边第一个比a[i]小的下标
     * @return
     */
    static int[] getMinLeft(int[] a) {
        int n = a.length;
        int[] left = new int[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && a[stk.peek()] > a[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        return left;
    }

    /**
     * right[i]表示右边第一个比a[i]小的下标
     * @return
     */
    static int[] getMinRight(int[] a) {
        int n = a.length;
        int[] right = new int[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && a[stk.peek()] > a[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        return right;
    }

    /**
     * left[i]表示左边第一个比a[i]大的下标
     * @return
     */
    static int[] getMaxLeft(int[] a) {
        int n = a.length;
        int[] left = new int[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            while (stk.size() > 1 && a[stk.peek()] < a[i]) {
                stk.pop();
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        return left;
    }

    /**
     * right[i]表示右边第一个比a[i]大的下标
     * @return
     */
    static int[] getMaxRight(int[] a) {
        int n = a.length;
        int[] right = new int[n + 1];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && a[stk.peek()] < a[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        return right;
    }
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
