package za.co.rams.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String description;
    private LocalDateTime captured;
    private LocalDateTime lastUpdated;

    public RoleDTO(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
