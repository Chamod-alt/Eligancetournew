package travora.travora.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Admindropreject;

import travora.travora.service.AdmindroprejectedService;


@RestController
@RequestMapping("/api/rejectdrop/tour")
@CrossOrigin(origins = "http://localhost:3000")
public class Admindroprejectcontroll {
      @Autowired
    private  AdmindroprejectedService selecttourreject;

     

    @GetMapping("/list")
    public List<Admindropreject> getAllUsers() {
        return selecttourreject.getAllUsers();
    }

     @PostMapping("/save")
    public Admindropreject createBooking(@RequestBody Admindropreject booking) {
        return selecttourreject.createBooking(booking);
    }


}
