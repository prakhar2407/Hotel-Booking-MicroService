package com.ncu.paymentservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncu.paymentservice.Model.Payment;
import com.ncu.paymentservice.Payload.PaymentDTO;
import com.ncu.paymentservice.Services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<?> pay(@RequestBody PaymentDTO paymentDTO) {
        Payment paymentAfterSave = paymentService.addPayment(paymentDTO);
        return new ResponseEntity<Integer>(paymentAfterSave.getTransactionId(), HttpStatus.CREATED);
    }
}
