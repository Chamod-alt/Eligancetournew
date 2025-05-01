package travora.travora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import travora.travora.model.Addtourplaces;

public interface Addtourplacesrepository extends JpaRepository<Addtourplaces ,Long> {

   @Query("SELECT a FROM Addtourplaces a WHERE a.tour_topicnumber = :id")
List<Addtourplaces> findByTour_topicnumber(@Param("id") Long id);

} 
