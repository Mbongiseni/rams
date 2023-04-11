package za.co.rams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private LocalDateTime payedDate;
    private String amount;
    private LocalDateTime captured;
    private LocalDateTime lastUpdated;

}
