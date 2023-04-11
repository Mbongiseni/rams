package za.co.rams.service;

import za.co.rams.dto.HouseDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface HouseService {
    HouseDTO updateHouse(Long houseId, String streetNme, String houseNumber, String location, String town, LocalDateTime lastUpdated);
    HouseDTO createHouse(Long houseId, String streetName, String houseNumber, String location, String town, LocalDateTime capture, LocalDateTime lastUpdated);
    List<HouseDTO> retrieveAllHouseList();
    HouseDTO findHouseById(Long houseId);
    boolean deleteHouseById(Long houseId);
}
