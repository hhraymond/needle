package org.hhraymond.algo.matrix;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 每行的元素从左到右升序排列。
 每列的元素从上到下升序排列。

 示例: 现有矩阵 matrix 如下：
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。
 给定 target = 20，返回 false。
 *
 * @author hhraymond
 * @since 2019-09-01
 */
public class SearchMatrix {
    public static void main(String[] args) {
       int[][] data = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(searchMatrix(data, 5));
        System.out.println(searchMatrix(data, 20));
        System.out.println(searchMatrix2(data, 5));
        System.out.println(searchMatrix2(data, 20));
    }

    // 以左下角的数为基准，小于目标值，则向右移动，大于目标值，则向上移动
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;
        while (row>=0 && col<=matrix[0].length-1){
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                row--;
            }else{
                col++;
            }
        }

        return false;
    }

    //对每一行做二分查找
    public static boolean searchMatrix2(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; ++i){
            int left = 0;
            int right = matrix[i].length-1;
            while (left <= right){
                int mid = left + (right-left)/2;
                if (matrix[i][mid] > target){
                    right = mid - 1;
                }else if (matrix[i][mid] < target){
                    left = mid + 1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
