package a0算法面试题.八大排序算法.a4_归并排序;

import java.util.logging.Level;

/**
 * 时间复杂度: O(nlogn)
 * 空间复杂度: O(n)
 * 稳定性: 稳定
 * 复杂性: 较复杂
 *
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/19 22:15
 */
public class Merge {

    private static int[] aux;      // 归并所需的辅助数组

    public static void sort(int[] a) {
        aux = new int[a.length];   // 一次性分配空间
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int lo, int hi) {
        // 将数组a[lo..hi]排序
        if (hi <= lo) return;       // 边界条件
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);            // 将左半边排序
        sort(a, mid + 1, hi);    // 将右半边排序
        merge(a, lo, mid, hi);       // 归并结果
    }

    public static void merge(int[] a, int lo, int mid, int hi) {
        // 将a[lo..mid] 和 a[mid+1..hi] 归并
        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) // 将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++) { // 归并回到a[lo..hi]
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(int[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    private static boolean isSorted(int[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] a = {5, 6, 9, 1, 2, 3, 19};
        sort(a);
        show(a);
    }
}
