package za.co.rams.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rams.dao.entity.Payment;
import za.co.rams.dao.repo.PaymentRepo;
import za.co.rams.dto.PaymentDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepo paymentRepo;
    private final ModelMapper mapper;

    @Autowired
    public PaymentServiceImpl(PaymentRepo paymentRepo, ModelMapper mapper){
        this.paymentRepo = paymentRepo;
        this.mapper = mapper;
    }

    @Override
    public PaymentDTO updatePayment(Long paymentId, LocalDateTime datePayed, String amountPayed, LocalDateTime lastUpdated) {
        Payment payment = paymentRepo.findPaymentById(paymentId);
        if (payment != null) {
            payment.setPayedDate(datePayed);
            payment.setAmount(amountPayed);
            payment.setLastUpdated(LocalDateTime.now());
        }
        return mapper.map(paymentRepo.save(payment), PaymentDTO.class);
    }

    @Override
    public PaymentDTO createPayment(Long paymentId, LocalDateTime datePayed, String amountPayed, LocalDateTime captured, LocalDateTime lastUpdated) {
        LocalDateTime now = LocalDateTime.now();
        Payment payment = null;
        if (paymentId != null) {
            log.info("Updating existing HomeOwner object....");
            payment = paymentRepo.findPaymentById(paymentId);
            payment.setPayedDate(datePayed);
            payment.setAmount(amountPayed);
            payment.setLastUpdated(LocalDateTime.now());
            log.info("About to update payment={}", payment);
        } else {
            log.info("Creating new HomeOwner object....");
            payment = new Payment(datePayed, amountPayed, now, now);
            log.info("About to save payment={}", payment);
        }

        return mapper.map(paymentRepo.save(payment), PaymentDTO.class);
    }

    @Override
    public List<PaymentDTO> retrieveAllPayments() {
        List<PaymentDTO> paymentDTOList = new ArrayList<>();
        paymentRepo.findAll().stream().forEach(payment -> {
            paymentDTOList.add(mapper.map(payment, PaymentDTO.class));
        });
        return paymentDTOList;
    }

    @Override
    public PaymentDTO retrievePaymentById(Long paymentId) {
        return mapper.map(paymentRepo.findPaymentById(paymentId), PaymentDTO.class);
    }

    @Override
    public boolean deletePaymentById(Long paymentId) {
        Payment payment = paymentRepo.findPaymentById(paymentId);
        paymentRepo.delete(payment);
        return true;
    }
}
