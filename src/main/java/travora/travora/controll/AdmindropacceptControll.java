package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Admindropaccept;

import travora.travora.service.AdmindropacceptService;


@RestController
@RequestMapping("/api/admindropaccept/tour")
@CrossOrigin(origins = "http://localhost:3000")
public class AdmindropacceptControll {
    @Autowired
    private  AdmindropacceptService selectiontouracceptservice;

     

    @GetMapping("/list")
    public List<Admindropaccept> getAllUsers() {
        return selectiontouracceptservice.getAllUsers();
    }


     @PostMapping("/save")
    public Admindropaccept createBooking(@RequestBody Admindropaccept booking) {
        return selectiontouracceptservice.createBooking(booking);
    }

   
    @GetMapping("/find/{email}")
public List<Admindropaccept> getByEmail(@PathVariable String email) {
    return selectiontouracceptservice.getByEmail(email);
}


}
