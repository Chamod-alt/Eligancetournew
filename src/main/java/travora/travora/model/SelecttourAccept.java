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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SelecttourAccept {
    @Id
   
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tour_acceptid;
    private String email;
    private String name;
    private String date;
    private String time;
    private String contact_number;
    private String places_names;
    private String vehicle;
    private String cost;
    
    private String guide_name;
    private String vehicle_number;

}
