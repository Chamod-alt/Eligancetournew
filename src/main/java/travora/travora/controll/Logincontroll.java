package travora.travora.controll;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import travora.travora.model.Login;
import travora.travora.service.Loginservice;

import java.util.Optional;
import org.slf4j.Logger;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class Logincontroll {
    
    private static final Logger logger = LoggerFactory.getLogger(Logincontroll.class);

    @Autowired
    private Loginservice loginService;

    
    @PostMapping("/create")
    public ResponseEntity<Login> createLogin(@RequestBody Login login) {
        logger.info("Received login creation request for email: {}", login.getEmail());
        Login createdLogin = loginService.createLogin(login);
        return ResponseEntity.ok(createdLogin);
    }

    
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody Login login) {
        logger.info("Authentication request received for email: {}", login.getEmail());
        boolean isAuthenticated = loginService.authenticateUser(login.getEmail(), login.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password.");
        }
    }


    @PostMapping("/authenticatesave")
public ResponseEntity<String> authenticateAndSave(@RequestBody Login login) {
    logger.info("Authentication request received for email: {}", login.getEmail());

    boolean isAuthenticated = loginService.authenticateUseragain(login.getEmail(), login.getPassword());

    if (isAuthenticated) {
        
        loginService.createLogin(login);
        return ResponseEntity.ok("Login successful and saved!");
    } else {
        return ResponseEntity.status(401).body("Invalid email or password.");
    }
}


    
    @GetMapping("/{email}")
    public ResponseEntity<Login> getLoginByEmail(@PathVariable String email) {
        logger.info("Fetching login details for email: {}", email);
        Optional<Login> login = loginService.getLoginByEmail(email);
        return login.map(ResponseEntity::ok).orElseGet(() -> {
            logger.warn("Login details not found for email: {}", email);
            return ResponseEntity.notFound().build();
        });
    }
 
    @PutMapping("/update-password/{email}")
    public ResponseEntity<String> updatePassword(@PathVariable String email, @RequestBody String newPassword) {
        Login updatedLogin = loginService.updatePassword(email, newPassword);
    
        if (updatedLogin != null) {
            return ResponseEntity.ok("Password updated successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    

}
