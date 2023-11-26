package com.fqh.competition.bw118;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/11/25 20:11
 * @Version V1.0
 */
public class A {

    public List<Integer> findWordsContaining(String[] words, char x) {
        var list = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
