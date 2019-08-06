package org.hhraymond.algo.sort;

/**
 * @author hhraymond
 * @since 2019-08-06
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = new int[] { 5, 2, 8, 9, 6, 7, 1, 4, 3};

        System.out.println("未排序前");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }

        insertSort(data, data.length);

        System.out.println("\n排序后");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }

    //  插入已排好序的子数组中。
    public static void insertSort(int[] data, int n) {
        for (int i = 1; i < n; i++)
        {
            int temp = data[i];
            int j;
            for (j = i - 1; j >= 0 && data[j] > temp; j--)
            {
                data[j + 1] = data[j];//移动
            }
            data[j + 1] = temp;//插入
        }
    }

}
