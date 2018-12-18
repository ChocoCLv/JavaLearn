package com.choco.TAOJCP;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws Exception{
        BusyRunner busyRunner = new BusyRunner();
        Thread busyThread = new Thread(busyRunner,"busyThread");
        busyThread.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println(busyThread.isInterrupted());

        busyThread.interrupt();

        System.out.println(busyRunner.count);
        System.out.println(busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(1);
        System.out.println(busyRunner.count);
    }

    static class BusyRunner implements Runnable{
        public int count = 0;
        @Override
        public void run(){
            while (!Thread.interrupted()){
                count++;
            }
        }
    }
}
