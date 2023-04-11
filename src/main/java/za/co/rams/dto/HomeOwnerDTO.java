package za.co.rams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeOwnerDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String firstName;
    private String lastName;
    private String primaryPhoneNumber;
    private String secondaryPhoneNumber;
    private String emailAddress;
    private LocalDateTime captured;
    private LocalDateTime lastUpdated;
}
