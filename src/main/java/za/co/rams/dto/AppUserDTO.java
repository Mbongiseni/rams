package za.co.rams.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class AppUserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long appUserId;
    private String userName;
    private String passWord;
    private LocalDateTime captured;
    private LocalDateTime lastUpdated;
    private List<RoleDTO> roles;
}
