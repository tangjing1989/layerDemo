package com.tangjing.esper;

import com.tangjing.esper.event.TestEvent;

/**
 * Describe:
 * User:tangjing
 * Date:2017/4/5
 * Time:下午4:21
 */


public class HelloEsper {
//    public static void main(String[] args) {
//
//        Thread espRunnable = new Thread(new EspRunnable());
//        espRunnable.run();
//
//        EspSendThread espSendThread = new EspSendThread();
//        espSendThread.run();
//    }
}

class EspRunnable implements Runnable {
    public void run() {
        EsperConfig esperConfig = new EsperConfig();
        esperConfig.getEPRuntime();
    }
}


class EspSendThread extends Thread {
    public void run() {
        EsperConfig esperConfig = new EsperConfig();
        int         num         = 0;
        esperConfig.sendEvent(null);
        while (true) {
            TestEvent myEvent = new TestEvent(++num, "hah" + num);
            esperConfig.sendEvent(myEvent);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}