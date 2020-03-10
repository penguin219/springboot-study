package com.wwy.study.s2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReentrantLock1 {
    List<Integer> list = new ArrayList<Integer>();
    int num;

    public synchronized void put(){
        if(getCount()<10){

            list.add(1);
            System.out.println("produce: "+list.size() );
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public synchronized void get(){

        if(getCount()>0){

            System.out.println("consume: "+list.size() );
            list.remove(list.size()-1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public  int getCount(){
        return list.size();
    }

    public static void main(String[] args) {
        final ReentrantLock1 r = new ReentrantLock1();

        Thread producer1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    r.put();
                }


            }
        });

        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(r.getCount()!=10){
//                    r.put();
//                }

                while(true){
                    r.put();
                }
            }
        });

        Thread consume1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(r.getCount()!=0){
//                    r.get();
//                }
                while(true){
                    r.get();
                }
            }
        });

        Thread consume2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(r.getCount()!=0){
//                    r.get();
//                }
                while(true){
                    r.get();
                }
            }
        });

        Thread consume3 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(r.getCount()!=0){
//                    r.get();
//                }
                while(true){
                    r.get();
                }
            }
        });

        Thread consume4 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(r.getCount()!=0){
//                    r.get();
//                }
                while(true){
                    r.get();
                }
            }
        });

        producer2.start();
        producer1.start();
        consume1.start();
        consume2.start();
        consume3.start();
        consume4.start();

    }

}
