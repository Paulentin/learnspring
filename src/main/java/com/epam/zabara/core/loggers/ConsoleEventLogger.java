package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
