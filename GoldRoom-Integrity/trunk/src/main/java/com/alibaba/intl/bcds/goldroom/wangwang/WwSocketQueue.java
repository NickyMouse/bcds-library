package com.alibaba.intl.bcds.goldroom.wangwang;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class WwSocketQueue {

    private static Log log = LogFactory.getLog(WwSocketQueue.class);
    
    private BlockingQueue<WwSocket> queue = null;
    
    private int MAX_QUEUE_SIZE = 500;
    
    private AtomicInteger size = new AtomicInteger(10);
    
    public WwSocketQueue(int size){
        this.size = new AtomicInteger(size);
        queue = new LinkedBlockingQueue<WwSocket>(this.size.get());
        // 这个地方如果spring初始化这个queue的时候 把队列填满，那么在poll方法取出的wws将不能操作，读取数据的时候会报Connection Reset。神能告诉我为什么吗？
        // 此处换成在poll方法的时候 如果当前队列值小于size，则new一个对象出来。就没问题了
//        for(int i=0; i<size; i++){
//            WwSocket wws = new WwSocket(i);
//            queue.add(wws);
//            log.info("add wws["+wws+"] into queue");
//        }
    }
    
    public synchronized WwSocket poll(){
        return poll(60);
    }
    
    public synchronized WwSocket poll(int seconds){
        WwSocket wws = null;
        try {
            if (queue.size() < this.size.get()) {
                wws = new WwSocket(queue.size());
                log.debug("queue size["+queue.size()+"], new wws["+wws+"]");
            }else{
                wws = queue.poll(seconds, TimeUnit.SECONDS);
                log.debug("queue size["+queue.size()+"], use old wws["+wws+"]");
            }
            log.debug("get wws["+wws+"],now queue zize["+queue.size()+"]");
        } catch (InterruptedException e) {
            log.error("poll socket error");
            e.printStackTrace();
            try {
                Thread.sleep(seconds);
            } catch (InterruptedException e1) {
                log.error("sleep error,this naver happen");
                e1.printStackTrace();
            } 
            log.error("sleep["+seconds+"],get a new socket");
            wws = new WwSocket(1414);
            this.size.addAndGet(1);
        }
        return wws;
    }
    
    public void offer(WwSocket wws) {
        if (queue.size() > MAX_QUEUE_SIZE) {
            log.info("close wws[" + wws + "],now queue zize[" + queue.size() + "]");
            wws.close();
        } else {
            queue.offer(wws);
            log.debug("release wws[" + wws + "],now queue zize[" + queue.size() + "]");
        }
    }
    
    public int getMAX_QUEUE_SIZE() {
        return MAX_QUEUE_SIZE;
    }

    public String toString(){
        return super.toString() + ", size["+this.size.getAndIncrement()+"]";
    }
}
