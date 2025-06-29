package travora.travora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import travora.travora.model.Admindropaccept;


public interface Admindropacceptrepository extends JpaRepository<Admindropaccept , Long> {
    List<Admindropaccept> findByEmail(String email);
}
