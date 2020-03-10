package com.wwy.study.s1;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App
{
     volatile int count;

    public void add(){
        count++;
    }

    public static void main( String[] args ) {
        final App p1 = new App();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    p1.add();
                    System.out.println(p1.count);

                    try{
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){

                    if(p1.count == 5){
                        System.out.println("end");
                        break;
                    }
                }

            }
        });

        t2.start();
        t1.start();

    }


}
