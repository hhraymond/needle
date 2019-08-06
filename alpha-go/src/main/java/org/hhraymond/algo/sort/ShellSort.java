package org.hhraymond.algo.sort;

/**
 * @author hhraymond
 * @since 2019-08-06
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] data = new int[] { 5, 2, 8, 9, 6, 7, 1, 4, 3};

        System.out.println("未排序前");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }

        shellSort(data);

        System.out.println("\n排序后");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
    }

    // 希尔排序采用跳跃式分组策略，通过某个增量将数组元素划分成若干组，然后分组进行插入排序，随后逐步缩小增量，直至增量为1.
    // 在初始阶段达到基本有序，然后缩小增量，到增量为1时，大多数情况只需微调，不会涉及过多数据移动
    public static void shellSort(int[] data) {
        int j, max;
        // 计算每次循环间距
        for (int step = data.length / 2; step > 0; step /= 2) {

            // 进行插入排序
            for (int i = step; i < data.length; i++) {
                max = data[i];
                for (j = i; j >= step; j -= step) {
                    if(max < data[j - step]){
                        data[j] = data[j - step];
                    }else{
                        break;
                    }
                }
                data[j] = max;
            }
        }
    }

}
