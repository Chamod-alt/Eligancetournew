package travora.travora.controll;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Createtourtopic;
import travora.travora.service.Createtourtopicservice;

@RestController
@RequestMapping("/api/tour-topics")
@CrossOrigin(origins = "http://localhost:3000")
public class Createtourtopiccontroll {

    @Autowired
    private Createtourtopicservice tourService;

    // CREATE a new tour topic
    @PostMapping("/save")
    public Createtourtopic createTourTopic(@RequestBody Createtourtopic tour) {
        return tourService.savetour(tour);
    }

    
    @GetMapping
    public List<Createtourtopic> getAllTourTopics() {
        return tourService.getAlltour();
    }

    
    @GetMapping("/{tour_topicnumber}")
    public Createtourtopic getTourTopicById(@PathVariable Long tour_topicnumber) {
        return tourService.gettourById(tour_topicnumber).orElse(null);
    }

    // UPDATE a tour topic
    @PutMapping("/{tour_topicnumber}")
    public Createtourtopic updateTourTopic(@PathVariable Long tour_topicnumber, @RequestBody Createtourtopic updatedTour) {
        updatedTour.setTour_topicnumber(tour_topicnumber); // Set the primary key explicitly
        return tourService.savetour(updatedTour);
    }

    // DELETE a tour topic
    @DeleteMapping("/{tour_topicnumber}")
    public void deleteTourTopic(@PathVariable Long tour_topicnumber) {
        tourService.deleteVehicle(tour_topicnumber);
    }
    
}
