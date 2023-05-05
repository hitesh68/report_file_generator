package com.hiteshpoddar.services.fileService;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class FileManager implements IFileController{

    private static final String REPORT_FILE_PREFIX = "File-";
    private final Map<Integer,File> reportFileMap;

    public FileManager() {
        this.reportFileMap = new HashMap<>();
    }

    @Override
    public File getFile(int level) {

        if(reportFileMap.containsKey(level)) return reportFileMap.get(level);

        File file = new File(REPORT_FILE_PREFIX+level);
        reportFileMap.put(level, file);
        
        return file;
    }
    
}
