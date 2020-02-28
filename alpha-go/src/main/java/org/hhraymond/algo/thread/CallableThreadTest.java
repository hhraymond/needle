/**
 * CallableThreadTest.java
 * Copyright 2020 HelloBike , all rights reserved.
 * HelloBike PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package org.hhraymond.algo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author huangzhen10408
 * @date 2020/2/26
 */
public class CallableThreadTest implements Callable<Integer> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        new Thread(ft, "有返回值的线程").start();
        System.out.println("子线程的返回值" + ft.get());
    }

    @Override
    public Integer call() {
        int i;
        for (i = 0; i < 10; i += 2) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}
