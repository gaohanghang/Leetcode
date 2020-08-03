package a0算法面试题.单例设计模式.单例模式的七种写法.a2;

/**
 * @Description 懒汉式 ， 线程安全
 * @Author Gao Hang Hang
 * @Date 2019-09-10 21:10
 **/
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    /**
     * 使用 synchronize 关键字对方法加锁，确保任意时刻都只有一个线程可以执行该方法
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
