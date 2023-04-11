package za.co.rams.service;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rams.dao.entity.House;
import za.co.rams.dao.repo.HouseRepo;
import za.co.rams.dto.HouseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepo houseRepo;
    private final ModelMapper mapper;

    @Autowired
    public HouseServiceImpl(HouseRepo houseRepo, ModelMapper mapper) {
        this.houseRepo = houseRepo;
        this.mapper = mapper;
    }

    @Override
    public HouseDTO updateHouse(Long houseId, String streetName, String houseNumber, String location, String town, LocalDateTime lastUpdated) {
        House house = houseRepo.findHouseById(houseId);
        if (house != null) {
            house.setStreetName(streetName);
            house.setHouseNumber(houseNumber);
            house.setLocation(location);
            house.setTown(town);
            house.setLastUpdated(LocalDateTime.now());
        }
        return mapper.map(houseRepo.save(house), HouseDTO.class);
    }

    @Override
    public HouseDTO createHouse(Long houseId, String streetName, String houseNumber, String location, String town, LocalDateTime captured, LocalDateTime lastUpdated) {
        LocalDateTime now = LocalDateTime.now();
        House house = null;
        if (houseId != null) {
            log.info("Updating existing HomeOwner object....");
            house = houseRepo.findHouseById(houseId);
            house.setStreetName(streetName);
            house.setHouseNumber(houseNumber);
            house.setLocation(location);
            house.setTown(town);
            house.setLastUpdated(LocalDateTime.now());
            log.info("About to update house={}", house);
        } else {
            log.info("Creating new HomeOwner object....");
            house = new House(streetName, houseNumber, location, town, now, now);
            log.info("About to save house={}", house);
        }

        return mapper.map(houseRepo.save(house), HouseDTO.class);
    }

    @Override
    public List<HouseDTO> retrieveAllHouseList() {
        List<HouseDTO> houseDTOList = new ArrayList<>();
        houseRepo.findAll().stream().forEach(house -> {
            houseDTOList.add(mapper.map(house, HouseDTO.class));
        });
        return houseDTOList;
    }

    @Override
    public HouseDTO findHouseById(Long houseId) {
        return mapper.map(houseRepo.findHouseById(houseId), HouseDTO.class);
    }

    @Override
    public boolean deleteHouseById(Long houseId) {
        House houseById = houseRepo.findHouseById(houseId);
        houseRepo.delete(houseById);
        return true;
    }
}
