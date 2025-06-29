package travora.travora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admindropreject {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Dropreject_id;

    private String email;
    private String name;
    private String contactNo;
    private String date;
    private String arrivalTime;
    private String vehicle;
    private int passengerCount;
    private String pickupLocation;
    private String dropLocation;
    private String distance;
    private String totalCost;

}
