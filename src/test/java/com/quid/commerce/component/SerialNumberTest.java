package com.quid.commerce.component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class SerialNumberTest {

    @Test
    void generate() {
        String serialNumber = SerialNumber.generate();
        assertNotNull(serialNumber);
        assertEquals(15, serialNumber.length());
    }

}