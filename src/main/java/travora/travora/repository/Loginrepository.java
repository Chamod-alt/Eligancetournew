package travora.travora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import travora.travora.model.Login;

public interface Loginrepository extends JpaRepository<Login,Long> {
    Optional<Login> findByEmail(String email);
    
} 
