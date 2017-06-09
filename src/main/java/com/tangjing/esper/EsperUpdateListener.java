//package com.tangjing.esper;
//
//import com.espertech.esper.client.EventBean;
//import com.espertech.esper.client.UpdateListener;
//import com.tangjing.esper.event.TestEvent;
//
///**
// * Describe:
// * User:tangjing
// * Date:2017/4/6
// * Time:上午11:05
// */
//
//public class EsperUpdateListener implements UpdateListener {
//
//    @Override
//    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
//            EventBean eb=newEvents[0];
//            System.out.println("id:" + eb.get("id") + " name:" + eb.get("name"));
//    }
//
//}
