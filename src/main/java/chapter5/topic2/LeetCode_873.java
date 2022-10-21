package chapter5.topic2;

/**
 * @author donald
 * @date 2022/10/21
 *
 * 思路： dp
 *
 */
public class LeetCode_873 {

    public int lenLongestFibSubseq(int[] arr) {
        int max = 0, n = arr.length;
        int[][] dp = new int[n - 1][n]; // i一定小于j，所以第一维大小可以设为n-1
        for(int i = 0; i < n; i++){
            for(int k = i + 2; k < n; k++){ // k至少比i大2，因为中间要放下j
                for(int j = i + 1; j < k; j++){ // 因为要考察的i,j,k依次递增，因此先定义k再定义j，才可以写出j < k
                    if(arr[i] + arr[j] == arr[k]){ // 只有满足此条件才转移
                        dp[j][k] = dp[i][j] + 1;
                        max = Math.max(max, dp[j][k]); // 每次发生dp赋值时都要更新max
                    }
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}
