package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Dropbooking;
import travora.travora.service.Dropbookingservice;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/drop-bookings")
public class Dropbookingcontroll {
 
    @Autowired
    private Dropbookingservice dropBookingService;

    @PostMapping("/save")
    public Dropbooking saveBooking(@RequestBody Dropbooking booking) {
        return dropBookingService.saveBooking(booking);
    }

    @GetMapping("/all")
    public List<Dropbooking> getAllBookings() {
        return dropBookingService.getAllBookings();
    }

   /*  @GetMapping("/{id}")
    public Dropbooking getBookingById(@PathVariable Long id) {
        return dropBookingService.getBookingById(id);
    } */

    @GetMapping("/byemail/{email}")
public Dropbooking getBookingByEmail(@PathVariable String email) {
    return dropBookingService.getBookingByEmail(email);
}


    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id) {
        dropBookingService.deleteBooking(id);
    }
}
