package za.co.rams.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.rams.dao.entity.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {
    Payment findPaymentById(Long paymentId);
}
