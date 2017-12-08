package com.epam.zabara.core;

import com.epam.zabara.core.beans.Client;
import com.epam.zabara.core.event.Event;
import com.epam.zabara.core.loggers.ConsoleEventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    ConsoleEventLogger eventLogger;

    public App(Client client, ConsoleEventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);
//        app.logEvent(Ev);
    }

    private void logEvent(Event event) {
        eventLogger.logEvent(event);
    }
}
