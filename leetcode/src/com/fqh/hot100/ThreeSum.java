package com.fqh.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/2 12:02
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        var ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s > 0) k--;
                else if (s < 0) j++;
                else {
                    ans.add(List.of(nums[i], nums[j], nums[k]));
                    for (++j; j < k && nums[j] == nums[j-1]; j++);
                    for (--k; j < k && nums[k] == nums[k+1]; k--);
                }
            }
        }
        return ans;
    }
}
