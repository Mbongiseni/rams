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
import za.co.rams.dto.HomeOwnerDTO;
import za.co.rams.dto.RoleDTO;
import za.co.rams.service.AppUserService;
import za.co.rams.service.HomeOwnerService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/home-owner")
public class HomeOwnerController {

    private HomeOwnerService homeOwnerService;
    private static final String HOME_OWNER_LIST_PAGE = "home-owner/home-owner-list";
    private static final String HOME_OWNER_FORM_PAGE = "home-owner/home-owner-form";
    private static final String HOME_OWNER_LIST_REDIRECT = "redirect:/home-owner/list";
    private static final String HOME_OWNER_ATTRIBUTE = "homeOwner";


    public HomeOwnerController(HomeOwnerService homeOwnerService) {
        this.homeOwnerService = homeOwnerService;
    }

    @GetMapping("/list")
    public String showHomeOwnerList(Model theModel) {
        // Get Home Owners From Db
        List<HomeOwnerDTO> homeOwnerDTOList = homeOwnerService.retrieveAllHomeOwners();

        // Add App Users To Spring Model
        theModel.addAttribute("homeOwnerList", homeOwnerDTOList);
        return HOME_OWNER_LIST_PAGE;
    }

    @GetMapping("/home-owner-form")
    public String showHomeOwnerForm(Model theModel) {

        // Create model attribute to bind form data
        HomeOwnerDTO theHomeOwner = new HomeOwnerDTO();

        // Setup attributes
        theModel.addAttribute(HOME_OWNER_ATTRIBUTE, theHomeOwner);

        //theModel.addAttribute("roles", roleDTOList);
        return HOME_OWNER_FORM_PAGE;
    }//

    @PostMapping("/create")
    public String createHomeOwner(@ModelAttribute(HOME_OWNER_ATTRIBUTE) HomeOwnerDTO theHomeOwner) {
        log.info("Attempting to save: {}", theHomeOwner);

        // Save App User
        LocalDateTime now = LocalDateTime.now();
        Long homeOwnerId = theHomeOwner.getId();
        String firstName = theHomeOwner.getFirstName();
        String lastName = theHomeOwner.getLastName();
        String primaryPhoneNumber = theHomeOwner.getPrimaryPhoneNumber();
        String secondaryPhoneNumber = theHomeOwner.getSecondaryPhoneNumber();
        String emailAddress = theHomeOwner.getEmailAddress();
        LocalDateTime captured = theHomeOwner.getCaptured();
        LocalDateTime lastUpdated = theHomeOwner.getLastUpdated();

        HomeOwnerDTO homeOwner = homeOwnerService.createHomeOwner(homeOwnerId, firstName, lastName, primaryPhoneNumber, secondaryPhoneNumber, emailAddress, captured, lastUpdated);
        log.info("Successfully saved {}", homeOwner);

        /**
         * Use a redirect to prevent duplicate submission
         *
         * For More Details:
         * www.luv2code.com/post-redirect-get
         */
        return HOME_OWNER_LIST_REDIRECT;
    }

    @GetMapping("/update")
    public String showApplicationUserUpdateForm(@RequestParam("appUserId") Long theAppUserId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", theAppUserId, theModel);

        // Create model attribute to bind form data
        // AppUserDTO appUserDTO = homeOwnerService.findApplicationUserById(theAppUserId);

        // Set AppUser in the model to populate the form
        //theModel.addAttribute("appUser", appUserDTO) ;

        return HOME_OWNER_FORM_PAGE;
    }

    @GetMapping("/delete")
    public String showApplicationUserDeleteForm(@RequestParam("appUserId") Long theAppUserId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", theAppUserId, theModel);

        // Create model attribute to bind form data
        // homeOwnerService.deleteApplicationUserById(theAppUserId);

        return HOME_OWNER_LIST_REDIRECT;
    }
}
