@[toc]

# 算法

## （1）排序算法

### 1） 快速排序

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

### 3） 计数排序


## （2）搜索算法

### 1） 回溯

> `DFS` 和 `BFS` 用递归方式的话
> 如果每次展开的状态都需要记录，空间复杂度是指数级增长的。
> 如果求解的目标状态是一个值，不是一条路径或者一个序列，这时候额外需要的辅助空间是线性增长的。

1. DFS(递归/栈)


2. BFS(递归/栈)



### 2） 递归

### 3） 剪枝


## （3）图论

### 1） 最短路


### 2） 最小生成树


### 3） 网络流建模


## （4）动态规划

### 1） 背包问题

### 2） 最长子序列

### 3） 计数问题


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


## （3）树与图

1. 树
> 树的递归遍历也可以用栈来模拟
```java


```

### 1）最近公共祖先

### 2）并查集


## （4）哈希表


## （5）堆


### 1）大/小根堆

### 2）可并堆

## （6）字符串

### 1）字典树

### 2）后缀树
