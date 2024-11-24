package com.team5.bms.controller;
 
import jakarta.validation.Valid;
import com.team5.bms.model.Card;
import com.team5.bms.model.User;
import org.springframework.ui.Model;
import com.team5.bms.model.Building;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("building", new Building());
        model.addAttribute("card", new Card());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
        @Valid @ModelAttribute("user") User user, 
        @Valid @ModelAttribute("building") Building building, 
        @Valid @ModelAttribute("card") Card card, 
        BindingResult result, 
        Model model) {
        
        if (result.hasErrors()) {
            return "register"; // returns the form view if there are validation errors
        }

        // Save Building Details
        System.out.println("UserController - POST - register - building -> " + building);

        // Save Card Details
        System.out.println("UserController - POST - register - card -> " + card);

        // Save Building Owner User details with its Building and Card
        System.out.println("UserController - POST - register - Building Owner - user -> " + user);

        // Set the user’s building and card
        // user.setBuilding(building);
        // card.setUser(user);

        // Save the user and card (and building if necessary)
        // userService.save(user); // Assuming you have a service to save the entities
        // userService.saveCard(card);

        model.addAttribute("message", "Registration successful!");
        return "redirect:/login"; // redirect to login page after successful registration
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}