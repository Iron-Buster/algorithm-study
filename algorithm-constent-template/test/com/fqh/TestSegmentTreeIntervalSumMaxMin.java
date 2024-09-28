package com.fqh;

public class TestSegmentTreeIntervalSumMaxMin {


    public static void main(String[] args) {

        long[] a = {1, 2, 3, 4, 5, 6};
        long[] b = {2, 2, 4, 3, 1, 5};

        int n = a.length;
        SegmentTreeIntervalSumMaxMin seg = new SegmentTreeIntervalSumMaxMin(n);
        seg.n = n;
        for (int i = 0; i < n; i++) {
            seg.a[i] = a[i];
        }
        seg.build(1, n, 1);


        SegmentTreeIntervalSumMaxMin.Node node = seg.getSumMaxMin(1, 3);
        System.out.println(node.sum + " " + node.mx + " " + node.mn);
    }
}
