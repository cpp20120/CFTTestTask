package org.example.statistics;

import org.example.config.DataType;

public class FloatStatistics extends TypeStatistics {
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private double sum = 0;

    public FloatStatistics(DataType type) { super(type); }

    @Override
    public void update(String value) {
        double num = Double.parseDouble(value);
        min = Math.min(min, num);
        max = Math.max(max, num);
        sum += num;
        count++;
    }

    @Override
    protected void printFullStatistics() {
        System.out.printf("  Min = %f%n", min);
        System.out.printf("  Max = %f%n", max);
        System.out.printf("  Sum = %f%n", sum);
        System.out.printf("  Avg = %f%n", count > 0 ? sum / count : 0);
    }
}