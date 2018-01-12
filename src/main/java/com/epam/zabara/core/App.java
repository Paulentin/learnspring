package com.epam.zabara.core;

import com.epam.zabara.core.beans.Client;
import com.epam.zabara.core.event.Event;
import com.epam.zabara.core.loggers.EventLogger;
import com.epam.zabara.core.loggers.EventType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType,EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean("app", App.class);
        app.eventLogger.logEvent(new Event(new Date(56496879), new DateFormat() {
            @Override
            public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
                return toAppendTo.append(date);
            }

            @Override
            public Date parse(String source, ParsePosition pos) {
                try {
                    return new Date(parse(source).getTime());
                } catch (ParseException ignored) {

                }
                return null;
            }
        }));
        ctx.close();
//        app.logEvent(Ev);
    }

    private void logEvent(Event event) {
        eventLogger.logEvent(event);
    }
}
