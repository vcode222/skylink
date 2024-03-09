package com.example.bookingapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class SignInController {
    @PostMapping("/signin")
    public String AddUser(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = mapper.readValue(body, Map.class);

        User newUser = new User(map.get("name"), map.get("username"), map.get("email"), map.get("phoneno"), map.get("nation"), map.get("password"));
        String response = User.addUser(newUser);

        return response;
    }

    @PostMapping("/login")
    public String Login(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = mapper.readValue(body, Map.class);

        String response = User.validatePassword(map.get("username"), map.get("password"));
        return response;
    }

    @PostMapping("/{username}/bookticket")
    public String BookTicket(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = mapper.readValue(body, Map.class);

        BookedTickets newTicket = new BookedTickets(map.get("username"), map.get("departure"), map.get("destination"), map.get("age"), map.get("date"), map.get("ticketscount"));
        BookedTickets.addTicket(newTicket);

        return "Booked";
    }
}