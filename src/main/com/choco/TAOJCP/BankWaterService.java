package com.choco.TAOJCP;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    //创建4个屏障
    private CyclicBarrier c = new CyclicBarrier(4, this);

    //启动四个线程
    private Executor executor = Executors.newFixedThreadPool(4);

    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    //处理数据
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);

                    try {
                        c.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
            result+=sheet.getValue();
        }

        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }


    public static void main(String[] args){
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count(); 
    }
}
