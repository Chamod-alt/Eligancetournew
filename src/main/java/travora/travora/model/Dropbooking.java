package travora.travora.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dropbooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

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
