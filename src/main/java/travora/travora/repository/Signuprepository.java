package travora.travora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import travora.travora.model.Signup;

public interface Signuprepository extends JpaRepository<Signup,String>{
    Optional<Signup> findByEmail(String email);
     
}
