package com.example.bookingapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @GetMapping("/")
    public String GetHome() {
        return "home";
    }

    @GetMapping("/login")
    public String GetLogin() {
        return "login";
    }

    @GetMapping("/signin")
    public String GetSignin() {
        return "signin";
    }

    @GetMapping("/{username}/bookticket")
    public String GetBookingForm() {return "bookingform"; }

    @GetMapping("/{username}/bookedtickets")
    public String GetTickets(@PathVariable(value = "username") String username, Model model) {
        model.addAttribute("tickets", BookedTickets.getTicketsBookedByUser(username));
        return "tickets";
    }
}
