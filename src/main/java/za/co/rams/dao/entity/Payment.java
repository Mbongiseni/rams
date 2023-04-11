package za.co.rams.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_payed")
    private LocalDateTime payedDate;

    @Column(name = "amount_payed")
    private String amount;

    @Column(name = "captured")
    private LocalDateTime captured;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    public Payment(LocalDateTime payedDate, String amount, LocalDateTime captured, LocalDateTime lastUpdated) {
        this.payedDate = payedDate;
        this.amount = amount;
        this.captured = captured;
        this.lastUpdated = lastUpdated;
    }
}
