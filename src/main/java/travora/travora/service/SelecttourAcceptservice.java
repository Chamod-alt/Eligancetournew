package travora.travora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import travora.travora.model.SelecttourAccept;

import travora.travora.repository.SelecttourAcceptrepository;

@Service
public class SelecttourAcceptservice {
    

     @Autowired
    private SelecttourAcceptrepository selectiontouracceptrepository;


    public List<SelecttourAccept> getAllUsers(){
        return selectiontouracceptrepository.findAll();
    }

    public SelecttourAccept createBooking(SelecttourAccept booking) {
        return selectiontouracceptrepository.save(booking);
    }
}
