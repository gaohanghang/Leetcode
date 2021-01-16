package a0面试题.多线程.死锁;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2021-01-09 16:21
 **/
public class DeadLockDemo2 {

    private static Object resource1 = new Object();//资源 1
    private static Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");

                }
            }
        }, "线程 1").start();

        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");

                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");

                }
            }
        }, "线程 2").start();
    }
}
