package za.co.rams.service;

import za.co.rams.dto.AppUserDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface AppUserService {
    AppUserDTO updateApplicationUser(Long appUserId, String userName, String password, LocalDateTime lastUpdated);
    AppUserDTO saveApplicationUser(Long appUserId,  String userName, String Password, LocalDateTime captured, LocalDateTime lastUpdated);
    List<AppUserDTO> retrieveApplicationUsers();
    List<AppUserDTO> retrieveApplicationUserOrderByUserName();
    AppUserDTO findApplicationUserById(Long appUserId);
    boolean deleteApplicationUserById(Long appUserId);
}
