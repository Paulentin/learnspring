package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;

interface EventLogger {
     void logEvent(Event event);
}
