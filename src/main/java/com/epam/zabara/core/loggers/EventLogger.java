package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;

public interface EventLogger {
     void logEvent(Event event);
}
