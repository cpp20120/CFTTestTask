package org.example.statistics;

import org.example.config.DataType;

public abstract class TypeStatistics {
    protected final DataType type;
    protected int count = 0;

    public TypeStatistics(DataType type) {
        this.type = type;
    }

    public abstract void update(String value);

    public void print(boolean fullStatistics) {
        System.out.printf("%s: Count = %d%n", type, count);
        if (fullStatistics) printFullStatistics();
    }

    protected abstract void printFullStatistics();

    public int getCount() {
        return count;
    }
}