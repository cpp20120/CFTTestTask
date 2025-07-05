package org.example.processor;

import org.example.config.DataType;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ContentProcessorTest {

    private final ContentProcessor processor = new ContentProcessor();

    @Test
    void determineDataType_identifiesIntegers() {
        assertEquals(DataType.INTEGER, processor.determineDataType("123"));
    }

    @Test
    void determineDataType_identifiesFloats() {
        assertEquals(DataType.FLOAT, processor.determineDataType("123.45"));
    }

    @Test
    void determineDataType_identifiesStrings() {
        assertEquals(DataType.STRING, processor.determineDataType("abc"));
    }
}