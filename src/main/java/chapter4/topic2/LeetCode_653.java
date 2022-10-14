package chapter4.topic2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author donald
 * @date 2022/10/14
 *
 * 思路：
 * 1. 先转为有序列表，再双指针查
 * 2. DFS + 哈希表
 */
public class LeetCode_653 {

    // 方法一： 中序转列表，双指针查
    // Time: O(n), Space: O(n), Faster: 96.53%
    public boolean findTarget(TreeNode root, int k) {
        if (null == root) return false;

        // 1. 中序遍历，生成有序列表
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        // 2. 双指针查找
        int n = list.size();
        for (int left = 0, right = n - 1; left < right;) {
            int num1 = list.get(left), num2 = list.get(right);
            if (num1 + num2 == k) return true;
            else if (num1 + num2 < k) ++left;
            else if (num1 + num2 > k) --right;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (null == root) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    Set<Integer> set = new HashSet<>();
    // 方法二： DFS + 哈希表
    // Time: O(n), Space: O(n), Faster: 96.53%
    public boolean findTargetMap(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return findTargetMap(root.left, k) || findTargetMap(root.right, k);
    }
}
