package travora.travora.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admindroplist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingdropacceptId;

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
   
}
