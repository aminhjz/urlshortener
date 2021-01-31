package com.aminhjz.interview.urlshortner.urlshortner.service;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.RetryForever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IdGeneratorService {
    private final DistributedAtomicLong distributedAtomicLong;

    @Autowired
    public IdGeneratorService(CuratorFramework curatorFramework) {
        this.distributedAtomicLong = new DistributedAtomicLong(curatorFramework, "/urlshortener/counter-0", new RetryForever(100));
    }

    public Long generateId() {
        try {
            AtomicValue<Long> longAtomicValue = this.distributedAtomicLong.increment();
            while (!longAtomicValue.succeeded()) {
                longAtomicValue = this.distributedAtomicLong.increment();
            }
            return longAtomicValue.postValue();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get sequence number!", e);
        }
    }
}
