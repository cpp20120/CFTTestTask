package org.example.application;

import org.example.config.Options;
import org.example.parser.CommandLineParser;
import org.example.processor.ContentProcessor;
import org.example.statistics.Statistics;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {
    private final Options options;
    private final Statistics statistics;
    private final ContentProcessor processor;

    // Constructor with Dependency Injection
    public Application(Options options, Statistics statistics, ContentProcessor processor) {
        this.options = options;
        this.statistics = statistics;
        this.processor = processor;
    }

    // Logic remains unchanged
    public void run(String[] args) throws ApplicationException {
        CommandLineParser parser = new CommandLineParser();
        parser.parse(args, options);

        validateInputFiles(options.getInputFiles());
        processor.processFiles(options, statistics);
        statistics.print(options.isFullStatistics());
    }

    private void validateInputFiles(List<String> inputFiles) throws ApplicationException {
        if (inputFiles.isEmpty()) {
            throw new ApplicationException("No input files specified");
        }

        for (String file : inputFiles) {
            Path path = Paths.get(file);
            if (!Files.exists(path)) {
                throw new ApplicationException("Input file not found: " + file);
            }
            if (!Files.isReadable(path)) {
                throw new ApplicationException("Cannot read input file: " + file);
            }
        }
    }
}