package org.hhraymond.algo.sort;

/**
 * @author hhraymond
 * @since 2019-08-06
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] data = new int[] { 5, 2, 8, 9, 6, 7, 1, 4, 3};

        System.out.println("未排序前：");
        for (int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }

        headSort(data);

        System.out.println("\n排序后：");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");

        System.out.println("\n插入：");
        // 插入
        insert(data, 3);

        System.out.println("\n删除：");
        // 删除最小
        deleteMin(data);
    }

    /**
     * 堆排序
     */
    public static void headSort(int[] list) {
        //构造初始堆,从第一个非叶子节点开始调整,左右孩子节点中较大的交换到父节点中
        for (int i = (list.length) / 2 - 1; i >= 0; i--) {
            percDown(list, list.length, i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新调整
        for (int i = list.length - 1; i >= 1; i--) {
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            percDown(list, i,0);
        }
    }

    /**
     *
     * len 堆大小； i 下滤起点
     *
     */
    private static void percDown(int[] list, int len, int hole) {
        int child;
        int tmp = list[hole];
        for (; hole * 2 + 1 <= len - 1; hole = child) {
            child = hole * 2 + 1;
            if (child != len - 1 && list[child] < list[child + 1]) {
                child++;
            }
            if (tmp < list[child]) {
                list[hole] = list[child];
            } else {
                break;
            }
        }
        list[hole] = tmp;
    }

    // 先插入末尾，在逐步”上滤”
    private static void insert(int[] list, int x) {
        int[] newList = new int[list.length + 1];
        for(int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        //System.out.println("list: " + list.length + ", newList: " + newList.length);
        int hole = list.length;
        System.out.println("newList hole: " + newList[hole] + ", hole/2: " + newList[hole/2]);
        for(; hole > 1 && x < newList[hole / 2]; hole /= 2 ) {
            System.out.println("newList hole: " + newList[hole] + ", hole/2: " + newList[hole/2]);
            newList[hole] = newList[hole / 2];
        }
        newList[hole] = x;
        for (int i = 0; i < newList.length; i++)
            System.out.print(newList[i] + " ");
    }

    // 先删根节点，把末尾数据填入根节点再逐步“下滤”
    private static void deleteMin(int[] list) {
        list[0] = list[list.length - 1];
        percolateDown(list, 0);
    }

    private static void percolateDown(int[] list, int hole) {
        int child;
        int tmp = list[hole];
        for (; hole * 2 + 1 <= list.length - 1; hole = child) {
            child = hole * 2 + 1;
            if (child != list.length - 1 && list[child] > list[child + 1]) {
                child++;
            }
            if (tmp > list[child]) {
                list[hole] = list[child];
            } else {
                break;
            }
        }
        list[hole] = tmp;

        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}
