package com.fqh.数据结构设计;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/2 18:11
 **/
public class LC_2353 {

    class FoodRatings {

        Map<String, TreeSet<Item>> map = new HashMap<>();// cuisine -> foods
        Map<String, Item> map2 = new HashMap<>(); // food -> item

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                var item = new Item(foods[i], cuisines[i], ratings[i]);
                map.computeIfAbsent(cuisines[i], v -> new TreeSet<>(Item::compareTo));
                map.get(cuisines[i]).add(item);
                map2.put(foods[i], item);
            }
        }

        public void changeRating(String food, int newRating) {
            Item oldItem = map2.get(food);
            Item newItem = new Item(food, oldItem.cuisine, newRating);
            map2.put(food, newItem);
            map.get(oldItem.cuisine).remove(oldItem); // 平衡树移除老数据
            map.get(oldItem.cuisine).add(newItem);

        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).first().food;
        }

        class Item implements Comparable<Item> {
            String food;
            String cuisine;
            int rating;

            public Item(String food, String cuisine, int rating) {
                this.food = food;
                this.cuisine = cuisine;
                this.rating = rating;
            }

            @Override
            public int compareTo(Item o) {
                return this.rating == o.rating ? this.food.compareTo(o.food)
                        : o.rating - this.rating;
            }
        }
    }

//    2353. 设计食物评分系统
//    第 303 场周赛
//            Q3
//    1782
//    相关标签
//            相关企业
//    提示
//    设计一个支持下述操作的食物评分系统：
//
//    修改 系统中列出的某种食物的评分。
//    返回系统中某一类烹饪方式下评分最高的食物。
//    实现 FoodRatings 类：
//
//    FoodRatings(String[] foods, String[] cuisines, int[] ratings) 初始化系统。食物由 foods、cuisines 和 ratings 描述，长度均为 n 。
//    foods[i] 是第 i 种食物的名字。
//    cuisines[i] 是第 i 种食物的烹饪方式。
//    ratings[i] 是第 i 种食物的最初评分。
//    void changeRating(String food, int newRating) 修改名字为 food 的食物的评分。
//    String highestRated(String cuisine) 返回指定烹饪方式 cuisine 下评分最高的食物的名字。如果存在并列，返回 字典序较小 的名字。
//    注意，字符串 x 的字典序比字符串 y 更小的前提是：x 在字典中出现的位置在 y 之前，也就是说，要么 x 是 y 的前缀，或者在满足 x[i] != y[i] 的第一个位置 i 处，x[i] 在字母表中出现的位置在 y[i] 之前。
}
