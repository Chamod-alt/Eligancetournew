package travora.travora.controll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Signup;
import travora.travora.repository.Signuprepository;
import travora.travora.service.Signupservice;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/signup")
@CrossOrigin(origins = "http://localhost:3000")
public class Signupcontroll {

    
 
    @Autowired
    private Signupservice signupservice;

    @Autowired
    private Signuprepository signuprepository;

    
{/* 
   @PostMapping("/save")
  public Signup createuser(@RequestBody Signup user){
    return signupservice.createsignup(user);
  }

*/}

@PostMapping("/save")
public ResponseEntity<?> createuser(@RequestBody Signup user) {
    try {
        Signup newUser = signupservice.createsignup(user);
        return ResponseEntity.ok(newUser);
    } catch (RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

  @GetMapping("/users")
    public List<Signup> getAllUsers() {
        return signupservice.getAllusers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Signup> getUserById(@PathVariable String Email) {
        Optional<Signup> user = signupservice.getUserbyId(Email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    

  @GetMapping("/getbyemail/{email}")
public ResponseEntity<Signup> getUserByEmail(@PathVariable String email) {
    Optional<Signup> user = signupservice.getUserbyId(email);
    return user.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
} 

@PostMapping("path")
public String postMethodName(@RequestBody String entity) {
    //TODO: process POST request
    
    return entity;
}

@PutMapping("/update-password")
public Signup updatePassword(String email, String newPassword) {
  Optional<Signup> userOpt = signuprepository.findByEmail(email);
  if (userOpt.isPresent()) {
      Signup user = userOpt.get();
      user.setPassword(newPassword);
      return signuprepository.save(user);
  } else {
      throw new IllegalStateException("No user found with email: " + email);
  }
}

@PutMapping("/update")
public ResponseEntity<?> updateUser(@RequestBody Signup updatedUser) {
    Optional<Signup> existingUser = signuprepository.findByEmail(updatedUser.getEmail());
    if (existingUser.isPresent()) {
        Signup user = existingUser.get();
        user.setUsername(updatedUser.getUsername());
        user.setContact_Number(updatedUser.getContact_Number());
        user.setPassword(updatedUser.getPassword());
        Signup savedUser = signuprepository.save(user);
        return ResponseEntity.ok(savedUser);
    } else {
        return ResponseEntity.notFound().build();
    }
}



}
