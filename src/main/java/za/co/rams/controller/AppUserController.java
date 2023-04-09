package za.co.rams.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.rams.dto.AppUserDTO;
import za.co.rams.dto.RoleDTO;
import za.co.rams.service.AppUserService;
import za.co.rams.service.RoleService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/app-user")
public class AppUserController {


    private AppUserService appUserService;
    private RoleService roleService;
    private static final String APP_USER_LIST_PAGE = "app-user/app-user-list";
    private static final String APP_USER_FORM_PAGE = "app-user/app-user-form";
    private static final String APP_USER_LIST_REDIRECT = "redirect:/app-user/list";

    public AppUserController(AppUserService appUserService, RoleService roleService){
        this.appUserService = appUserService;
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public String showApplicationUserList(Model theModel){
        // Get App Users From Db
        List<AppUserDTO> appUserDTOList = appUserService.retrieveApplicationUsers();

        // Add App Users To Spring Model
        theModel.addAttribute("appUserList", appUserDTOList);
        return APP_USER_LIST_PAGE;
    }

    @GetMapping("/app-user-form")
    public String showApplicationUserForm(Model theModel){

        // Create model attribute to bind form data
        AppUserDTO theAppUser = new AppUserDTO();

        // Retrieve Application Roles
        List<RoleDTO> roleDTOList = Arrays.asList(new RoleDTO(1L, "Admin","Admin"), new RoleDTO(2L, "Resident","Resident"));

        theAppUser.setRoles(roleDTOList);
        // Setup attributes
        theModel.addAttribute("appUser", theAppUser);
        //theModel.addAttribute("roles", roleDTOList);
        return APP_USER_FORM_PAGE;
    }//

    @PostMapping("/save")
    public String saveApplicationUser(@ModelAttribute("appUser") AppUserDTO theAppUser){
        log.info("Attempting to save: {}", theAppUser);

        // Save App User
        LocalDateTime now = LocalDateTime.now();
        Long appUserId = theAppUser.getAppUserId();
        String userName = theAppUser.getUserName();
        String passWord = theAppUser.getPassWord();
        LocalDateTime captured = theAppUser.getCaptured();

        AppUserDTO appUserDTO = appUserService.saveApplicationUser(appUserId, userName, passWord, captured, now);
        log.info("Successfully saved {}", appUserDTO);

        /**
         * Use a redirect to prevent duplicate submission
         *
         * For More Details:
         * www.luv2code.com/post-redirect-get
         */
        return APP_USER_LIST_REDIRECT;
    }

    @GetMapping("/update")
    public String showApplicationUserUpdateForm(@RequestParam("appUserId") Long theAppUserId, Model theModel){
        log.info("Attempting to update appUserId = {} with Model = {}", theAppUserId, theModel);

        // Create model attribute to bind form data
        AppUserDTO appUserDTO = appUserService.findApplicationUserById(theAppUserId);

        // Set AppUser in the model to populate the form
        theModel.addAttribute("appUser", appUserDTO) ;

        return APP_USER_FORM_PAGE;
    }

    @GetMapping("/delete")
    public String showApplicationUserDeleteForm(@RequestParam("appUserId") Long theAppUserId, Model theModel){
        log.info("Attempting to update appUserId = {} with Model = {}", theAppUserId, theModel);

        // Create model attribute to bind form data
       appUserService.deleteApplicationUserById(theAppUserId);

        return APP_USER_LIST_REDIRECT;
    }
}
