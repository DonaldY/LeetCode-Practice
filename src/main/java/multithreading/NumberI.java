package multithreading;


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

    static class SolutionTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            synchronized (SolutionTask.class){
                while (value <= 100){

                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    SolutionTask.class.notify();
                    try {
                        SolutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                // 运行到100打印完后, 偶数线程唤醒再阻塞, 奇数线程被唤醒, 循环后发现 num 大于 100了, 奇数线程退出运行了, 但偶数线程还在等待。
                // 不加 notify,
                //SolutionTask.class.notify();
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

}
