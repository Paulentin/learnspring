package com.epam.zabara.core.loggers;


import com.epam.zabara.core.event.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;


    public FileEventLogger() {
    }

    public void init() {
        file = new File(fileName);
        file.canWrite();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
        file = new File(fileName);
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
