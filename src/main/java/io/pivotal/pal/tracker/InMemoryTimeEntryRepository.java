package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    List<TimeEntry> timeEntries = new ArrayList<>();
    @Override
    public TimeEntry find(long id) {
        for(TimeEntry timeEntry: timeEntries) {
            if(timeEntry.getId() == id)
                return timeEntry;
        }
        return null;
    }

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry.getId() == 0)
            timeEntry.setId(getMaxId() + 1);
        timeEntries.add(timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        TimeEntry timeEntrytoBeUpdated = find(id);
        timeEntrytoBeUpdated.setProjectId(timeEntry.getProjectId());
        timeEntrytoBeUpdated.setUserId(timeEntry.getUserId());
        timeEntrytoBeUpdated.setDate(timeEntry.getDate());
        timeEntrytoBeUpdated.setHours(timeEntry.getHours());
        return timeEntrytoBeUpdated;
    }

    @Override
    public TimeEntry delete(long id) {
        TimeEntry timeEntry = find(id);
        timeEntries.remove(timeEntry);
        return timeEntry;
    }

    public long getMaxId() {
        if(timeEntries == null || timeEntries.isEmpty())
            return 0;
        long maxId = 0;
        for(TimeEntry timeEntry: timeEntries) {
            if(timeEntry.getId() > maxId)
                maxId = timeEntry.getId();
        }
        return maxId;
    }

    @Override
    public List<TimeEntry> list() {
        return timeEntries;
    }
}
