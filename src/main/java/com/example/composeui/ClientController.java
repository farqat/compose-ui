package com.example.composeui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    RestTemplate template;

    @GetMapping("/")
    public String home(Model model){
        Object[] objects = template.getForObject("http://apihost:8080/friends", Object[].class);
        List<Object> friends = Arrays.asList(objects);
        model.addAttribute("friends", friends);
        return "index";

    }
}
