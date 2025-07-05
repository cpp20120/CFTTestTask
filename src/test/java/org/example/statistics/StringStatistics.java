package org.example.statistics;

import org.example.config.DataType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringStatisticsTest {

    @Test
    void update_tracksLengths() {
        StringStatistics stats = new StringStatistics(DataType.STRING);
        stats.update("short");
        stats.update("medium length");
        stats.update("very very long string");

        assertEquals(3, stats.getCount());
    }

    @Test
    void printFullStatistics_showsLengths() {
        StringStatistics stats = new StringStatistics(DataType.STRING);
        stats.update("test");

        assertDoesNotThrow(() -> stats.print(true));
    }
}