package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import travora.travora.model.Signup;
import travora.travora.repository.Signuprepository;

@Service
public class Signupservice {
   
     @Autowired
 private Signuprepository signuprepository;



 
 public List<Signup> getAllusers(){
    return signuprepository.findAll();
 }

 public Optional<Signup> getUserbyId(String Email){
    return signuprepository.findById(Email);
 }

/*  public Signup createsignup(Signup user){
   return signuprepository.save(user);
 }
   */

   public Signup createsignup(Signup user) {
      Optional<Signup> existingUser = signuprepository.findByEmail(user.getEmail());
      if (existingUser.isPresent()) {
          throw new RuntimeException("Email already registered");
      }
      return signuprepository.save(user);
  }

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


}
