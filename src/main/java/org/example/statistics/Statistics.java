package org.example.statistics;

import org.example.config.DataType;
import java.util.EnumMap;
import java.util.Map;

public class Statistics {
    private final Map<DataType, TypeStatistics> stats = new EnumMap<>(DataType.class);

    public void updateStatistics(DataType type, String value) {
        stats.computeIfAbsent(type, this::createStatistics).update(value);
    }

    private TypeStatistics createStatistics(DataType type) {
        return StatisticsFactory.create(type);
    }

    public void print(boolean fullStatistics) {
        System.out.println("Statistics:");
        stats.values().forEach(s -> s.print(fullStatistics));
    }

    public int getCount(DataType type) {
        return stats.containsKey(type) ? stats.get(type).getCount() : 0;
    }
}