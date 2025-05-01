package travora.travora.controll;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import travora.travora.model.Addtourplaces;
import travora.travora.service.Addtourplacesservice;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tourplaces/add")
@CrossOrigin(origins = "http://localhost:3000")
public class Addtourplacescontroll {

    @Autowired
    private Addtourplacesservice addtourplacesservice;
    
 


@PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public ResponseEntity<?> saveTourPlace(
        @RequestParam("tourplace_name") String name,
        @RequestParam("tourplace_discription") String description,
        @RequestParam("tour_topicnumber") Long tour_topicnumber,
        @RequestParam(value = "tourplace_pic", required = false) MultipartFile file
) {
    try {
        Addtourplaces place = new Addtourplaces();
        place.setTourplace_name(name);
        place.setTourplace_discription(description);
        place.setTour_topicnumber(tour_topicnumber);
        
        if (file != null && !file.isEmpty()) {
            place.setTourplace_pic(file.getBytes());
        }

        Addtourplaces savedPlace = addtourplacesservice.savePlace(place);
        return ResponseEntity.ok(savedPlace);
    } catch (IOException e) {
        return ResponseEntity.internalServerError().body("Failed to save image: " + e.getMessage());
    }
}

    // Get all tour places
    @GetMapping("/all")
    public ResponseEntity<List<Addtourplaces>> getAllPlaces() {
        List<Addtourplaces> places = addtourplacesservice.getAllPlcess();
        return ResponseEntity.ok(places);
    }

   

   /*  @GetMapping("/{tourtopic_number}")
    public ResponseEntity<Addtourplaces> getPlaceById(@PathVariable Long tourplace_id) {
        Optional<Addtourplaces> place = addtourplacesservice.getPlaceById(tourplace_id);
        return place.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
*/

@GetMapping("/{tourtopic_number}")
public ResponseEntity<List<Addtourplaces>> getPlacesByTourTopicNumber(@PathVariable("tourtopic_number") Long tour_topicnumber) {
    List<Addtourplaces> places = addtourplacesservice.getPlacesByTourTopicNumber(tour_topicnumber);
    return ResponseEntity.ok(places);
}

    // Delete a tour place by tourplace_id
    @DeleteMapping("/delete/{tourplace_id}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long tourplace_id) {
        Optional<Addtourplaces> place = addtourplacesservice.getPlaceById(tourplace_id);
        if (place.isPresent()) {
            addtourplacesservice.deletePlace(tourplace_id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/update/{id}")
public ResponseEntity<?> updateTourPlace(
        @PathVariable("id") Long id,
        @RequestParam("tourplace_name") String name,
        @RequestParam("tourplace_discription") String description,
        @RequestParam("tour_topicnumber") Long tour_topicnumber,
        @RequestParam(value = "tourplace_pic", required = false) MultipartFile file
) {
    try {
        Optional<Addtourplaces> optionalPlace = addtourplacesservice.getPlaceById(id);
        if (optionalPlace.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Addtourplaces place = optionalPlace.get();
        place.setTourplace_name(name);
        place.setTourplace_discription(description);
        place.setTour_topicnumber(tour_topicnumber);
        
        if (file != null && !file.isEmpty()) {
            place.setTourplace_pic(file.getBytes());
        }

        Addtourplaces updated = addtourplacesservice.savePlace(place);
        return ResponseEntity.ok(updated);
    } catch (IOException e) {
        return ResponseEntity.internalServerError().body("Failed to update image: " + e.getMessage());
    }
}
}
