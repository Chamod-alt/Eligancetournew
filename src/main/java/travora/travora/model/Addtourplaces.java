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

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Addtourplaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tourplace_id;

   
    private Long tour_topicnumber;

    private String tourplace_name;
    private String tourplace_discription;
    @Lob
    private byte[] tourplace_pic;
}
