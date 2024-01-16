package com.fqh.动态规划.状压DP;

import java.util.HashMap;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 22:18
 **/
public class LC_1125 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }
        int[] p2s = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            int skill_set = 0;
            for (var skill : people.get(i)) {
                if (map.containsKey(skill)) {
                    continue;
                }
                int idx = map.get(skill);
                skill_set |= (1<<idx);
            }
            p2s[i] = skill_set;
        }
        int N = req_skills.length;

        return null;
    }
}
