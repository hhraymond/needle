package org.hhraymond.algo.sort;

/**
 * @author hhraymond
 * @since 2019-08-06
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = new int[] { 5, 2, 8, 9, 6, 7, 1, 4, 3};

        System.out.println("未排序前");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }

        bubbleSort(data);

        System.out.println("\n排序后");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }

    public static void bubbleSort(int[] data) {
        for(int i = 0; i < data.length - 1; ++i) {
            for (int j = i; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }
}
