package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.metrics.CounterService;

import java.util.HashMap;

public class CounterServiceImpl implements CounterService {

    HashMap<String, Integer> counter = new HashMap<>();

    @Override
    public void increment(String metricName) {
        if(counter.containsKey(metricName)) {
            counter.put(metricName, counter.get(metricName)+1);
        } else {
            counter.put(metricName, 1);
        }
    }

    @Override
    public void decrement(String metricName) {
        if(counter.containsKey(metricName)) {
            counter.put(metricName, counter.get(metricName)-1);
        } else {
            
        }
    }

    @Override
    public void reset(String metricName) {
        if(counter.containsKey(metricName)) {
            counter.put(metricName, 0);
        } else {

        }
    }
}
