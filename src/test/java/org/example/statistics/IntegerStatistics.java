package org.example.statistics;

import org.example.config.DataType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerStatisticsTest {

    @Test
    void update_tracksStatistics() {
        IntegerStatistics stats = new IntegerStatistics(DataType.INTEGER);
        stats.update("10");
        stats.update("20");
        stats.update("-5");

        assertEquals(3, stats.getCount());
    }

    @Test
    void printFullStatistics_showsCalculations() {
        IntegerStatistics stats = new IntegerStatistics(DataType.INTEGER);
        stats.update("10");
        stats.update("20");

        assertDoesNotThrow(() -> stats.print(true));
    }
}