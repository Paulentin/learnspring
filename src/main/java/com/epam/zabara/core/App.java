package com.epam.zabara.core;

import com.epam.zabara.core.beans.Client;
import com.epam.zabara.core.event.Event;
import com.epam.zabara.core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;


    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        Event event = ctx.getBean(Event.class);

        event.setMsg("Some event for user 1");
        app.logEvent(event);

        ctx.close();
    }

    private void logEvent(Event event) {

        event.setMsg(event.getMsg().replaceAll(client.getId(), client.getFullName()));
        eventLogger.logEvent(event);
    }
}
