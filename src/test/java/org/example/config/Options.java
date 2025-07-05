package org.example.config;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class OptionsTest {

    @Test
    void options_storeAndRetrieveValues() {
        Options options = new Options();
        options.setOutputPath("out");
        options.setFilePrefix("pre_");
        options.setAppendMode(true);
        options.setFullStatistics(true);
        options.addInputFile("file.txt");

        assertEquals("out", options.getOutputPath());
        assertEquals("pre_", options.getFilePrefix());
        assertTrue(options.isAppendMode());
        assertTrue(options.isFullStatistics());
        assertEquals(Collections.singletonList("file.txt"), options.getInputFiles());
    }
}