- [算法](#--)
  * [（1）排序算法](#-1-----)
    + [1） 快速排序](#1------)
    + [2） 归并排序](#2------)
    + [3） 计数排序](#3------)
  * [（2）搜索算法](#-2-----)
    + [1） 回溯](#1----)
    + [2） 递归](#2----)
    + [3） 剪枝](#3----)
  * [（3）图论](#-3---)
    + [1） 最短路](#1-----)
    + [2） 最小生成树](#2-------)
    + [3） 网络流建模](#3-------)
  * [（4）动态规划](#-4-----)
    + [1） 背包问题](#1------)
    + [2） 最长子序列](#2-------)
    + [3） 计数问题](#3------)
  * [（5）基础技巧](#-5-----)
    + [1） 分治](#1----)
    + [2）倍增](#2---)
    + [3）二分](#3---)
    + [4）贪心](#4---)
- [数据结构](#----)
  * [（1）数组与链表](#-1------)
    + [1）单/双向链表](#1-------)
    + [2）跳舞链](#2----)
  * [（2）栈与队列](#-2-----)
    + [1）栈](#1--)
    + [2）队列](#2---)
  * [（3）树与图](#-3----)
    + [1）最近公共祖先](#1-------)
    + [2）并查集](#2----)
  * [（4）哈希表](#-4----)
  * [（5）堆](#-5--)
    + [1）大/小根堆](#1------)
    + [2）可并堆](#2----)
  * [（6）字符串](#-6----)
    + [1）字典树](#1----)
    + [2）后缀树](#2----)

# 算法

## （1）排序算法

### 1） 快速排序

1. 选基; 2. 分割; 3. 递归;

```java
public class QuickSort {

    // Time: O(n * log(n)), Space: O(n)
    public void hoareSort(int [] arr) {

        if (arr == null || arr.length == 0) return;
        hoareSort(arr, 0, arr.length - 1);
    }

    private void hoareSort(int [] arr, int low, int high) {
        if (low < high) {
            int k = hoarePartition(arr, low, high);
            hoareSort(arr, low, k);
            hoareSort(arr, k + 1, high);
        }
    }

    private int hoarePartition(int [] arr, int low, int high) {
        int pivot = arr[low + (high - low) / 2];
        int i = low, j = high;
        while (true) {
            while (arr[i] < pivot) ++i;
            while (arr[j] > pivot) --j;
            if (i >= j) return j;
            swap(arr, i++, j--);
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
```

### 2） 归并排序

可分为递归版本和迭代版本

思想：
- 把当前序列平分成两个子序列
- 递归地对子序列进行排序
- 把排序好的子序列再合并成一个有序的序列

```java
public class MergeSort {

    // Time: O(n * log(n)), Space: O(n)
    public void sortRecursive(int [] arr) {
        if (arr == null || arr.length == 0) return;

        int [] tmp = new int[arr.length];

        mergeSort(arr, 0, arr.length - 1, tmp);
    }

    private void mergeSort(int[] arr, int low, int high, int[] tmp) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid, tmp);
            mergeSort(arr, mid + 1, high, tmp);
            merge(arr, low, mid, high, tmp);
        }
    }

    private void merge(int[] arr, int low, int mid, int high, int[] tmp) {
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= high) tmp[k++] = arr[j++];
        System.arraycopy(tmp, 0, arr, low, k);
    }

    // Time: O(n * log(n)), Space: O(n)
    public void sortIterative(int [] arr) {

        if (arr == null || arr.length == 0) return;

        int n = arr.length;

        int [] tmp = new int[n];

        for (int len = 1; len < n; len = 2 * len) {
            for (int low = 0; low < n; low += 2 * len) {
                int mid = Math.min(low + len - 1, n - 1);
                int high = Math.min(low + 2 * len - 1, n - 1);
                merge(arr, low, mid, high, tmp);
            }
        }
    }
}
```

### 3）计数排序


### 4）拓扑排序



## （2）搜索算法

> `DFS` 和 `BFS` 用递归方式的话
> 如果每次展开的状态都需要记录，空间复杂度是指数级增长的。
> 如果求解的目标状态是一个值，不是一条路径或者一个序列，这时候额外需要的辅助空间是线性增长的。

1. DFS(递归/栈)


2. BFS(递归/栈)


### 1） 回溯

回溯是一种算法思想

回溯就是通过不同的尝试来生成问题的解，有点类似于穷举，但是和穷举不同的是回溯会“剪枝”

### 2） 递归

递归是一种算法结构

一个递归就是在函数中调用函数本身来解决问题

### 3） 剪枝

剪枝: 过滤已经知道错误的用例


## （3）图论

1. 图拷贝
```java
public class LeetCode_133 {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Time: o(n ^ 2), Space: o(n), Faster: 100.00%
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();

        traverse(node, map);

        return map.get(node);
    }

    private void traverse(Node node, Map<Node, Node> map) {

        if (node == null || map.containsKey(node)) return;

        Node copyNode = new Node(node.val, new ArrayList<>());

        map.put(node, copyNode);

        for (Node neighbor : node.neighbors) {

            traverse(neighbor, map);

            copyNode.neighbors.add(map.get(neighbor));
        }
    }
}
```

### 1） 最短路


### 2） 最小生成树


### 3） 网络流建模


## （4）动态规划

### 1） 背包问题

### 2） 最长子序列

1. 连续子序列的最大和
```java
// 当前累计和为负数是没有意义的, cur表示子序列的和
public class LeetCode_53 {
    // Time: O(n), Space: O(1), Faster: 95.05%
    public int maxSumOfSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 0;
        for (int i = 0; i < nums.length; ++i) {
            cur = cur <= 0 ? nums[i] : (cur + nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
}
```

2. 连续子序列的最大和的下标
```java
// 在连续子序列的最大和的变形题
public class LeetCode {
    public int[] maxSumOfSubArray3(int [] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
    
        // 1. 更新最大值时，需记录开始下标
        int max = Integer.MIN_VALUE, start = 0 , end = 0, cur = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (cur <= 0) {
                cur = nums[i];
                j = i;
            } else {
                cur += nums[i];
            }
    
            if (cur > max) {
                max = cur;
                start = j;
                end = i;
            }
        }
        return new int[]{start, end};
    }
}
```

3. 最大连续乘积（可改为最小连续乘积）
```java
// curMin 表示当前最小值,  curMax 表示当前最大值
public class LeetCode_152 {
    // Time: o(n), Space: o(1), Faster: 99.18%
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], currMax = nums[0], currMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int a = currMax * nums[i], b = currMin * nums[i], c = nums[i];
            currMax = max(a, b, c);
            currMin = min(a, b, c);
            max = Math.max(max, currMax);
        }
        return max;
    }
    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
```

### 3） 计数问题

1. 位运算
```java
// 在成对的数组中找到单个数字
// 1. HashSet 2. 位运算：异或
class LeetCode_136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result ^= nums[i];
        }
        return result;
    }
}

// 只出现一次的两个数字
// 1. HashMap, 2. 位运算，分两批
class LeetCode_260 {
    public int[] singleNumberXOR(int [] nums) {
        int xor = 0, mask = 1;
        // 最低位 1 来划分两组
        for (int num : nums) xor ^= num;
        while ((xor & mask) == 0) mask <<= 1;
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & mask) == 0) x ^= num;
            else y ^= num;
        }
        return new int[]{x, y};
    }
}
```


## （5）基础技巧

### 1） 分治

### 2）倍增

### 3）二分

1. 旋转部分有序数组
```java
/**
* 4,5,6,7,0,1,2
* 
* 从中找到最小值
*/
public class LeetCode_153 {

    public int findMinEarlyReturn(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high]) return nums[low]; // 剪枝
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[low];
    }
}
```

### 4）贪心


# 数据结构

## （1）数组与链表

### 1）单/双向链表

1. 单向链表反转
> 分步骤： 
> 1. 储备下一个节点 
> 2. 当前节点的next指针指向前一个节点 
> 3. 移动到下一个节点

2. 判断单链表是否回文
> 1. 映射到数组， 数组中判断
> 2. 用栈

3. 合并两个有序单链表
> 1. 另设临时节点，然后逐一比较

4. 判断单链表是否有环
> 1. 用 HashSet 来保存链表
> 2. 快指针 和 慢指针： 快指针走2步， 慢指针走1步， 判断最后是否相等

5. 判断两单链表是否相交
> 1. HashSet 两个单链表元素，然后逐一判断是否存在
> 2. 交替相走，走同一样的步数
> 3. 先走到同一样的步数，然后一起比较

6. 移除单链表倒数第 n 个节点
> 1. 先计算链上所有的节点数量, 再删除对应的节点
> 2. 两个指针, 一个指针先走 n 步

7. 有序链表去重
> 1. 两个指针, cur 和 next, cur 和 next进行比较

8. 合并 k 个有序链表
> 1. 一个一个合并(查看 2 )
> 2. 

9. 单链表中圆环的开始节点
> 1. HashSet 来保存, 遍历一遍, 第一个重复的点即为开始节点
> 2. 两个指针 fast 和 slow, fast 走两步, slow 走一步
>    当 fast 和 slow相遇时候, 从 head 重新出发, 当 head 和 slow相遇时候, 则为开始节点

10. 单链表排序
> 

11. 旋转单链表
> 给你一个单链表和一个数字 k，你要把链表右边的节点旋转到链表左边，共旋转 k 次。
> 0 -> 1 -> 2 -> 4 -> 8, k = 3
> 2 -> 4 -> 8 -> 0 -> 1
> k %= n, 后面 k 个数移动至表头


### 2）跳舞链

## （2）栈与队列

### 1）栈

```java
// Example
public class LeetCode {
    // 无法初始化长度，所以可能会动态扩容，这时候用数组可能更有效
    Stack<Integer> stack = new Stack<>();
}
```

### 2）队列

```java
// Example
public class LeetCode {
    // LinkedList 实现队列和双向队列的接口, Deque
    Queue<Character> queue = new LinkedList<>();
}
```


## （3）树

1. 树
> 树的递归遍历也可以用栈来模拟

2. 树的层序遍历
```java
public class LeetCode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Time: O(n), Space: O(n)
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                elem.add(s.val);
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            result.add(elem);
        }

        return result;
    }

}
```

2. 二叉搜索树的定义是：
> 1. 左子树所有节点上的值都小于根节点上的值
> 2. 右子树所有节点上的值都大于根节点上的值
> 3. 左右子树同时也为二叉搜索树

### 1）最近公共祖先

```java
/* 题意： 找到两个节点的最小父节点
 *
 * 思路：
 * 1. 将p和q的父节点均保存下来，然后逐一比对
 * 2. 递归中查找
 *    1. 如果当前节点为空，或者等于目标节点p 或 q，则返回当前节点
 *    2. 否则递归到左右子树上进行处理，返回值分别为 left 和 right
 *    3. 如果 left 和 right 非空，则说明在左右子树上各找到一个节点，于是当前的根节点就是最近公共祖先
 *       如果 left 和 right 只有一个非空，则返回那个非空的节点
 *       如果都为空，就返回空指针
 */
public class LeetCode_236 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean search(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean ret = search(root.left, node, path) || search(root.right, node, path);
        if (ret) return true;
        path.remove(path.size()-1);
        return false;
    }

    // Time: O(n), Space: O(n)
    public TreeNode lcaWithPath(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ppath = new ArrayList<>();
        List<TreeNode> qpath = new ArrayList<>();
        search(root, p, ppath);
        search(root, q, qpath);
        int i = 0, len = Math.min(ppath.size(), qpath.size());
        while (i < len && ppath.get(i) == qpath.get(i)) ++i;
        return ppath.get(i-1);
    }

    // Time: O(n), Space: O(n)
    public TreeNode lcaExtend(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lcaExtend(root.left, p, q);
        TreeNode right = lcaExtend(root.right, p, q);
        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }

}
```

二叉搜索树中节点的最近公共祖先
```java
public class LeetCode_235 {

    // 树的高度
    // Time: O(h), Space: O(h)
    public TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val)
            return lcaRecursive(root.left, p, q);
        else if (p.val > root.val && q.val > root.val)
            return lcaRecursive(root.right, p, q);
        else return root;
    }

    // Time: O(h), Space: O(1)
    public TreeNode lcaIterative(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) root = root.left;
            else if (p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
}
```

### 2）并查集


## （4）哈希表


## （5）堆

1. 数据流中第 K 大的元素
```java
public class LeetCode_703 {

    public class KthLargestElementInStream {

        // 优先队列，默认就是一个最小堆实现
        private Queue<Integer> minHeap = new PriorityQueue<>();
        private int k;

        // Time: o(n * log(k)), Space: o(k), Faster: 32.62%
        public KthLargestElementInStream(int k, int [] nums) {
            this.k = k;
            for (int num : nums) add(num);
        }

        // Time: o(log(k))
        public int add (int val) {
            if (minHeap.size() < k) {
                minHeap.add(val);
            } else if (val > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(val);
            }
            return minHeap.peek();
        }
    }

}
```

### 1）大/小根堆

```java
public class LeetCode {
    
    // 最小堆
    private Queue<Integer> minHeap = new PriorityQueue<>();
    
    // 使用 reverseOrder 来使优先队列作为最大堆
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
}
```


### 2）可并堆

## （6）字符串

1. 回文字符串
> 两指针，左右指针对比

2. 一个字符串的回文子串个数
> aba -> a, b, c, aba
> 1. 暴力法， O(n ^ 3)
> 2. 从当前位置，向两边扩展
> 3. 动态规划（两指针）
>    当  i == j时，
>    当  i + 1 == j时，
>    否则 s(i) == s(j) && s(i + 1, j - 1) 是否回文?

3. 没有重复字符的最长子串长度
> abcabcbb -> abc , 即 3
> 1. 暴力破解法： 2层for循环， 只要这个子串没有重复子串即可求长度。
> 2. 滑动窗口法： 两个指针 i 和 j
>    当 出现重复字母时， i 移动到第一个重复字母出现的下一个位置
```java
public class LeetCode_3 {

    // Time: O(n), Space: O(m)，m 是字符集大小
    public int lengthOfLongestSubstring1N(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        for (int i=0, j=0; j < s.length(); ++j) {
            i = Math.max(index[s.charAt(j)] + 1, i);
            maxLen = Math.max(maxLen, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return maxLen;
    }

}
```

3. 括号的合法排列
> 给你 n 对括号，你要返回这 n 对括号的所有合法排列方式。
> 
```java
public class LeetCode_22 {

    public List<String> generateParentheses(int n) {

        if (n < 0) return Collections.emptyList();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }
    
    void generate(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
        } else {
            if (left > 0) generate(result, str + '(', left - 1, right);
            if (right > left) generate(result, str + '(', left, right - 1);
        }
    }

    // 卡特兰数 Faster: 93.50%
    public List<String> generateParenthesesDP(int n) {

        if (n < 0) return new ArrayList<>();
        List<List<String>> d = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; ++i) d.add(new ArrayList<>());
        d.get(0).add("");
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                for (String left: d.get(j)) {
                    for (String right: d.get(i - j - 1)) {
                        d.get(i).add('(' + left + ')' + right);
                    }
                }
            }
        }
        return d.get(n);
    }
}
```

4. 编辑距离
```java
/**
* 给你两个字符串，你要求出由其中一个字符串转成另一个所需要的最少编辑操作次数。
* 允许的操作有 3 种，分别是：替换一个字符，插入一个字符和删除一个字符。
* 
* s1: car
  s2: ba
  你要把 car 转成 ba，需要先把 c 替换成 b，然后再删除 r。总共操作 2 次，因此它们的编辑距离是 2。
*/
public class LeetCode_72 {

    public int minDistance(String word1, String word2) {

        return editDistance(word1, word2);
    }

    public int editDistance(String s, String t) {
        if (s == null || t == null) return 0;

        int m = s.length() + 1, n = t.length() + 1;
        int [][] d = new int[m][n];

        for (int i = 0; i < m; ++i)
            d[i][0] = i;
        for (int j = 0; j < n; ++j)
            d[0][j] = j;

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = Math.min(Math.min(d[i-1][j-1], d[i][j-1]), d[i-1][j]) + 1;
                }
            }
        }

        return d[m-1][n-1];
    }
}
```



### 1）字典树

### 2）后缀树


### 3) 前缀树(Trie)



```java
public class LeetCode_208 {

    // Faster: 56.86%
    class Trie {

        private class TrieNode {
            boolean endOfWord;
            TrieNode [] children;
            TrieNode() {
                this.endOfWord = false;
                this.children = new TrieNode[26];
            }
        }

        private TrieNode root;
        
        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                int idx = word.charAt(i) - 'a';
                if (cur.children[idx] == null) cur.children[idx] = new TrieNode();
                cur = cur.children[idx];
            }
            cur.endOfWord = true;
        }

        public boolean search(String word) {
            TrieNode node = searchEndNode(word);
            return node != null && node.endOfWord;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode node = searchEndNode(prefix);
            return node != null;
        }

        private TrieNode searchEndNode(String str) {
            TrieNode cur = root;
            for (int i = 0; i < str.length() && cur != null; ++i) {
                int idx = str.charAt(i) - 'a';
                cur = cur.children[idx];
            }
            return cur;
        }
    }
}

```


