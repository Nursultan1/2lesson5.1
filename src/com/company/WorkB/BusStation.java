package com.company.WorkB;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class BusStation extends  Thread {

    private Semaphore semaphore;
    private CountDownLatch cdl;

    public BusStation(String name, Semaphore semaphore, CountDownLatch cdl) {
        super(name);
        this.semaphore = semaphore;
        this.cdl = cdl;
    }

    public void run(){
        try {

            System.out.println(this.getName() + " прищел к кассе ");
            semaphore.acquire();
            sleep(1000);
            System.out.println(this.getName() + " купил билет ");
            semaphore.release();
            System.out.println(this.getName() + "занял место");
            cdl.countDown();
            cdl.await();

            if ("Пассажир100".equals(this.getName())) {
                System.out.println("пассажиры на месте , атобус выехал  ");

            }
        }catch (Exception error){

        }

    }
}
