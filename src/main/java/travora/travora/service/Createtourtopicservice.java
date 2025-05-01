package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import travora.travora.model.Createtourtopic;

import travora.travora.repository.Createtourtopicrepository;

@Service
public class Createtourtopicservice {
    @Autowired
    private Createtourtopicrepository createtourtopicRepository;

    // Create or Update
    public Createtourtopic savetour(Createtourtopic tour) {
        return createtourtopicRepository.save(tour);
    }

    
    public List<Createtourtopic> getAlltour() {
        return createtourtopicRepository.findAll();
    }

    
    public Optional<Createtourtopic> gettourById(Long tour_topicnumber) {
        return createtourtopicRepository.findById(tour_topicnumber);
    }

    
    public void deleteVehicle(Long tour_topicnumber) {
        createtourtopicRepository.deleteById(tour_topicnumber);
    }
}
