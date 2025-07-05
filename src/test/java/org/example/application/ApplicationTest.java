package org.example.application;

import org.example.config.Options;
import org.example.processor.ContentProcessor;
import org.example.statistics.Statistics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest {
    @Test
    void testValidateInputFilesThrowsIfEmpty() {
        Options options = Mockito.mock(Options.class);
        Mockito.when(options.getInputFiles()).thenReturn(List.of());

        Application app = new Application(options, new Statistics(), new ContentProcessor());
        assertThrows(ApplicationException.class, () -> app.run(new String[0]));
    }
}