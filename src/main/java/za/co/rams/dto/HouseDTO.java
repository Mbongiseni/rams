package za.co.rams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String streetName;
    private String houseNumber;
    private String location;
    private String town;
    private LocalDateTime captured;
    private LocalDateTime lastUpdated;

}
