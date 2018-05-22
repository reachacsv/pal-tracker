package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    public TimeEntry find(long l);

    public TimeEntry create(TimeEntry any);

    public List<TimeEntry> list();

    public TimeEntry update(long eq, TimeEntry any);

    public TimeEntry delete(long l);

}
