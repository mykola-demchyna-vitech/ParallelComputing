package edu.ukd.util;

import java.time.Duration;
import java.time.LocalTime;

public class Timer {
    private LocalTime startTime;
    private LocalTime finishTime;

    public void start() {
        startTime = LocalTime.now();
    }

    public void stop() {
        finishTime = LocalTime.now();
    }

    public long duration(DurationType type) {
        return switch (type) {
            case MILLISECONDS -> Duration.between(startTime, finishTime).toMillis();
            case SECONDS -> Duration.between(startTime, finishTime).toSeconds();
            case MINUTES -> Duration.between(startTime, finishTime).toMinutes();
            case HOURS -> Duration.between(startTime, finishTime).toHours();
        };
    }
}
