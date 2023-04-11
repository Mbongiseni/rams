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
import za.co.rams.dao.entity.Payment;
import za.co.rams.dto.PaymentDTO;
import za.co.rams.service.PaymentService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;
    private static final String PAYMENT_LIST_PAGE = "payment/payment-list";
    private static final String PAYMENT_FORM_PAGE = "payment/payment-form";
    private static final String PAYMENT_LIST_REDIRECT = "redirect:/payment/list";
    private static final String PAYMENT_ATTRIBUTE = "payment";
    private static final String PAYMENT_LIST_ATTRIBUTE = "paymentList";
    private static final String PAYMENT_ID = "paymentId";


    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/list")
    public String showPaymentList(Model theModel) {
        // Get Home Owners From Db
        List<PaymentDTO> paymentDTOList = paymentService.retrieveAllPayments();

        // Add App Users To Spring Model
        theModel.addAttribute(PAYMENT_LIST_ATTRIBUTE, paymentDTOList);
        return PAYMENT_LIST_PAGE;
    }

    @GetMapping("/payment-form")
    public String showPaymentForm(Model theModel) {

        // Create model attribute to bind form data
        Payment payment = new Payment();

        // Setup attributes
        theModel.addAttribute(PAYMENT_ATTRIBUTE, payment);

        return PAYMENT_FORM_PAGE;
    }

    @PostMapping("/create")
    public String createPayment(@ModelAttribute(PAYMENT_ATTRIBUTE) PaymentDTO thePayment) {
        log.info("Attempting to save: {}", thePayment);

        // Save App User
        LocalDateTime now = LocalDateTime.now();
        Long paymentId = thePayment.getId();
        LocalDateTime payedDate = thePayment.getPayedDate();
        String amount = thePayment.getAmount();
        LocalDateTime captured = thePayment.getCaptured();
        LocalDateTime lastUpdated = thePayment.getLastUpdated();

        PaymentDTO payment = paymentService.createPayment(paymentId, payedDate, amount, captured, lastUpdated);
        log.info("Successfully saved {}", payment);

        /**
         * Use a redirect to prevent duplicate submission
         *
         * For More Details:
         * www.luv2code.com/post-redirect-get
         */
        return PAYMENT_LIST_REDIRECT;
    }

    @GetMapping("/update")
    public String showPaymentUpdateForm(@RequestParam(PAYMENT_ID) Long thePaymentId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", thePaymentId, theModel);

        // Create model attribute to bind form data
        PaymentDTO payment = paymentService.retrievePaymentById(thePaymentId);

        // Set AppUser in the model to populate the form
        theModel.addAttribute(PAYMENT_ATTRIBUTE, payment) ;

        return PAYMENT_FORM_PAGE;
    }

    @GetMapping("/delete")
    public String showPaymentDeleteForm(@RequestParam(PAYMENT_ID) Long thePaymentId, Model theModel) {
        log.info("Attempting to update appUserId = {} with Model = {}", thePaymentId, theModel);

        // Create model attribute to bind form data
        paymentService.deletePaymentById(thePaymentId);

        return PAYMENT_LIST_REDIRECT;
    }
}
