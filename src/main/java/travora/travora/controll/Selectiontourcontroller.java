package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Selectiontour;
import travora.travora.service.Selectiontourservice;

@RestController
@RequestMapping("/api/bookings/tour")
@CrossOrigin(origins = "http://localhost:3000")
public class Selectiontourcontroller {
    @Autowired
    private  Selectiontourservice selectionservice;

     

    @GetMapping("/list")
    public List<Selectiontour> getAllUsers() {
        return selectionservice.getAllUsers();
    }

     @PostMapping("/save")
    public Selectiontour createBooking(@RequestBody Selectiontour booking) {
        return selectionservice.createBooking(booking);
    }
}
