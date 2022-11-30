package com.ncu.bookingservice.Services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncu.bookingservice.Model.Booking;
import com.ncu.bookingservice.Payload.Request.BookRoomRequest;
import com.ncu.bookingservice.Payload.Response.BookRoomResponse;
import com.ncu.bookingservice.Repositories.BookingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public BookRoomResponse bookRoom(BookRoomRequest bookRoomRequest) {
        String roomNumbers = generateRoomNumbers(bookRoomRequest.getNumberOfRooms());
        Integer priceOfAllRooms = calculateRoomsPrice(bookRoomRequest.getNumberOfRooms(), bookRoomRequest.getFromDate(),
                bookRoomRequest.getToDate());
        Date currentDate = getCurrentDate();
        Booking booking = new Booking(bookRoomRequest.getFromDate(), bookRoomRequest.getToDate(),
                bookRoomRequest.getAadharNumber(), bookRoomRequest.getNumberOfRooms(), roomNumbers, priceOfAllRooms,
                currentDate);
        bookingRepository.save(booking);
        return new BookRoomResponse(roomNumbers, priceOfAllRooms);
    }

    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public Integer calculateRoomsPrice(Integer numberOfRooms, Date fromDate, Date toDate) {
        long diff = fromDate.getTime() - toDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);
        long roomPrice = 1000 * numberOfRooms * (diffDays);
        return (int) roomPrice;
    }

    public String generateRoomNumbers(Integer numberOfRooms) {
        HashSet<Integer> roomNumbersSet = new HashSet<>();
        Random randomNumber = new Random();
        while (roomNumbersSet.size() < numberOfRooms) {
            int rand = 0;
            while (true) {
                rand = randomNumber.nextInt(500);
                if (rand != 0)
                    break;
            }
            roomNumbersSet.add(rand);
        }
        String rooms = "";
        for (Integer hashSetNum : roomNumbersSet) {
            rooms += hashSetNum;
        }
        return rooms;
    }

    public Booking updateTransactionId(int bookingId, int transactionId) {
        Booking bookingInfoEntity = bookingRepository.findById(bookingId).get();
        bookingInfoEntity.setTransactionId(transactionId);
        return bookingRepository.save(bookingInfoEntity);
    }
}
