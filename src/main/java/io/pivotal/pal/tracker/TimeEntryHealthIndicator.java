package io.pivotal.pal.tracker;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeEntryHealthIndicator implements HealthIndicator {
    private static int MAX_TIME_ENTRIES = 5;
    TimeEntryRepository repo;
    public TimeEntryHealthIndicator(TimeEntryRepository repo) {
        this.repo = repo;
    }

    @Override
    public Health health() {
        if(repo.list().size() > 5) {
            return Health.down().build();
        } else {
            return Health.up().build();
        }
    }
}
