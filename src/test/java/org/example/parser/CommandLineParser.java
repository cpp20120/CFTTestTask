package org.example.parser;

import org.example.config.Options;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineParserTest {

    private final CommandLineParser parser = new CommandLineParser();
    private final Options options = new Options();

    @Test
    void parse_setsOutputPath() throws Exception {
        parser.parse(new String[]{"-o", "output", "file.txt"}, options);
        assertEquals("output", options.getOutputPath());
    }

    @Test
    void parse_setsFilePrefix() throws Exception {
        parser.parse(new String[]{"-p", "pre_", "file.txt"}, options);
        assertEquals("pre_", options.getFilePrefix());
    }

    @Test
    void parse_throwsOnMissingOptionValue() {
        assertThrows(Exception.class, () -> parser.parse(new String[]{"-o"}, options));
    }
}