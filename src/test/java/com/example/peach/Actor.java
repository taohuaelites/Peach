package com.example.peach;

/**
 * Author: zhangzhen
 * DATE: Created in 2018/8/14 9:15
 * Description:
 */
public class Actor extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "是一个演员!");
        int count = 0;
        boolean keepRuning = true;
        while(keepRuning) {
            System.out.println(getName() + "登台演出:" + (++count));
            if(count == 100) {
                keepRuning = false;
            }
            if(count%10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "演出结束了!");
    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actressThread = new Thread(new Actress(), "Mr.Runnable");
        actressThread.start();
    }
}
class Actress implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "是一个演员");
        int count = 0;
        boolean keepRuning = true;
        while(keepRuning) {
            System.out.println(Thread.currentThread().getName() + "登台演出:" + (++count));
            if(count == 100) {
                keepRuning = false;
            }
            if(count%10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "演出结束了!");
    }
}
