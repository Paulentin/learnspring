package com.epam.zabara.core.loggers;


import com.epam.zabara.core.event.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;

    private List<Event> cache;
    public CacheFileEventLogger() {
        cache = new ArrayList<Event>();
    }

    public void setCacheSize(int cacheSize) {
        this.cacheSize = cacheSize;
    }


    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
