package org.example.statistics;

import org.example.config.DataType;

public class StringStatistics extends TypeStatistics {
    private int minLength = Integer.MAX_VALUE;
    private int maxLength = Integer.MIN_VALUE;

    public StringStatistics(DataType type) { super(type); }

    @Override
    public void update(String value) {
        int length = value.length();
        minLength = Math.min(minLength, length);
        maxLength = Math.max(maxLength, length);
        count++;
    }

    @Override
    protected void printFullStatistics() {
        System.out.printf("  Shortest length = %d%n", minLength);
        System.out.printf("  Longest length = %d%n", maxLength);
    }
}