package org.hhraymond.tesla;

import java.io.FileInputStream;

/**
 * @author hhraymond
 * @since 2019-04-29
 */
public class TryCatchException {

    public static void main(String[] args) {
        TryCatchException try1 = new TryCatchException();
        try {
            System.out.println(try1.amethod());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int amethod() throws Exception {
        try {
            // 1，抛出异常
            FileInputStream dis = new FileInputStream("test1.txt");
//        } catch (Exception ex) {
//            // 2.catch捕获异常，并执行
//            System.out.println("No such file found");
//            // 4,return 返回
//            throw ex;
//            //return -1;
        } finally {
            // 3.finally一定会在return之前执行。（准确说，应该是return;语句）
            System.out.println("Done finally");
        }
        return 0;
    }

}
