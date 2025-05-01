package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import travora.travora.model.SelecttourAccept;

import travora.travora.service.SelecttourAcceptservice;

@RestController
@RequestMapping("/api/acceptbooking/tour")
@CrossOrigin(origins = "http://localhost:3000")
public class SelecttourAcceptcontroll {
    @Autowired
    private  SelecttourAcceptservice selectiontouracceptservice;

     

    @GetMapping("/list")
    public List<SelecttourAccept> getAllUsers() {
        return selectiontouracceptservice.getAllUsers();
    }

     @PostMapping("/save")
    public SelecttourAccept createBooking(@RequestBody SelecttourAccept booking) {
        return selectiontouracceptservice.createBooking(booking);
    }
}
