package chapter6.topic4;

import java.util.*;

/**
 * @author donald
 * @date 2023/04/16
 */
public class LeetCode_1157 {
}
class MajorityChecker {
    public static final int K = 20;
    private int[] arr;
    private Map<Integer, List<Integer>> loc;
    private Random random;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
        this.loc = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            loc.putIfAbsent(arr[i], new ArrayList<>());
            loc.get(arr[i]).add(i);
        }
        this.random = new Random();
    }

    public int query(int left, int right, int threshold) {
        int length = right - left + 1;

        for (int i = 0; i < K; ++i) {
            int x = arr[left + random.nextInt(length)];
            List<Integer> pos = loc.get(x);
            int occ = searchEnd(pos, right) - searchStart(pos, left);
            if (occ >= threshold) {
                return x;
            } else if (occ * 2 >= length) {
                return -1;
            }
        }

        return -1;
    }

    private int searchStart(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int searchEnd(List<Integer> pos, int target) {
        int low = 0, high = pos.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (pos.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
