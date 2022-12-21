package com.example.travel.controller;

import com.example.travel.model.Travel;
import com.example.travel.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

    TravelService travelService;
    NavigationController(TravelService travelService)
    {
        this.travelService = travelService;
    }



    @GetMapping("/subscribe")
    public String showTravelForm(Travel travel)
    {
        return "subscribes";
    }

    @GetMapping("/listings")
    public String AllTravel(Model model)
    {
        model.addAttribute("travels",travelService.allTravel());
        return "listings";
    }

    /***@GetMapping("/listings")
    public String getListing(){
        return "listings";
    }**/


    @GetMapping("/index")
    public String getHome(){
        return "index";
    }

}
