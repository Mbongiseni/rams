package za.co.rams.service;

import za.co.rams.dto.PaymentDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface PaymentService {
    PaymentDTO updatePayment(Long paymentId, LocalDateTime datePayed, String amountPayed, LocalDateTime lastUpdated);
    PaymentDTO createPayment(Long paymentId, LocalDateTime datePayed, String amountPayed, LocalDateTime captured, LocalDateTime lastUpdated);
    List<PaymentDTO> retrieveAllPayments();
    PaymentDTO retrievePaymentById(Long paymentId);
    boolean deletePaymentById(Long paymentId);
}
