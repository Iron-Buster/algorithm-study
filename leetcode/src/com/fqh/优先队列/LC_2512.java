package com.fqh.优先队列;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/31 16:00
 **/
public class LC_2512 {

//    2512. 奖励最顶尖的 K 名学生
//    第 94 场双周赛
//            Q2
//    1637
//    相关标签
//            相关企业
//    提示
//    给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
//
//    一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
//
//    给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
//
//    给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        var map = new HashMap<Long, Long>();
        var ll = new HashSet<String>();
        var rr = new HashSet<String>();
        for (var s : positive_feedback) ll.add(s);
        for (var s : negative_feedback) rr.add(s);
        for (int i = 0; i < report.length; i++) {
            long id = student_id[i];
            map.computeIfAbsent(id, v -> 0L);
            for (String s : report[i].split(" ")) {
                if (ll.contains(s)) {
                    map.merge(id, 3L, Long::sum);
                } else if (rr.contains(s)) {
                    map.merge(id, -1L, Long::sum);
                }
            }
        }
        var pq = new PriorityQueue<Map.Entry<Long, Long>>((a, b) -> {
            if (a.getValue() - b.getValue() == 0) {
                return Long.compare(a.getKey(), b.getKey());
            }
            return Long.compare(b.getValue(), a.getValue());
        });
        for (var entry : map.entrySet()) {
            pq.offer(entry);
        }
        var ans = new ArrayList<Integer>();
        while (k-- > 0 && !pq.isEmpty()) {
            ans.add(pq.poll().getKey().intValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] a = {"utqjmq","f","phss","gbuq","qutww","irwkmv","kdr","cb"};
        String[] b = {"tccrt","xyvvvjhf","igkhpx","l","hqdhsc","nrgfoaje","pwp","xgnrgm"};
        String[] c = {"idkcqa cb evdotmzx phss l xyvvvjhf l ccfa kdr l","jtswrxt lwj gryuxwdk fodazsucff pwp f tccrt qutww irwkmv lzohrrfahd","l f cb gornnntm tccrt xgnrgm gexhslh hqdhsc gbuq igkhpx","f igkhpx irwkmv fmvomibc estombev irwkmv xyvvvjhf irwkmv gbuq irwkmv"};
        int[] student_id = {880134715,923494207,595896825,62500464};
        int k = 3;
        System.out.println(new LC_2512().topStudents(a, b, c, student_id, k));
    }
}
