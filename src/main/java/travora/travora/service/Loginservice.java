package travora.travora.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import travora.travora.model.Login;
import travora.travora.model.Signup;
import travora.travora.repository.Loginrepository;
import travora.travora.repository.Signuprepository;
import org.slf4j.Logger;

@Service
public class Loginservice {
 
    private static final Logger logger = LoggerFactory.getLogger(Loginservice.class);

    @Autowired
    private Loginrepository loginRepository;

    @Autowired
    private Signuprepository signupRepository;

    public Login createLogin(Login login) {
        logger.info("Creating new login record for email: {}", login.getEmail());
        return loginRepository.save(login);
    }

    public Optional<Login> getLoginByEmail(String email) {
        logger.info("Fetching login record for email: {}", email);
        return loginRepository.findByEmail(email);
    }

    public boolean authenticateUser(String email, String password) {
        System.out.println("Searching for email: " + email);
    
        Optional<Signup> user = signupRepository.findByEmail(email);
    
        if (user.isPresent()) {
            System.out.println("User found: " + user.get().getEmail());
            return user.get().getPassword().equals(password);
        } else {
            System.out.println("User NOT found for email: " + email);
            return false;
        }
    }

    public boolean authenticateUseragain(String email, String password) {
        Optional<Signup> user = signupRepository.findByEmail(email);
    
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return true; 
        } 
        return false; 
    }
    
    public Login updatePassword(String email, String newPassword) {
        Optional<Login> userOpt = loginRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            Login user = userOpt.get();
            user.setPassword(newPassword);
            return loginRepository.save(user);
        } else {
            // Instead of throwing, return null or handle gracefully
            logger.warn("No login found for email: {}", email);
            return null;
        }
    }
    
    
    
    
}
