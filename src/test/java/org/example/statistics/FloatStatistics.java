package org.example.statistics;

import org.example.config.DataType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloatStatisticsTest {

    @Test
    void update_tracksStatistics() {
        FloatStatistics stats = new FloatStatistics(DataType.FLOAT);
        stats.update("10.5");
        stats.update("20.25");
        stats.update("-5.1");

        assertEquals(3, stats.getCount());
    }

    @Test
    void printFullStatistics_showsCalculations() {
        FloatStatistics stats = new FloatStatistics(DataType.FLOAT);
        stats.update("10.5");
        stats.update("20.25");

        assertDoesNotThrow(() -> stats.print(true));
    }
}