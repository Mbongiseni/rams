package za.co.rams.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.rams.dao.entity.HomeOwner;
import za.co.rams.dao.repo.HomeOwnerRepo;
import za.co.rams.dto.HomeOwnerDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class HomeOwnerServiceImpl implements HomeOwnerService{
    private final HomeOwnerRepo homeOwnerRepo;
    private final ModelMapper mapper;

    @Autowired
    public HomeOwnerServiceImpl(HomeOwnerRepo homeOwnerRepo, ModelMapper mapper){
        this.homeOwnerRepo = homeOwnerRepo;
        this.mapper = mapper;
    }

    @Override
    public HomeOwnerDTO updateHomeOwner(Long homeOwnerId, String firstName, String lastName, String primaryPhoneNumber, String secondaryPhoneNumber, String emailAddress, LocalDateTime lastUpdated) {
        HomeOwner homeOwner = homeOwnerRepo.findHomeOwnerById(homeOwnerId);
        if (homeOwner != null){
            homeOwner.setFirstName(firstName);
            homeOwner.setLastName(lastName);
            homeOwner.setPrimaryPhoneNumber(primaryPhoneNumber);
            homeOwner.setSecondaryPhoneNumber(secondaryPhoneNumber);
            homeOwner.setEmailAddress(emailAddress);
            homeOwner.setLastUpdated(LocalDateTime.now());
        }
        return mapper.map(homeOwnerRepo.save(homeOwner), HomeOwnerDTO.class);
    }

    @Override
    public HomeOwnerDTO createHomeOwner(Long homeOwnerId, String firstName, String lastName, String primaryPhoneNumber, String secondaryPhoneNumber, String emailAddress, LocalDateTime captured, LocalDateTime lastUpdated) {
        LocalDateTime now = LocalDateTime.now();
        HomeOwner homeOwner = null;
        if (homeOwnerId != null) {
            log.info("Updating existing HomeOwner object....");
            homeOwner = homeOwnerRepo.findHomeOwnerById(homeOwnerId);
            homeOwner.setFirstName(firstName);
            homeOwner.setLastName(lastName);
            homeOwner.setPrimaryPhoneNumber(primaryPhoneNumber);
            homeOwner.setSecondaryPhoneNumber(secondaryPhoneNumber);
            homeOwner.setEmailAddress(emailAddress);
            homeOwner.setLastUpdated(LocalDateTime.now());
            log.info("About to update homeOwner={}", homeOwner);
        }else {
            log.info("Creating new HomeOwner object....");
            homeOwner = new HomeOwner(firstName, lastName, primaryPhoneNumber, secondaryPhoneNumber, emailAddress, now, now);
            log.info("About to save homeOwner={}", homeOwner);
        }

        return mapper.map(homeOwnerRepo.save(homeOwner), HomeOwnerDTO.class);
    }

    @Override
    public List<HomeOwnerDTO> retrieveAllHomeOwners() {
        List<HomeOwnerDTO> homeOwnerDTOList = new ArrayList<>();
        homeOwnerRepo.findAll().stream().forEach(homeOwner -> {homeOwnerDTOList.add(mapper.map(homeOwner, HomeOwnerDTO.class));
        });
        return homeOwnerDTOList;
    }

    @Override
    public HomeOwnerDTO retrieveHomeOwnerById(Long homeOwnerId) {
        return mapper.map(homeOwnerRepo.findHomeOwnerById(homeOwnerId), HomeOwnerDTO.class);
    }

    @Override
    public boolean deleteHomeOwnerById(Long homeOwnerId) {
        HomeOwner homeOwner = homeOwnerRepo.findHomeOwnerById(homeOwnerId);
        homeOwnerRepo.delete(homeOwner);
        return true;
    }
}
