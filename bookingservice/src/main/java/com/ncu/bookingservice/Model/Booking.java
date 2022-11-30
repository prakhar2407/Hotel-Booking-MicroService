package com.ncu.bookingservice.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer bookingId;
    Date fromDate;
    Date toDate;
    String aadharNumber;
    Integer numOfRooms;
    String roomNumbers;
    @Column(nullable = false)
    Integer roomPrice;
    Integer transactionId = 0;
    Date bookedOn;

    public Booking(Date fromDate, Date toDate, String aadharNumber, Integer numOfRooms, String roomNumbers,
            Integer roomPrice, Date bookedOn) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;
        this.roomNumbers = roomNumbers;
        this.roomPrice = roomPrice;
        this.bookedOn = bookedOn;
    }

    public Booking(Date fromDate, Date toDate, String aadharNumber, Integer numOfRooms, String roomNumbers,
            Integer roomPrice, Integer transactionId, Date bookedOn) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.aadharNumber = aadharNumber;
        this.numOfRooms = numOfRooms;
        this.roomNumbers = roomNumbers;
        this.roomPrice = roomPrice;
        this.transactionId = transactionId;
        this.bookedOn = bookedOn;
    }
}
