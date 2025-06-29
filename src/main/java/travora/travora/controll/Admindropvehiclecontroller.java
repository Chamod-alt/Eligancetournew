package travora.travora.controll;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import travora.travora.model.Admindropvehicle;
import travora.travora.service.Admindropvehicleservice;

@RestController
@RequestMapping("/api/dropvehicles")
@CrossOrigin(origins = "http://localhost:3000") 
public class Admindropvehiclecontroller {
    
     @Autowired
    private Admindropvehicleservice vehicleService;

    @PostMapping("/new")
    public ResponseEntity<Admindropvehicle> addVehicle(
            @RequestParam("vehicle_name") String name,
            @RequestParam("price") long price,
            @RequestParam("passenger_count") long passengerCount,
            @RequestParam(value = "vehicle_pic", required = false) MultipartFile image) throws IOException {

        Admindropvehicle vehicle = new Admindropvehicle();
        vehicle.setVehicle_name(name);
        vehicle.setPrice(price);
        vehicle.setPacenger_count(passengerCount);

        if (image != null && !image.isEmpty()) {
            vehicle.setVehicle_pic(image.getBytes());
        }

        return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Admindropvehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admindropvehicle> updateVehicle(
            @PathVariable Long id,
            @RequestParam("vehicle_name") String name,
            @RequestParam("price") long price,
            @RequestParam("passenger_count") long passengerCount,
            @RequestParam(value = "vehicle_pic", required = false) MultipartFile image) throws IOException {

        Optional<Admindropvehicle> existing = vehicleService.getVehicleById(id);
        if (existing.isPresent()) {
            Admindropvehicle vehicle = existing.get();
            vehicle.setVehicle_name(name);
            vehicle.setPrice(price);
            vehicle.setPacenger_count(passengerCount);

            if (image != null && !image.isEmpty()) {
                vehicle.setVehicle_pic(image.getBytes());
            }

            return new ResponseEntity<>(vehicleService.saveVehicle(vehicle), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
