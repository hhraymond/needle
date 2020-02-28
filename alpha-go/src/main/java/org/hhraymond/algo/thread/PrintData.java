/**
 * PrintData.java
 * Copyright 2020 HelloBike , all rights reserved.
 * HelloBike PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package org.hhraymond.algo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangzhen10408
 * @date 2020/2/27
 */
public class PrintData {

    List<Integer> data = new ArrayList<>();
    Map<String, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        System.out.println("hello world1");

        new Thread() {
            @Override
            public void run() {
                System.out.println("new thread hello world");
            }
        }.start();

        System.out.println("hello world2");
    }
}
