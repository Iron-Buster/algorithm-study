package com.fqh.双指针;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/9 22:52
 **/
public class LC_2105 {

    // https://leetcode.cn/problems/watering-plants-ii/
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int a = capacityA, b = capacityB;
        int i = 0, j = n - 1;
        int ans = 0;
        while (i <= j) {
            if (i == j) {
                if (a >= b) ans += (a < plants[i] ? 1 : 0);
                else ans += (b < plants[j] ? 1 : 0);
                break;
            }
            if (a >= plants[i]) {
                a -= plants[i];
            } else {
                ans++;
                a = capacityA - plants[i];
            }

            if (b >= plants[j]) {
                b -= plants[j];
            } else {
                ans++;
                b = capacityB - plants[j];
            }
            i++; j--;
        }
        return ans;
    }
}
