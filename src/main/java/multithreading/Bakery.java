package multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * @author donald
 * @date 2022/07/07
 */
public class Bakery {

    class Bread {

    }

    private final List<Bread> breads = new ArrayList<>();
    private final int maxCapacity;

    private Bakery(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void put(Bread bread) throws InterruptedException {
        synchronized (breads) { // 步骤一：锁定资源
            while (breads.size() == this.maxCapacity) { // 步骤二：询问，阻塞生产者
                // 没有可存储的空间，阻塞生产者，等待有存储空间后再继续
                breads.wait(); // 步骤三：阻塞
            }
            breads.add(bread);
            breads.notifyAll(); // 步骤四：唤醒消费者
        }
    }

    public Bread get() throws InterruptedException {
        Bread bread = null;
        synchronized (breads) {
            while (breads.isEmpty()) {
                breads.wait();
            }
            bread = breads.remove(breads.size() - 1);
            breads.notifyAll();
        }
        return bread;
    }
}
