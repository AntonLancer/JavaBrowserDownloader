package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class RequestCounter {

    private int postCount = 0;
    private int getCount = 0;

    public synchronized void incrementPostCount() {
        postCount++;
        System.out.println(postCount);
    }

    public synchronized void incrementGetCount() {
        getCount++;
        System.out.println(getCount);
    }

    public synchronized int getPostCount() {
        return postCount;
    }

    public synchronized int getGetCount() {
        return getCount;
    }
}
