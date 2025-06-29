package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import travora.travora.model.Admindropaccept;

import travora.travora.repository.Admindropacceptrepository;

@Service
public class AdmindropacceptService {
     @Autowired
    private Admindropacceptrepository selectiontouracceptrepository;


    public List<Admindropaccept> getAllUsers(){
        return selectiontouracceptrepository.findAll();
    }

    public Admindropaccept createBooking(Admindropaccept booking) {
        return selectiontouracceptrepository.save(booking);
    }

  

    public List<Admindropaccept> getByEmail(String email) {
        return selectiontouracceptrepository.findByEmail(email);
    }
}
