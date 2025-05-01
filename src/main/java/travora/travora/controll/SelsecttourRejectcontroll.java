package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import travora.travora.model.SelecttourReject;

import travora.travora.service.SelecttourRejectservice;

@RestController
@RequestMapping("/api/rejectbooking/tour")
@CrossOrigin(origins = "http://localhost:3000")
public class SelsecttourRejectcontroll {
    
    @Autowired
    private  SelecttourRejectservice selecttourreject;

     

    @GetMapping("/list")
    public List<SelecttourReject> getAllUsers() {
        return selecttourreject.getAllUsers();
    }

     @PostMapping("/save")
    public SelecttourReject createBooking(@RequestBody SelecttourReject booking) {
        return selecttourreject.createBooking(booking);
    }
}
