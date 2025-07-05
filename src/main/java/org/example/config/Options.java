package org.example.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Options {
    private String outputPath = ".";
    private String filePrefix = "";
    private boolean appendMode = false;
    private boolean fullStatistics = false;
    private boolean shortStatistics = false;
    private final List<String> inputFiles = new ArrayList<>();

    public String getOutputPath() { return outputPath; }
    public void setOutputPath(String outputPath) { this.outputPath = outputPath; }
    public String getFilePrefix() { return filePrefix; }
    public void setFilePrefix(String filePrefix) { this.filePrefix = filePrefix; }
    public boolean isAppendMode() { return appendMode; }
    public void setAppendMode(boolean appendMode) { this.appendMode = appendMode; }
    public boolean isFullStatistics() { return fullStatistics; }
    public void setFullStatistics(boolean fullStatistics) { this.fullStatistics = fullStatistics; }
    public boolean isShortStatistics() { return shortStatistics; }
    public void setShortStatistics(boolean shortStatistics) { this.shortStatistics = shortStatistics; }
    public List<String> getInputFiles() { return Collections.unmodifiableList(inputFiles); }
    public void addInputFile(String file) { inputFiles.add(file); }
}