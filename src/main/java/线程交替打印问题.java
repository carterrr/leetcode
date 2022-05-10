import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 线程交替打印问题 {
    static volatile int cur = 1;

    /*public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                synchronized (lock) {
                    while (cur % 2  == 1) {  // 线程1 打印偶数
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("1-" + cur ++);
                    lock.notify();
                }
            }
        }).start();


        new Thread(() -> {
            for (int i = 1; i <= 50; i++) {
                synchronized (lock) {
                    while (cur % 2  == 0) { // 线程2打印奇数
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("2-" + cur ++);
                    lock.notify();
                }
            }
        }).start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock rl = new ReentrantLock();
        Condition a = rl.newCondition();
        Condition b = rl.newCondition();

        new Thread(()->{

            for (int i = 0; i < 50; i++) {
                rl.lock(); 
                // 如果 cur 为偶数  线程A先等在这里 等待被唤醒
                // 如果 cur 为奇数  线程A直接打印并唤醒B  ---- 时间点1
                while (cur % 2 != 1) {
                    try {
                        a.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A" + cur ++); 
                b.signal();  // ---- 时间点1
                rl.unlock();
            }

        }, "A").start();
        Thread.sleep(1000);
        
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                rl.lock();
                // 如果 b.await() 在cur++ 后 此时 cur为偶数  不会进入b.await()  而是直接打印并唤醒a
                // 如果 b.await() 在cur++ 前  此时等待线程A来唤醒b
                while (cur % 2 != 0) {
                    try {
                        b.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B" + cur ++);
                a.signal();
                rl.unlock();
            }


        }, "B").start();


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}