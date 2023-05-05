package com.hiteshpoddar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.hiteshpoddar.appConfig.ApplicationConfig;
import com.hiteshpoddar.appConfig.ReportLogger;
import com.hiteshpoddar.entities.IRecord;
import com.hiteshpoddar.entities.Record;


public class App {
    public static void main(String[] args) {

        ApplicationConfig applicationConfig = new ApplicationConfig();
        ReportLogger reportLogger = applicationConfig.getReportLogger();

        for (String file : args) {
            
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

                String line = bufferedReader.readLine();
    
                while(line != null) {
    
                    IRecord record = new Record(line);
                    reportLogger.log(record);
    
                    line = bufferedReader.readLine();
                }
    
                bufferedReader.close();
    
            } catch (IOException ioException) {
    
                System.out.println(ioException.getMessage());
            }
        }

        
    }
}
