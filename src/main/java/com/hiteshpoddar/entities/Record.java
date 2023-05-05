package com.hiteshpoddar.entities;

public class Record implements IRecord{

    private final String recordInString;
    private final int level;

    public Record(String recordInString) {
        this.recordInString = recordInString;
        this.level = computeLevel();
    }

    private int computeLevel() {

        int level = 0;
        String[] columns = recordInString.split(" ", 2);

        for (char character : columns[0].toCharArray()) {
            if(character == '.') level++;
        }
        // String[] tokens = columns[0].split(".");

        return ++level;
    }

    @Override
    public int getLevel() {

        return this.level;
    }

    public String getRecordInString() {
        return recordInString;
    }
    
}
