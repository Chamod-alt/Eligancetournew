package travora.travora.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import travora.travora.model.SelecttourAccept;

public interface SelecttourAcceptrepository extends JpaRepository<SelecttourAccept , Long> {
  List<SelecttourAccept> findByEmail(String email);  
}
