package a0面试题.单例设计模式.设计模式Java版;

/**
 * @Description
 * @Author Gao Hang Hang
 * @Date 2020-08-03 12:55
 **/
public class GlobalNum {

    private static GlobalNum gn = new GlobalNum();

    private int num = 0;

    public static GlobalNum getInstance() {
        return gn;
    }

    public synchronized int getNum() {
        return ++num;
    }

}
