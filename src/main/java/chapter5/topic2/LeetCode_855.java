package chapter5.topic2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author donald
 * @date 2021/02/18
 *
 * 855. 考场就座
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
 * 函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 *
 *
 * 示例：
 *
 * 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
 * 输出：[null,0,9,4,2,null,5]
 * 解释：
 * ExamRoom(10) -> null
 * seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
 * seat() -> 9，学生最后坐在 9 号座位上。
 * seat() -> 4，学生最后坐在 4 号座位上。
 * seat() -> 2，学生最后坐在 2 号座位上。
 * leave(4) -> null
 * seat() -> 5，学生最后坐在 5 号座位上。
 *
 *
 * 提示：
 *
 * 1 <= N <= 10^9
 * 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。
 * 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。
 *
 * 思路： 平衡二叉树来操作
 */
// Faster: 92.19%
class ExamRoom {

    // 将端点 p 映射到以 p 为左端点的线段
    private Map<Integer, int[]> startMap;
    // 将端点 p 映射到以 p 为右端点的线段
    private Map<Integer, int[]> endMap;
    // 根据线段长度从小到大存放所有线段
    private TreeSet<int[]> pq;
    private int N;
    public ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            // 算出两个线段的长度
            int distA = distance(a);
            int distB = distance(b);
            // 长度更长的更大，排后面
            if (distA == distB) {
                return b[0] - a[0];
            }
            return distA - distB;
        });
        // 在有序集合中先放一个虚拟线段
        addInterval(new int[] {-1, N});
    }

    private int distance(int[] ints) {
        int x = ints[0];
        int y = ints[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        // 中点和端点之间的长度
        return (y - x) / 2;
    }

    private void addInterval(int[] ints) {

        pq.add(ints);
        startMap.put(ints[0], ints);
        endMap.put(ints[1], ints);
    }

    public int seat() {
        // 从有序集合拿出最长的线段
        int [] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // 情况一，最左边没人的话肯定坐最左边
            seat = 0;
        } else if (y == N) {
            // 情况二，最右边没人的话肯定坐最右边
            seat = N - 1;
        } else {
            // 情况三，不是边界的话，就坐中间
            // 这是 (x + y) / 2 的防溢出写法
            seat = (y - x) / 2 + x;
        }

        // 将最长的线段分成两段
        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    private void removeInterval(int[] ints) {

        pq.remove(ints);
        startMap.remove(ints[0]);
        endMap.remove(ints[1]);
    }

    public void leave(int p) {

        // 将 p 左右的线段找出来
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        // 将两条线段合并成一条线段
        int[] merged = new int[] {left[0], right[1]};
        // 删除旧线段， 插入新线段
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
}

public class LeetCode_855 {

    class ExamRoom {

        int n;
        TreeSet<Integer> seats;
        PriorityQueue<int[]> pq;

        public ExamRoom(int n) {
            this.n = n;
            this.seats = new TreeSet<Integer>();
            this.pq = new PriorityQueue<int[]>((a, b) -> {
                int d1 = a[1] - a[0], d2 = b[1] - b[0];
                return d1 / 2 < d2 / 2 || (d1 / 2 == d2 / 2 && a[0] > b[0]) ? 1 : -1;
            });
        }

        public int seat() {
            if (seats.isEmpty()) {
                seats.add(0);
                return 0;
            }
            int left = seats.first(), right = n - 1 - seats.last();
            while (seats.size() >= 2) {
                int[] p = pq.peek();
                if (seats.contains(p[0]) && seats.contains(p[1]) && seats.higher(p[0]) == p[1]) { // 不属于延迟删除的区间
                    int d = p[1] - p[0];
                    if (d / 2 < right || d / 2 <= left) { // 最左或最右的座位更优
                        break;
                    }
                    pq.poll();
                    pq.offer(new int[]{p[0], p[0] + d / 2});
                    pq.offer(new int[]{p[0] + d / 2, p[1]});
                    seats.add(p[0] + d / 2);
                    return p[0] + d / 2;
                }
                pq.poll(); // leave 函数中延迟删除的区间在此时删除
            }
            if (right > left) { // 最右的位置更优
                pq.offer(new int[]{seats.last(), n - 1});
                seats.add(n - 1);
                return n - 1;
            } else {
                pq.offer(new int[]{0, seats.first()});
                seats.add(0);
                return 0;
            }
        }

        public void leave(int p) {
            if (p != seats.first() && p != seats.last()) {
                int prev = seats.lower(p), next = seats.higher(p);
                pq.offer(new int[]{prev, next});
            }
            seats.remove(p);
        }
    }
}
