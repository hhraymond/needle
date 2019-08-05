package org.hhraymond.algo.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hhraymond
 * @since 2019-08-01
 */
public class NXNTest {
    private static int[][] data=new int[][]{{1,3,4,2,5,7}, {9,8,1,6,9,8},{2,1,4,6,7,2},{0,1,5,7,2,9},{4,6,3,2,7,2},{6,7,2,8,2,5}};
    private static List<Integer> res=new ArrayList<>();

    /**
     * 遍历一圈
     * @param startPoint 起点
     * @param endPoint 终点
     * */
    public static void oneLap(int startPoint, int endPoint){
        for (int i = startPoint; i <= endPoint; i++){
            res.add(data[startPoint][i]);
            if (i == endPoint){
                for (int j = startPoint + 1;j <= endPoint; j++){
                    res.add(data[j][endPoint]);
                    if (j == endPoint){
                        for (int i2 = endPoint-1; i2 >= startPoint; i2--){
                            res.add(data[endPoint][i2]);
                            if (i2 == startPoint){
                                for (int j2 = endPoint-1; j2 > startPoint; j2--){
                                    res.add(data[j2][startPoint]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 遍历每一圈
     * **/
    public static void everyLap(int startPoint, int endPoint){
        while (startPoint <= endPoint){
            System.out.println("start= " + startPoint + " end= " + endPoint);
            oneLap(startPoint++, endPoint--);
        }
    }

    public static void main(String[] args) {
        everyLap(0, data.length - 1);
        System.out.println(res.toString());
    }

}
