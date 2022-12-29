package chapter11.topic1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author donald
 * @date 2022/12/29
 */
public class LeetCode_2032 {

    // 暴力法： 哈希表
    // Time: O(n), Space: O(n), Faster: 30.20%
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>(nums1.length);
        Set<Integer> set2 = new HashSet<>(nums2.length);
        Set<Integer> set3 = new HashSet<>(nums3.length);
        Set<Integer> set = new HashSet<>(nums1.length + nums2.length + nums3.length);
        for (int num : nums1) {
            set1.add(num);
        }
        set.addAll(set1);
        for (int num : nums2) {
            set2.add(num);
        }
        set.addAll(set2);
        for (int num : nums3) {
            set3.add(num);
        }
        set.addAll(set3);
        List<Integer> result = new ArrayList<>();

        for (int num : set) {

            int cnt = 0;
            if (set1.contains(num)) ++cnt;
            if (set2.contains(num)) ++cnt;
            if (set3.contains(num)) ++cnt;

            if (cnt >= 2) result.add(num);
        }

        return result;
    }
}
