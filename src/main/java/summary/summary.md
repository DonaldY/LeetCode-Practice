# 算法

## （1）排序算法

### 1） 快速排序

### 2） 归并排序

### 3） 计数排序


## （2）搜索算法

### 1） 回溯

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
    Stack<Integer> stack = new Stack<>();
}
```

### 2）队列


## （3）树与图

### 1）最近公共祖先

### 2）并查集


## （4）哈希表


## （5）堆


### 1）大/小根堆

### 2）可并堆

## （6）字符串

### 1）字典树

### 2）后缀树