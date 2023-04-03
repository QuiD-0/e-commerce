package com.quid.commerce.delivery.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrackingNumber {

    @Column(name = "tracking_number")
    private String trackingNumber;

    private TrackingNumber(String trackingNumber){
        this.trackingNumber = trackingNumber;
    }

    public static TrackingNumber create() {
        return new TrackingNumber(generate());
    }

    private static String generate() {
        LocalDate now = LocalDate.now();
        String date = now.toString().replace("-", "");
        return String.format("%s%07d", date, (int) (Math.random() * 10000000));
    }

    public String trackingNumber() {
        return trackingNumber;
    }

}
