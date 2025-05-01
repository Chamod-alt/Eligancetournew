package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Admintourvehicle;
import travora.travora.repository.Admintourvehiclerepository;

@Service
public class Admintourvehicleservice {
  
      @Autowired
    private Admintourvehiclerepository admintourvehicleRepository;

    // Create or Update
    public Admintourvehicle saveVehicle(Admintourvehicle vehicle) {
        return admintourvehicleRepository.save(vehicle);
    }

    
    public List<Admintourvehicle> getAllVehicles() {
        return admintourvehicleRepository.findAll();
    }

    
    public Optional<Admintourvehicle> getVehicleById(Long id) {
        return admintourvehicleRepository.findById(id);
    }

    
    public void deleteVehicle(Long id) {
        admintourvehicleRepository.deleteById(id);
    }
}
