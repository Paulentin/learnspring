package com.epam.zabara.core.loggers;

import com.epam.zabara.core.event.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException("Can't write into file");
        }
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.getMsg(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
