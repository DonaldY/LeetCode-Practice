package summary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author donald
 * @date 2022/11/03
 */
public class GaoDe1 {

    public static void main(String[] args) {

        GaoDe1 GaoDe1 = new GaoDe1();
        System.out.println(GaoDe1.find(new
                int[]{10, 50, 60, 40, 3, 80, 18, 1, 10, 90, 30, 40, 40, 10, 10, 10, 90}));
    }

    public List<List<Integer>> find(int[] nums) {
        if (null == nums || nums.length == 0) return Collections.emptyList();
        int sum = 0;
        for (int i = 0; i < 3; ++i) sum += nums[i];
        int left = 0, right = 2;
        List<List<Integer>> result = new ArrayList<>();
        int cnt = 0, start = 0;
        while (++right < nums.length) {
            if (sum > 100) {
                if (cnt == 0) start = left;
                ++cnt;
            } else {
                if (cnt >= 4) {
                    List<Integer> list = new ArrayList<>();
                    for (int i = start; i < right - 1; ++i) list.add(nums[i]);
                    result.add(list);
                }
                cnt = 0;
            }
            sum += nums[right];
            while (right - left + 1 > 3) {
                sum -= nums[left];
                ++left;
            }
        }
        if (cnt >= 4) {
            List<Integer> list = new ArrayList<>();
            for (int i = start; i < nums.length; ++i) list.add(nums[i]);
            result.add(list);
        }

        return result;
    }
}
