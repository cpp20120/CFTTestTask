package org.example;

import org.example.application.Application;
import org.example.application.ApplicationException;
import org.example.config.Options;
import org.example.processor.ContentProcessor;
import org.example.statistics.Statistics;

public class Main {
    public static void main(String[] args) {
        try {
            Application app = new Application(new Options(), new Statistics(), new ContentProcessor());
            app.run(args);
        } catch (ApplicationException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            System.exit(2);
        }
    }
}