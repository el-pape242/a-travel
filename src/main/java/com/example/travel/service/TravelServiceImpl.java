package com.example.travel.service;

import com.example.travel.model.Travel;
import com.example.travel.repository.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {

    TravelRepository travelRepository;
    TravelServiceImpl(TravelRepository travelRepository)
    {
        this.travelRepository = travelRepository;
    }

    @Override
    public void addOrUpdateTravel(Travel travel) {
        travelRepository.save(travel);
    }

    @Override
    public List<Travel> allTravel() {
        return travelRepository.findAll();
    }

    @Override
    public Travel findTravelByid(Long id) {
        Travel travel = null;
        Optional<Travel> travelOptional = travelRepository.findById(id);
        if(!travelOptional.isEmpty())
        {
            travel = travelOptional.get();
        }
        else{
            throw new RuntimeException("Aucun client ayant pour id " +id+ " n'a été trouvé");
        }
        return  travel;
    }

    @Override
    public void deleteTravel(Travel travel) {
        travelRepository.delete(travel);
    }
}
