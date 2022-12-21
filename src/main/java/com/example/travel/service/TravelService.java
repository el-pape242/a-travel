package com.example.travel.service;

import com.example.travel.model.Travel;

import java.util.List;

public interface TravelService {
    void addOrUpdateTravel(Travel travel);
    List<Travel> allTravel();
    Travel findTravelByid(Long id);

    void deleteTravel(Travel travel);
}
