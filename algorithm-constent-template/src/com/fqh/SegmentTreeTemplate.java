package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/11/24 11:07
 * @Version V1.0
 */
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 线段树 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
public class SegmentTreeTemplate {

    public static void main(String[] args) {
    }
}

/**
 * 普通线段树
 */
class SegmentTree {

}

/**
 * 延迟标记线段树 （区间修改）
 */
class LazySegmentTree {

    static class Node {
        public int l, r, sum;
        public boolean tag;

        public Node() {
            this.l = 0;
            this.r = 0;
            this.sum = 0;
            this.tag = false;
        }
    }

    private Node[] arr;

    public LazySegmentTree(int[] nums) {
        int n = nums.length;
        arr = new Node[n * 4 + 1];

    }

    public void build(int i, int l, int r, int[] nums) {
        arr[i] = new Node();
        arr[i].l = l;
        arr[i].r = r;
        arr[i].tag = false;
        if (l == r) {
            arr[i].sum = nums[l];
            return;
        }
        int mid = (l + r) >> 1;
        build(i * 2, l, mid, nums);
        build(i * 2 + 1, mid + 1, r, nums);
        arr[i].sum = arr[i * 2].sum + arr[i * 2 + 1].sum;
    }

    // 下传懒标记
    public void pushDown(int i) {
        if (arr[i].tag) {
            arr[i * 2].tag = !arr[i * 2].tag;
            arr[i * 2].sum = arr[i * 2].r - arr[i * 2].l + 1 - arr[i * 2].sum;
            arr[i * 2 + 1].tag = !arr[i * 2 + 1].tag;
            arr[i * 2 + 1].sum = arr[i * 2 + 1].r - arr[i * 2 + 1].l + 1 - arr[i * 2 + 1].sum;
            arr[i].tag = false;
        }
    }

    // 区间修改（01翻转）
    public void modify(int i, int L, int R) {
        if (arr[i].l >= L && arr[i].r <= R) {
            arr[i].sum = arr[i].r - arr[i].l + 1 - arr[i].sum;
            arr[i].tag = !arr[i].tag;
            return;
        }
        pushDown(i);
        int m = (arr[i].l + arr[i].r) >> 1;
        if (arr[i * 2].r >= L) {
            modify(i * 2, L, R);
        }
        if (arr[i * 2 + 1].l <= R) {
            modify(i * 2 + 1, L, R);
        }
        arr[i].sum = arr[i * 2].sum + arr[i * 2 + 1].sum;
    }

    //区间查询
    public int query(int i, int L, int R) {
        if (arr[i].l >= L && arr[i].r <= R) {
            return arr[i].sum;
        }
        if (arr[i].r < L || arr[i].l > R)
            return 0;
        pushDown(i);
        int res = 0;
        if (arr[i].l >= L) {
            res += query(i * 2, L, R);
        }
        if (arr[i].r <= R) {
            res += query(i * 2 + 1, L, R);
        }
        return res;
    }
}
