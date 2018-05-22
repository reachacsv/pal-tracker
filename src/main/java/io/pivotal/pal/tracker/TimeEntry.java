package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TimeEntry {
    private long id;
    private long projectId;
    private long userId;
    private LocalDate date;
    private int hours;

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {
        this.id = id;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {
        //this.id = repo.getMaxId() + 1; //default to 1
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry() {
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TimeEntry) {
            TimeEntry o = (TimeEntry) obj;
            return (
                o.id == this.id && //do not use this attribute for comparison
                o.projectId == this.projectId && //do not use this attribute for comparison
                o.userId == this.userId &&
                o.date.equals(this.date) &&
                o.hours == this.hours
            );
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
}
