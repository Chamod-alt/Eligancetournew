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
public class SelecttourReject {
     @Id
   
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tour_rejectedid;
    private String email;
    private String name;
    private String date;
    private String time;
    private String contact_number;
    private String places_names;
    private String vehicle;
    private String cost;
}
