package org.example.statistics;

import org.example.config.DataType;

public class StatisticsFactory {
    public static TypeStatistics create(DataType type) {
        return switch (type) {
            case INTEGER -> new IntegerStatistics(type);
            case FLOAT -> new FloatStatistics(type);
            case STRING -> new StringStatistics(type);
        };
    }
}