package com.epam.zabara.core;

import com.epam.zabara.core.beans.Client;
import com.epam.zabara.core.enums.EventType;
import com.epam.zabara.core.event.Event;
import com.epam.zabara.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);

        event.setMsg("Some event for user 1");
        app.logEvent(EventType.ERROR, event);

        ctx.close();
    }

    private void logEvent(EventType type, Event event) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = defaultLogger;
        }
        event.setMsg(event.getMsg().replaceAll(client.getId(), client.getFullName()));
        logger.logEvent(event);
    }
}
