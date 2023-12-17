package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/12/15 15:15
 * @Version V1.0
 */

import java.util.List;

/**
 * 二分搜索模板
 */
public class BisectTemplate {

    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * 存在多个相同的值时，返回最左边的位置。
     * @param a         一维数组
     * @param target    搜索的值
     * @return
     */
    public static int bisectLeft(int[] a, long target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回 `target` 在 `a` 中最右边的插入位置。
     * 存在多个相同的值时，返回最右边的位置。
     * @param a         一维数组
     * @param target    搜索的值
     * @return
     */
    public static int bisectRight(int[] a, long target) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * a = [start, end, score]
     * @param a         二维数组
     * @param target    搜索的值
     * @param key       搜索的key
     * @return
     */
    public static int bisectLeft1(int[][] a, long target, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid][key] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 返回 `target` 在 `a` 中最右边的插入位置。
     * a = [start, end, score]
     * @param a         二维数组
     * @param target    搜索的值
     * @param key       搜索的key
     * @return
     */
    public static int bisectRight1(int[][] a, long target, int key) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a[mid][key] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * 存在多个相同的值时，返回最左边的位置。
     * @param a         list集合
     * @param target    搜索的值
     * @return
     */
    public static int bisectLeft2(List<Integer> a, long target) {
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 返回 `target` 在 `a` 中最右边的插入位置。
     * 存在多个相同的值时，返回最右边的位置。
     * @param a         list集合
     * @param target    搜索的值
     * @return
     */
    public static int bisectRight2(List<Integer> a, long target) {
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
