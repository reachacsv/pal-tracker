package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("time-entries")
public class TimeEntryController {
    TimeEntryRepository timeEntryRepository;
    private final CounterService counter;
    private final GaugeService gauge;

    /*public TimeEntryController(@Autowired TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }*/

    public TimeEntryController(
            TimeEntryRepository timeEntryRepository,
            CounterService counter,
            GaugeService gauge
    ) {
        this.timeEntryRepository = timeEntryRepository;
        this.counter = counter;
        this.gauge = gauge;
    }
    //@PostMapping("/time-entries")
    @PostMapping("")
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry timeEntryCreated = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(timeEntryCreated, HttpStatus.CREATED);
    }

    //@GetMapping("/time-entries/{id}")
    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry != null)
            return ResponseEntity.ok(timeEntry); //return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build(); //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@GetMapping("/time-entries")
    @GetMapping()
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntries = timeEntryRepository.list();
        return ResponseEntity.ok(timeEntries); //return new ResponseEntity<>(timeEntries, HttpStatus.OK);
    }

    //@PutMapping("/time-entries/{id}")
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(id, expected);
        if(timeEntry != null)
            return ResponseEntity.ok(timeEntry); //return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        else
            return ResponseEntity.notFound().build(); //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@DeleteMapping("/time-entries/{id}")
    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id) {
        TimeEntry timeEntry = timeEntryRepository.delete(id);
        if(timeEntry != null)
            return ResponseEntity.noContent().build(); //return new ResponseEntity<>(timeEntry, HttpStatus.NO_CONTENT);
        else
            return ResponseEntity.noContent().build(); //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
