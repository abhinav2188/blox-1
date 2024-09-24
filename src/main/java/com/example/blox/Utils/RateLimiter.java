package com.example.blox.Utils;


import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Slf4j
public class RateLimiter implements RateLimiterInterface{

    private int requestsAllowed;
    private int intervalTimeInMillis;

    private Queue<Integer> tokenBucket;

    public RateLimiter(int intervalTimeInMillis, int requestsAllowed) {
        this.intervalTimeInMillis = intervalTimeInMillis;
        this.requestsAllowed = requestsAllowed;
        tokenBucket = new ConcurrentLinkedQueue<>();
        initializeBucket();
    }

    private void initializeBucket() {
        for(int i=1; i<=requestsAllowed; i++){
            tokenBucket.add(i);
        }
        log.info("{} tokens added to the bucket", requestsAllowed);
    }

    @Override
    public boolean acquire() {
        if(!tokenBucket.isEmpty() ){
            int token = tokenBucket.poll();
            addTokenAfterTimeout(token);
            return true;
        }
        else{
            return false;
        }
    }


    private void addTokenAfterTimeout(int token) {
        Thread thread = new Thread(()->{
            log.info("{} token to be added after {} ms", token, intervalTimeInMillis);
            try{
                Thread.sleep(intervalTimeInMillis);
            }catch(Exception e){
                log.error("error while thread sleep",e);
            }
            tokenBucket.add(token);
        });
    }


}
