package travora.travora.controll;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import travora.travora.model.Admintourvehicle;
import travora.travora.service.Admintourvehicleservice;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "http://localhost:3000")  
public class Admintourvehiclecontroll {
    

     @Autowired
    private Admintourvehicleservice admintourvehicleService;

  
    @PostMapping(value = "/new", consumes = "multipart/form-data")
    public ResponseEntity<Admintourvehicle> saveVehicle(
            @RequestParam("vehicle_name") String vehicleName,
            @RequestParam("price") long price,
            @RequestParam("passenger_count") long passengerCount,
            @RequestParam("vehicle_pic") MultipartFile file) {

        try {
            Admintourvehicle vehicle = new Admintourvehicle();
            vehicle.setVehicle_name(vehicleName);
            vehicle.setPrice(price);
            vehicle.setPacenger_count(passengerCount);
            vehicle.setVehicle_pic(file.getBytes()); // Store image as byte array

            Admintourvehicle savedVehicle = admintourvehicleService.saveVehicle(vehicle);
            return ResponseEntity.ok(savedVehicle);
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // Get all vehicles
    @GetMapping
    public ResponseEntity<List<Admintourvehicle>> getAllVehicles() {
        return ResponseEntity.ok(admintourvehicleService.getAllVehicles());
    }

    // Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admintourvehicle> getVehicleById(@PathVariable Long id) {
        Optional<Admintourvehicle> vehicle = admintourvehicleService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
public ResponseEntity<Admintourvehicle> updateVehicle(
        @PathVariable Long id,
        @RequestParam("vehicle_name") String vehicleName,
        @RequestParam("price") long price,
        @RequestParam("passenger_count") long passengerCount,
        @RequestParam(value = "vehicle_pic", required = false) MultipartFile file) {

    Optional<Admintourvehicle> optionalVehicle = admintourvehicleService.getVehicleById(id);
    if (!optionalVehicle.isPresent()) {
        return ResponseEntity.notFound().build();
    }

    try {
        Admintourvehicle vehicle = optionalVehicle.get();
        vehicle.setVehicle_name(vehicleName);
        vehicle.setPrice(price);
        vehicle.setPacenger_count(passengerCount);

        if (file != null && !file.isEmpty()) {
            vehicle.setVehicle_pic(file.getBytes()); // update image if provided
        }

        Admintourvehicle updatedVehicle = admintourvehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(updatedVehicle);
    } catch (IOException e) {
        return ResponseEntity.badRequest().build();
    }
}


    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        admintourvehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }
}
