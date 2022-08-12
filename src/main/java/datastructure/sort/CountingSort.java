package datastructure.sort;

/**
 * 计数排序
 *
 * 计数排序是一种稳定的排序算法。它不是基于比较的排序算法，因此可以突破 O(n*log(n)) 的下界，在线性时间内完成排序。
 *
 * 计数排序适用于序列的键值是较小范围的整数，或是可以映射到较小范围整数的情况。
 * 它的算法思想是统计相同键值的元素个数，然后以键值为下标，把统计结果存储到一个较小的数组中。
 * 根据元素的出现个数，再计算出每个元素在排序数组中所在下标，根据这些下标，把元素放到正确的位置上即可。
 */
public class CountingSort {

    public class CountingSortFixedK {

        private int k;

        // 对于数组中元素 x，有 0 <= x <= k, k 是一个较小的数字。
        public CountingSortFixedK(int k) {
            this.k = k;
        }

        // Time: O(n+k), Space: O(n+k)
        public void sortLeft2Right(int[] arr) {
            if (arr == null || arr.length == 0) return;
            int[] indexes = new int[k + 1];
            for (int num : arr) ++indexes[num];

            int start = 0;
            for (int i = 0; i <= k; ++i) {
                int count = indexes[i];
                indexes[i] = start;
                start += count;
            }

            int[] tmp = new int[arr.length];
            for (int num : arr) {
                int idx = indexes[num];
                tmp[idx] = num;
                ++indexes[num];
            }
            System.arraycopy(tmp, 0, arr, 0, arr.length);
        }

        // Time: O(n+k), Space: O(n+k)
        public void sortRight2Left(int[] arr) {
            if (arr == null || arr.length == 0) return;
            int[] indexes = new int[k + 1];
            for (int num : arr) ++indexes[num];

            --indexes[0];
            for (int i = 1; i <= k; ++i)
                indexes[i] = indexes[i] + indexes[i - 1];

            int[] tmp = new int[arr.length];
            for (int i = arr.length - 1; i >= 0; --i) {
                int idx = indexes[arr[i]];
                tmp[idx] = arr[i];
                --indexes[arr[i]];
            }
            System.arraycopy(tmp, 0, arr, 0, arr.length);
        }

    }
}
