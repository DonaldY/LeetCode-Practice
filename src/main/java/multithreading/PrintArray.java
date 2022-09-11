package multithreading;

/**
 * @author donald
 * @date 2022/09/09
 */
public class PrintArray implements Runnable {

    static int num = 0;
    static final Object lock = new Object();
    public static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new PrintArray());
        Thread thread2 = new Thread(new PrintArray());
        Thread thread3 = new Thread(new PrintArray());
        thread1.start();
        thread2.start();
        thread3.start();

        Thread.sleep(5000);
        System.out.println("done");
        // 问题：主线程结束了，为什么子线程均还运行着？
        // 现象：会结束，跟 thread3.setDaemon(true); 无关。
    }

    @Override
    public void run() {

        synchronized (lock) {
            while (num < arr.length) {
                System.out.println(Thread.currentThread().getName() + " print num : " + arr[num]);
                ++num;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            lock.notify();
        }
    }
}
