package org.hhraymond.algo.sort;

/**
 * @author hhraymond
 * @since 2019-08-07
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] data = new int[] { 5, 2, 8, 9, 6, 7, 1, 4, 3};

        System.out.println("未排序前");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }

        SelectionSort(data);

        System.out.println("\n排序后");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }

    public static void SelectionSort(int[] data) {
        //选择排序的优化
        for(int i = 0; i < data.length - 1; i++) {// 做第i趟排序
            int k = i;
            for(int j = k + 1; j < data.length; j++){// 选最小的记录
                if(data[j] < data[k]){
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if(i != k){ //交换a[i]和a[k]
                int temp = data[i];
                data[i] = data[k];
                data[k] = temp;
            }
        }
    }
}
