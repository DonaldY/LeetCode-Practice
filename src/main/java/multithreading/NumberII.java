package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：
 * 两线程交替输出： 2, 1, 4, 3, 6, ... 50, 49 | 51, 52, 53, ... 100
 *
 * 题目要求：
 * 1. 两线程交替输出
 * 2. 前50/后50
 *
 * 思路：
 * 1. 1个锁用来控制输出， 2个条件锁用来选择线程输出。
 *    前50时，奇偶步长均为2
 */
public class NumberII {

    private static ReentrantLock lock = new ReentrantLock(); // 主锁
    static Condition oddCondition = lock.newCondition();     // 奇数的条件
    static Condition evenCondition = lock.newCondition();    // 偶数的条件

    static int num = 1; // 总次数
    static int odd = 1; // 奇数
    static int even = 2;// 偶数

    public void oneLockAndTwoCondition() {
        // 偶数
        Thread eventThread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                while (num <= 100) {
                    if (num <= 50) {
                        if (num % 2 == 0) {
                            try {
                                evenCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (num % 2 == 1) {
                            System.out.println(even);
                            even += 2;
                            ++num;
                            oddCondition.signal();
                        }
                    } else {
                        if (num % 2 == 0) {
                            System.out.println(num++);
                            oddCondition.signal();
                        } else {
                            try {
                                evenCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                lock.unlock();
            }
        });

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                while (num <= 100) {

                    if (num <= 50) {
                        if (num % 2 == 1) {
                            try {
                                oddCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (num % 2 == 0) {
                            System.out.println(odd);
                            odd += 2;
                            ++num;
                            evenCondition.signal();
                        }
                        evenCondition.signal();
                    } else {
                        if (num % 2 == 1) {
                            System.out.println(num++);
                            evenCondition.signal();
                        } else {
                            try {
                                oddCondition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                lock.unlock();
            }
        });

        oddThread.start();
        eventThread.start();
    }
}
