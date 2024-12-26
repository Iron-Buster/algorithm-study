package com.fqh.双指针;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class marscode_89 {


    public static int solution(int n, int k, List<Integer> sequence) {
        // Please write your code here
        var tset = new TreeSet<Integer>();
        var map = new HashMap<Integer, Integer>();
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int x = sequence.get(i);
            tset.add(x);
            map.merge(x, 1, Integer::sum);
            while (tset.last() - tset.first() > k) {
                int l = sequence.get(j);
                map.merge(l, -1, Integer::sum);
                if (map.get(l) == 0) {
                    map.remove(l);
                    tset.remove(l);
                }
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        // You can add more test cases here
        List<Integer> sequence1 = new ArrayList<>();
        sequence1.add(3);
        sequence1.add(1);
        sequence1.add(2);
        sequence1.add(4);

        List<Integer> sequence2 = new ArrayList<>();
        sequence2.add(7);
        sequence2.add(3);
        sequence2.add(5);
        sequence2.add(1);
        sequence2.add(9);

        List<Integer> sequence3 = new ArrayList<>();
        sequence3.add(2);
        sequence3.add(2);
        sequence3.add(3);
        sequence3.add(1);
        sequence3.add(1);
        sequence3.add(2);

        System.out.println(solution(4, 2, sequence1) == 8);
        System.out.println(solution(5, 3, sequence2) == 6);
        System.out.println(solution(6, 1, sequence3) == 12);
    }
}
