package chapter3.topic1;

/**
 * @author donald
 * @date 2022/10/20
 *
 * 思路：
 * 1. 暴力法： 一个个比对
 * 2. 前缀树
 */
public class LeetCode_421 {

    public static void main(String[] args) {

        System.out.println(5 ^ 25);
    }

    // 方法一： 暴力法
    // Time: O(n^2), Space: O(1), Faster: 超时
    public int findMaximumXOR(int[] nums) {
        if (null == nums) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int num = nums[i] ^ nums[j];
                max = Math.max(max, num);
            }
        }
        return max;
    }

    // 方法二： 前缀树
    // Time: O(n), Space: O(n), Faster: 33.49%
    public int findMaximumXORTrie(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            // 1. 前缀树：新增
            insert(num);
            // 2. 查询最大差异
            int xorNum = search(num);

            ans = Math.max(ans, num ^ xorNum);
        }
        return ans;
    }

    private class TrieNode {
        boolean endOfWord;    // 是否是一个单词结尾
        TrieNode [] children; // 指向 2个 子节点
        TrieNode() {
            this.endOfWord = false;
            this.children = new TrieNode[2];
        }
    }
    // 新增
    public void insert(int num) {
        TrieNode cur = root;
        for (int i = 31; i >= 0; --i) {  // 从最低位开始遍历
            int idx = (num >> i) & 1;
            if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.endOfWord = true;
    }
    // 搜索最大异或值
    private int search(int num) {
        int ans = 0;
        TrieNode cur = root;
        for (int i = 31; i >= 0; --i) { // 从最低位开始遍历
            int a = (num >> i) & 1;     // 找到对应位
            int b = 1 - a;              // 取反
            if (null != cur.children[b]) {  // 如果存在此节点
                ans |= (b << i);       // 与操作， b 左移动 i 位
                cur = cur.children[b]; // 下一个值
            } else {
                ans |= (a << i);
                cur = cur.children[a];
            }
        }
        return ans;
    }
    private TrieNode root = new TrieNode();
}
