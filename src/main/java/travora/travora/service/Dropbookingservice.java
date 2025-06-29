package travora.travora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Dropbooking;
import travora.travora.repository.Dropbookingrepository;

@Service
public class Dropbookingservice {
    
    @Autowired
    private Dropbookingrepository dropBookingRepository;

    public Dropbooking saveBooking(Dropbooking booking) {
        return dropBookingRepository.save(booking);
    }

    public List<Dropbooking> getAllBookings() {
        return dropBookingRepository.findAll();
    }

    public Dropbooking getBookingById(Long id) {
        return dropBookingRepository.findById(id).orElse(null);
    }

    public void deleteBooking(Long id) {
        dropBookingRepository.deleteById(id);
    }


    public Dropbooking getBookingByEmail(String email) {
        return dropBookingRepository.findByEmail(email);
    }
}
