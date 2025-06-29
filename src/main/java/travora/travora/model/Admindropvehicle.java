package travora.travora.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admindropvehicle {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long vehicledrop_id;
    private String vehicle_name;
    private long price;
    private long pacenger_count;
    @Lob
    private byte[] vehicle_pic;
    
}
