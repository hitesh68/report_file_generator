package com.hiteshpoddar.appConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.hiteshpoddar.entities.IRecord;
import com.hiteshpoddar.services.fileService.IFileController;

public class ReportLogger {

    private final IFileController fileController;
    
    public ReportLogger(IFileController fileController) {

        this.fileController = fileController;

    }

    public void log(IRecord record) {

        final int recordLevel = record.getLevel();
        final File reportFile = fileController.getFile(recordLevel);
        
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile, true))) {

            bufferedWriter.write(record.getRecordInString() + "\n");
            bufferedWriter.close();

        } catch (IOException exception) {

            System.out.println(exception.getMessage());
        } 

    }
}
