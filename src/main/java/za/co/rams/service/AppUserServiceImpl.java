package za.co.rams.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import za.co.rams.dao.entity.AppUser;
import za.co.rams.dao.repo.AppUserRepo;
import za.co.rams.dto.AppUserDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AppUserServiceImpl implements AppUserService{

    private AppUserRepo appUserRepo;
    private ModelMapper mapper;

    public AppUserServiceImpl(AppUserRepo appUserRepo, ModelMapper mapper){
        this.appUserRepo = appUserRepo;
        this.mapper = mapper;
    }

    @Override
    public AppUserDTO updateApplicationUser(Long appUserId, String userName, String password, LocalDateTime lastUpdated) {
        AppUser appUser = appUserRepo.findAppUsersById(appUserId);
        if (appUser != null){
            appUser.setUserName(userName);
            appUser.setPassWord(password);
            appUser.setLastUpdated(LocalDateTime.now());
        }
        return mapper.map(appUserRepo.save(appUser), AppUserDTO.class);
    }

    @Override
    public AppUserDTO saveApplicationUser(Long appUserId, String userName, String passWord, LocalDateTime captured, LocalDateTime lastUpdated) {
        LocalDateTime now = LocalDateTime.now();
        AppUser appUser = null;
        if (appUserId != null) {
            log.info("Updating existing AppUser object....");
            appUser = appUserRepo.findAppUsersById(appUserId);
            appUser.setId(appUserId);
            appUser.setUserName(userName);
            appUser.setPassWord(passWord);
            appUser.setCaptured(captured);
            appUser.setLastUpdated(now);
            log.info("About to update appUser={}", appUser);
            //return mapper.map(appUser, AppUserDTO.class);
        }else {
            log.info("Creating new AppUser object....");
            appUser = new AppUser(userName, passWord, now, now);
            log.info("About to save appUser={}", appUser);
            //return mapper.map(appUser, AppUserDTO.class);
        }

        return mapper.map(appUserRepo.save(appUser), AppUserDTO.class);

    }

    @Override
    public List<AppUserDTO> retrieveApplicationUsers() {
        List<AppUserDTO> appUserDTOList = new ArrayList<>();
        appUserRepo.findAll().stream().forEach(appUser -> {appUserDTOList.add(mapper.map(appUser, AppUserDTO.class));});
        return appUserDTOList;
    }

    @Override
    public List<AppUserDTO> retrieveApplicationUserOrderByUserName() {
        List<AppUserDTO> appUserDTOList = new ArrayList<>();
        // TODO fix ordering
        appUserRepo.findAllByOrderByUserNameAsc().stream().forEach(appUser -> {appUserDTOList.add(mapper.map(appUser, AppUserDTO.class));});
        return appUserDTOList;
    }

    @Override
    public AppUserDTO findApplicationUserById(Long appUserId) {
        return mapper.map(appUserRepo.findAppUsersById(appUserId), AppUserDTO.class);
    }

    @Override
    public boolean deleteApplicationUserById(Long appUserId) {
        AppUser appUser = appUserRepo.findAppUsersById(appUserId);
        log.info("Attempting to delete AppUser {}", appUser);
        appUserRepo.delete(appUser);
        log.info("Successfully deleted AppUser = {}", appUser);
        return true;
    }
}
