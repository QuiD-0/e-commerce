package com.quid.commerce.delivery.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TrackingNumberTest {

    @Test
    void createTrackingNumber() {
        TrackingNumber trackingNumber = TrackingNumber.create();
        System.out.println(trackingNumber);
        assertEquals(trackingNumber.trackingNumber().length(), 15);
    }

}