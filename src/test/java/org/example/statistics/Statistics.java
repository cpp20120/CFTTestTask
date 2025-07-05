package org.example.statistics;

import org.example.config.DataType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void updateStatistics_createsAppropriateStats() {
        Statistics stats = new Statistics();
        stats.updateStatistics(DataType.INTEGER, "123");
        stats.updateStatistics(DataType.FLOAT, "123.45");
        stats.updateStatistics(DataType.STRING, "abc");

        assertEquals(1, stats.getCount(DataType.INTEGER));
        assertEquals(1, stats.getCount(DataType.FLOAT));
        assertEquals(1, stats.getCount(DataType.STRING));
    }

    @Test
    void print_handlesEmptyStatistics() {
        Statistics stats = new Statistics();
        assertDoesNotThrow(() -> stats.print(false));
    }
}