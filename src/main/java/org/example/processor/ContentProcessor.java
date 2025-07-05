package org.example.processor;

import org.example.application.ApplicationException;
import org.example.config.DataType;
import org.example.config.Options;
import org.example.statistics.Statistics;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class ContentProcessor {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("^-?\\d+$");
    private static final Pattern FLOAT_PATTERN = Pattern.compile("^-?\\d+\\.\\d+(?:[eE][-+]?\\d+)?$");

    public void processFiles(Options options, Statistics statistics) throws ApplicationException {
        Map<DataType, BufferedWriter> writers = new EnumMap<>(DataType.class);
        Path outputDir = Paths.get(options.getOutputPath());

        try {
            if (!Files.exists(outputDir)) {
                Files.createDirectories(outputDir);
            }

            for (String inputFile : options.getInputFiles()) {
                processFile(inputFile, options, statistics, writers);
            }
        } catch (IOException e) {
            throw new ApplicationException("Error processing files: " + e.getMessage());
        } finally {
            closeWriters(writers);
        }
    }

    private void processFile(String inputFile, Options options, Statistics statistics,
                             Map<DataType, BufferedWriter> writers) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                DataType type = determineDataType(line);
                statistics.updateStatistics(type, line);
                try (BufferedWriter writer = writers.computeIfAbsent(type, t -> createWriter(t, options))) {
                    if (writer != null) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        }
    }

    private BufferedWriter createWriter(DataType type, Options options) {
        try {
            Path filePath = Paths.get(options.getOutputPath(), options.getFilePrefix() + type.getFileName());
            return Files.newBufferedWriter(filePath,
                    options.isAppendMode() ?
                            new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.APPEND} :
                            new StandardOpenOption[]{StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING});
        } catch (IOException e) {
            System.err.println("Warning: Could not create writer for " + type + ": " + e.getMessage());
            return null;
        }
    }

    DataType determineDataType(String line) {
        if (INTEGER_PATTERN.matcher(line).matches()) return DataType.INTEGER;
        if (FLOAT_PATTERN.matcher(line).matches()) return DataType.FLOAT;
        return DataType.STRING;
    }

    private void closeWriters(Map<DataType, BufferedWriter> writers) {
        writers.values().stream()
                .filter(Objects::nonNull)
                .forEach(writer -> {
                    try { writer.close(); }
                    catch (IOException e) { System.err.println("Warning: Error closing writer: " + e.getMessage()); }
                });
    }
}