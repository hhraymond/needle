/**
 * MultiThread.java
 * Copyright 2020 HelloBike , all rights reserved.
 * HelloBike PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package org.hhraymond.algo.thread;

import java.util.concurrent.*;

/**
 * 继承Thread
 * 　　优点:可以直接使用Thread类中的方法,代码简单
 * 　　缺点:继承Thread类之后就不能继承其他的类
 * 实现Runnable接口
 * 　　优点:即时自定义类已经有父类了也不受影响，因为可以实现多个接口
 * 　　缺点: 在run方法内部需要获取到当前线程的Thread对象后才能使用Thread中的方法
 * 实现Callable接口
 * 　　优点：可以获取返回值，可以抛出异常
 * 　　缺点：代码编写较为复杂
 * @author hhraymond
 * @date 2020/2/26
 */
public class MultiThread {
    public static void main(String[] args) {
        //resources就是竞争资源对象
        Resources resources = new Resources();
        MyThread myThread = new MyThread(resources);
        Runnable1 runnable1 = new Runnable1(resources);
        Callable1 callable1 = new Callable1(resources);


        for(int i = 0; i <10; i++) {
            new Thread(myThread,"Thread"+i).start();
        }

        for(int i = 10; i <20; i++) {
            // 这里是创建多线程去执行任务
            //多线程是竞争关系，所以多个线程竞争同一个资源，也就是同一个对象
            //所以这个竞争对象放到Thread中
            new Thread(runnable1,"Thread"+i).start();
        }

        for(int i = 20; i <30; i++) {
            //new Thread(callable1,"Thread"+i).start();
            FutureTask<Integer> future = new FutureTask<>(callable1);
            new Thread(future,"Thread"+i).start();
        }

        new Thread() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++) {
                    System.out.println("new Thread");
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i< 10; i++) {
                    System.out.println("new Runnable");
                }
            }
        }).start();

        // 默认会保留60秒，才会退出
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> result = exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception{
                return 1024;
            }
        });

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}

class Resources {
    private int count = 100;

    //多线程去干活了，它们争着抢着去执行竞争资源里面的方法，所以这个方法区域需要加锁
    public synchronized  void methodA() {
        if(count > 0) {
            count--;
        }
        System.out.println(Thread.currentThread().getName() + "  " +"count:"+count);
    }
}

//1.自定义一个类，继承java.lang包下的Thread类
class MyThread extends Thread{
    Resources resources = null;
    MyThread(Resources resources) {
        this.resources = resources;
    }
    //2.重写run方法
    @Override
    public void run() {
        //这个methodA方法时Resources里面的竞争资源方法
        resources.methodA();
        System.out.println("xxyyzz");
    }
}

class Runnable1 implements Runnable {
    Resources resources = null;
    Runnable1(Resources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        //这个methodA方法时Resources里面的竞争资源方法
        resources.methodA();
    }

}

class Callable1 implements Callable<Integer> {
    Resources resources = null;

    Callable1(Resources resources) {
        this.resources = resources;
    }

    @Override
    public Integer call() throws Exception {
        //这个methodA方法时Resources里面的竞争资源方法
        resources.methodA();
        return 1;
    }
}