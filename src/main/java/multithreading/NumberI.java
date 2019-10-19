package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 1~100，两个线程交替打印出来
 *
 * synchronized、wait、notify控制实现
 */
public class NumberI {

    static int num = 1;
    static final Object lock = new Object();

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            synchronized (lock) {
                while (num <= 100) {
                    if (num % 2 == 1) {
                        System.out.println(num++);
                        lock.notify();

                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });

        Thread evenThread = new Thread(() -> {
            synchronized (lock) {
                while (num <= 100) {
                    if (num % 2 == 0) {
                        System.out.println(num++);
                        lock.notify();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });

        oddThread.start();
        evenThread.start();
    }


}
