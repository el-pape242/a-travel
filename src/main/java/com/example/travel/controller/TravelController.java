package com.example.travel.controller;

import com.example.travel.model.Travel;
import com.example.travel.service.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TravelController {

    TravelService travelService;
    TravelController(TravelService travelService)
    {
        this.travelService = travelService;
    }

   /** @GetMapping("/list")
    public String AllTravel(Model model)
    {
        model.addAttribute("travels",travelService.allTravel());
        return "listings";
    }
**/
    @PostMapping("/save")
    public String saveTravel(Travel travel)
    {
        travelService.addOrUpdateTravel(travel);
        return "redirect:/listings"; //on prend le list du getmapping
    }

    @GetMapping("/modif/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("travel", travelService.findTravelByid(id));
        return "travel-edit";
    }

    @PostMapping("/update/{id}")
    public String updateEmploye(@PathVariable("id") Long id,Travel travel)
    {
        travelService.addOrUpdateTravel(travel);
        return "redirect:/listings";
    }

    @GetMapping("/delete/{id}")
    public String deleteTravel(@PathVariable("id") Long id, Travel travel)
    {

        travelService.deleteTravel(travel);
        return "redirect:/listings";
    }
}
