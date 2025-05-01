import React, { useState } from "react";
//import { FaGoogle, FaFacebook, FaGithub, FaLinkedin } from "react-icons/fa";
import "./login.css"; 
import { Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Button } from "bootstrap";
//import Navbar from "./Navbar.js"
import Navbar from "../compornents/Navbar";
import { useNavigate } from "react-router-dom";


const LoginRegister = () => {
  const [isRegister, setIsRegister] = useState(false);


  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    
    const loginData = { email, password };

    try {
      const response = await fetch("http://localhost:8080/api/login/authenticatesave", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        credentials: "include", 
        body: JSON.stringify(loginData),
      });
      if (response.ok) {
        const data = await response.json();
        localStorage.setItem("token", data.token); 
        navigate("/Selectplaces"); 
        localStorage.setItem("userEmail", email);
      } else {
        setError(alert("Invalid email or password. Please try again."));
      }
    } catch (error) {
      setError("wait");
      /*navigate("/Selectplaces"); */
      navigate("/Dashboad");
      localStorage.setItem("userEmail", email);
    }
  };

  return (
    <div>

<Navbar />
    <div style={{maxHeight:"100vh"}}>
      
    


<div class="container-login">
  <div class="row">
   
    <div class="col-sm">
      <div className="login-form">
        <p style={{textAlign:"center",fontSize:"30px",fontWeight:"bold"}}>Login</p>
        <br />
        {error && <p style={{ color: "red", textAlign: "center" }}>{error}</p>}
        <form onSubmit={handleLogin}>
        <div className="input-group">
            <input type="email" placeholder="Email"
             value={email}
             onChange={(e) => setEmail(e.target.value)}
             required />
            {isRegister && <input type="email" placeholder="Email" />}
            <input type="password" placeholder="Password" 
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required />
           
            
          </div>
          <p className="log-forgetpassword"><Link to="/Adminvehicle" class="link-offset-1" href="#" style={{marginLeft: "5px"}}>foget your password</Link></p>
          <button className="submit-btn">Login</button>
          <br />
          <br />
          <p className="log-gotosignup">if your are not sign up pleace <Link to="/Signup" class="link-danger link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">Sing Up</Link></p>
        </form>
      </div>
    </div>
    
    <div className="col-sm">
    <div className="rightpicture">
        

        </div>
    </div>
  </div>
</div>
    </div>
    </div>
  );
};

export default LoginRegister;