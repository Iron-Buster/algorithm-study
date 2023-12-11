package com.fqh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: vq
 * @Date: 2023/12/10 18:06
 * @Version V1.0
 */
public class LC_981 {

//981. 基于时间的键值存储
//    第 121 场周赛
//            Q2
//1575
//    相关标签
//            相关企业
//    设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
//
//    实现 TimeMap 类：
//
//    TimeMap() 初始化数据结构对象
//    void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
//    String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。
//    如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);
        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }

    static class TimeMap {
        HashMap<String, TreeSet<Pair>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, v -> new TreeSet<>((a, b) -> a.time - b.time));
            map.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            var tset = map.get(key);
            if (tset == null) return "";
            Pair floor = tset.floor(new Pair("", timestamp));
            if (floor == null) return "";
            return floor.value;
        }

        class Pair {
            String value;
            int time;
            public Pair(String value, int time) {
                this.value = value;
                this.time = time;
            }
        }
    }

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
