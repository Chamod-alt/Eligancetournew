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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Createtourtopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tour_topicnumber;
    private String Description;
    private String package_name;

}
