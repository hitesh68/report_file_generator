package com.hiteshpoddar.appConfig;

import com.hiteshpoddar.services.fileService.FileManager;
import com.hiteshpoddar.services.fileService.IFileController;

public class ApplicationConfig {
    
    private final IFileController fileController;
    private final ReportLogger reportLogger;

    /**
     * 
     */
    public ApplicationConfig() {

        this.fileController = new FileManager();
        this.reportLogger = new ReportLogger(fileController);
    }

    public ReportLogger getReportLogger() {
        
        return this.reportLogger;
    }
}
