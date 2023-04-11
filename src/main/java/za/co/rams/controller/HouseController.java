package za.co.rams.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.rams.dao.entity.House;
import za.co.rams.dto.HouseDTO;
import za.co.rams.service.HouseService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/house")
public class HouseController {

    private HouseService houseService;
    private static final String HOUSE_LIST_PAGE = "house/house-list";
    private static final String HOUSE_FORM_PAGE = "house/house-form";
    private static final String HOUSE_LIST_REDIRECT = "redirect:/house/list";
    private static final String HOUSE_ATTRIBUTE = "house";
    private static final String HOUSE_LIST_ATTRIBUTE = "houseList";


    @Autowired
    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/list")
    public String showHouseList(Model theModel) {
        // Get Home Owners From Db
        List<HouseDTO> homeOwnerDTOList = houseService.retrieveAllHouseList();

        // Add App Users To Spring Model
        theModel.addAttribute(HOUSE_LIST_ATTRIBUTE, homeOwnerDTOList);
        return HOUSE_LIST_PAGE;
    }

    @GetMapping("/house-form")
    public String showHouseForm(Model theModel) {

        // Create model attribute to bind form data
        House theHouse = new House();

        // Setup attributes
        theModel.addAttribute(HOUSE_ATTRIBUTE, theHouse);

        return HOUSE_FORM_PAGE;
    }

    @PostMapping("/create")
    public String createHouse(@ModelAttribute(HOUSE_ATTRIBUTE) HouseDTO theHouse) {
        log.info("Attempting to save: {}", theHouse);

        // Save App User
        LocalDateTime now = LocalDateTime.now();
        Long houseId = theHouse.getId();
        String streetName = theHouse.getStreetName();
        String houseNumber = theHouse.getHouseNumber();
        String location = theHouse.getLocation();
        String town = theHouse.getTown();
        LocalDateTime captured = theHouse.getCaptured();
        LocalDateTime lastUpdated = theHouse.getLastUpdated();

        HouseDTO house = houseService.createHouse(houseId, streetName, houseNumber, location, town, captured, lastUpdated);
        log.info("Successfully saved {}", house);

        /**
         * Use a redirect to prevent duplicate submission
         *
         * For More Details:
         * www.luv2code.com/post-redirect-get
         */
        return HOUSE_LIST_REDIRECT;
    }

    @GetMapping("/update")
    public String showHouseUpdateForm(@RequestParam("houseId") Long theHouseId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", theHouseId, theModel);

        // Create model attribute to bind form data
        HouseDTO house = houseService.findHouseById(theHouseId);

        // Set AppUser in the model to populate the form
        theModel.addAttribute(HOUSE_ATTRIBUTE, house) ;

        return HOUSE_FORM_PAGE;
    }

    @GetMapping("/delete")
    public String showApplicationUserDeleteForm(@RequestParam("houseId") Long theHouseId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", theHouseId, theModel);

        // Create model attribute to bind form data
        houseService.deleteHouseById(theHouseId);

        return HOUSE_LIST_REDIRECT;
    }
}
