package com.ncu.bookingservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ncu.bookingservice.Model.Booking;
import com.ncu.bookingservice.Payload.Request.BookRoomRequest;
import com.ncu.bookingservice.Payload.Request.PaymentRequest;
import com.ncu.bookingservice.Payload.Response.BookRoomResponse;
import com.ncu.bookingservice.Services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Value("${payment.url}")
    private String paymentUrl;

    @Autowired
    BookingService bookingService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

    @PostMapping(path = "/room")
    public ResponseEntity<?> bookRoom(@RequestBody BookRoomRequest bookRoomRequest) {
        BookRoomResponse bookingAfterSave = bookingService.bookRoom(bookRoomRequest);
        return new ResponseEntity<BookRoomResponse>(bookingAfterSave, HttpStatus.CREATED);
    }

    @PostMapping("/room/{bookingId}/transaction")
    public ResponseEntity<?> transactionBooking(@RequestBody PaymentRequest paymentRequest,
            @PathVariable int bookingId) {
        paymentRequest.setBookingId(bookingId);
        ResponseEntity<Integer> response = restTemplate.postForEntity(paymentUrl, paymentRequest, Integer.class);
        if (response.getStatusCode() == HttpStatus.CREATED) {
            Booking booking = bookingService.updateTransactionId(bookingId, response.getBody());
            return new ResponseEntity<Booking>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity("something went wrong", HttpStatus.BAD_GATEWAY);
        }
    }
}
