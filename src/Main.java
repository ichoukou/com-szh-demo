import java.util.ArrayList;
import java.util.List;

public class Main {
   /* public static int getMiddel(int[] a, int low, int high) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp)
                high--;
            a[low] = a[high];
            while (low < high && a[low] <= temp)
                low++;
            a[high] = a[low];
        }
        a[high] = temp;
        return high;
    }*/

    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int temp = a[low];
            while (low < high) {
                while (low < high && a[high] >= temp)
                    high--;
                a[low] = a[high];
                while (low < high && a[low] <= temp)
                    low++;
                a[high] = a[low];
            }
            a[low] = temp;
            int middle = low;
            System.out.println(low);
            quickSort(a, low, middle - 1);
            quickSort(a, middle + 1, high);
        }
    }

    public static void quickSort(int[] a) {
        if (a.length > 0)
            quickSort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
     /*   int a[] = new int[]
                {
                        34, 55, 78, 9, 2, 1, 44, 43, 1, 233
                };
        quickSort(a);
        for (int xx : a)
            System.out.print(xx + "\t");*/
        String content = "实施是否但是是的方式地方【是是是】实施地方【是神色】";
        if (content.contains("】") && content.endsWith("】")) {
            content = content.substring(0, content.lastIndexOf("【")) + "退订回Ｔ" + content.substring(content.lastIndexOf("【"));
        } else {
            content = content + "退订回Ｔ";
        }
        System.out.println(content);
    }
}
