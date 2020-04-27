package org.hhraymond.algo.matrix;

/**
 * // 给定一个由 ‘1’（陆地）和 ‘0’（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * // 示例：
 * // Input:
 * // 11000
 * // 11000
 * // 00100
 * // 00011
 * // Output: 3
 *
 * @author hhraymond
 * @since 2020-04-27
 */
public class SearchIsland {
    public static void main(String[] args) {
        int[][] data = new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}
        };
        // isvisit表示是否遍历过
        int[][] isvisit = new int[data.length][data[0].length];
        System.out.println(dfs(data, isvisit));
    }

    public static int dfs(int[][] island, int[][] isvisit) {
        int rowLen = island.length;
        int colLen = island[0].length;
        int count = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (isvisit[i][j] != 1) {
                    // 表示是第一个1，进行加一
                    if (island[i][j] == 1) {
                        count++;
                    }
                    // 深度优先搜索
                    dfsSearch(island, isvisit, i, j);
                    System.out.println("--------");
                }
            }
        }
        return count;
    }

    public static void dfsSearch(int[][] island, int[][] isvisit, int i, int j) {
        int rowLen = island.length;
        int colLen = island[0].length;
        // 数组越界
        if (i<0 || j<0 || i>rowLen-1 || j>colLen-1) {
            return;
        }
        // 不是陆地
        if (island[i][j] == 0) {
            return;
        }
        // 已经遍历过了
        if (isvisit[i][j] == 1) {
            return;
        } else {  // 未遍历
            isvisit[i][j] = 1;
            System.out.println("i=" + i + ",j=" + j);
            dfsSearch(island,isvisit,i,j-1);//左
            dfsSearch(island,isvisit,i,j+1);//右
            dfsSearch(island,isvisit,i-1,j);//上
            dfsSearch(island,isvisit,i+1,j);//下
        }
    }

}
