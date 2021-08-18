package org.db117.lexicon.impl;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordInputScanTest {

    @BeforeEach
    void setUp() {
    }


    @SneakyThrows
    @Test
    void scan() {
        WordInputScan scan = new WordInputScan();

        scan.scan();
    }
}