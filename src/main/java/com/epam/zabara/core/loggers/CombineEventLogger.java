package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;

import java.util.Collection;

public class CombineEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombineEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
