package travora.travora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Selectiontour;
import travora.travora.repository.Selectiontourrepository;

@Service
public class Selectiontourservice {
 
    @Autowired
    private Selectiontourrepository selectiontourrepository;


    public List<Selectiontour> getAllUsers(){
        return selectiontourrepository.findAll();
    }

    public Selectiontour createBooking(Selectiontour booking) {
        return selectiontourrepository.save(booking);
    }
}
