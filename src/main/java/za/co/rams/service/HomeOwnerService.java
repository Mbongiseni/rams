package za.co.rams.service;

import za.co.rams.dto.HomeOwnerDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface HomeOwnerService {
    HomeOwnerDTO updateHomeOwner(Long homeOwnerId, String firstName, String lastName, String primaryPhoneNumber, String secondaryPhoneNumber, String emailAddress, LocalDateTime lastUpdated);
    HomeOwnerDTO createHomeOwner(Long homeOwnerId, String firstName, String lastName, String primaryPhoneNumber, String secondaryPhoneNumber, String emailAddress, LocalDateTime captured, LocalDateTime lastUpdated);
    List<HomeOwnerDTO> retrieveAllHomeOwners();
    HomeOwnerDTO retrieveHomeOwnerById(Long homeOwnerId);
    boolean deleteHomeOwnerById(Long homeOwnerId);
}
