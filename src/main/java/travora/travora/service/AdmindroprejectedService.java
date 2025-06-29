package travora.travora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Admindropreject;

import travora.travora.repository.Admindroprejectrepository;


@Service
public class AdmindroprejectedService {
    
      @Autowired
    private Admindroprejectrepository selectiontourreject;

     public List<Admindropreject> getAllUsers(){
        return selectiontourreject.findAll();
    }

    public Admindropreject createBooking(Admindropreject booking) {
        return selectiontourreject.save(booking);
    }
}
