package travora.travora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import travora.travora.model.SelecttourReject;

import travora.travora.repository.SelecttourRejectrepository;

@Service
public class SelecttourRejectservice {
    

     @Autowired
    private SelecttourRejectrepository selectiontourreject;

     public List<SelecttourReject> getAllUsers(){
        return selectiontourreject.findAll();
    }

    public SelecttourReject createBooking(SelecttourReject booking) {
        return selectiontourreject.save(booking);
    }
}
