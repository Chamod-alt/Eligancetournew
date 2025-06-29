package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Admindropvehicle;
import travora.travora.repository.Admindropvehiclerepository;

@Service
public class Admindropvehicleservice {
   
    @Autowired
    private Admindropvehiclerepository admindropRepository;

   
    public Admindropvehicle saveVehicle(Admindropvehicle vehicle) {
        return admindropRepository.save(vehicle);
    }

    
    public List<Admindropvehicle> getAllVehicles() {
        return admindropRepository.findAll();
    }

    
    public Optional<Admindropvehicle> getVehicleById(Long id) {
        return admindropRepository.findById(id);
    }

    
    public void deleteVehicle(Long id) {
        admindropRepository.deleteById(id);
    }
}
