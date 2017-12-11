package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;

import java.util.Collection;

public class CombinedEventLogger {

    Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers=loggers;
    }

    public void logEvent(Event event){
        for (EventLogger logger : loggers) {
            logger.logEvent(event);
        }
    }
}
