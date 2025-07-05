package org.example.statistics;

import org.example.config.DataType;

public class IntegerStatistics extends TypeStatistics {
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;
    private long sum = 0;

    public IntegerStatistics(DataType type) { super(type); }

    @Override
    public void update(String value) {
        long num = Long.parseLong(value);
        min = Math.min(min, num);
        max = Math.max(max, num);
        sum += num;
        count++;
    }

    @Override
    protected void printFullStatistics() {
        System.out.printf("  Min = %d%n", min);
        System.out.printf("  Max = %d%n", max);
        System.out.printf("  Sum = %d%n", sum);
        System.out.printf("  Avg = %.2f%n", count > 0 ? (double) sum / count : 0);
    }
}