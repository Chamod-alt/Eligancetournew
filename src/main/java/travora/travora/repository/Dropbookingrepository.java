package travora.travora.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import travora.travora.model.Dropbooking;

public interface Dropbookingrepository extends JpaRepository<Dropbooking, Long> {
    Dropbooking findByEmail(String email);
}
