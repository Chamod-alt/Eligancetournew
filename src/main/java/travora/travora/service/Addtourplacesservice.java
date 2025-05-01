package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Addtourplaces;

import travora.travora.repository.Addtourplacesrepository;


@Service
public class Addtourplacesservice {
    
      @Autowired
    private Addtourplacesrepository admintourplacesRepository;

    // Create or Update
    public Addtourplaces savePlace(Addtourplaces place) {
        return admintourplacesRepository.save(place);
    }

    
    public List<Addtourplaces> getAllPlcess() {
        return admintourplacesRepository.findAll();
    }

    
    public Optional<Addtourplaces> getPlaceById(Long tourplace_id) {
        return admintourplacesRepository.findById(tourplace_id);
    }

    
    public void deletePlace(Long tourplace_id) {
        admintourplacesRepository.deleteById(tourplace_id);
    }

    public List<Addtourplaces> getPlacesByTourTopicNumber(Long tour_topicnumber) {
        return admintourplacesRepository.findByTour_topicnumber(tour_topicnumber);
    }
    
}
