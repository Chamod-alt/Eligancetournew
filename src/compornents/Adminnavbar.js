import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Link } from "react-router-dom";
import "./adminnavbar.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import image12 from "../images/newlogo.jpeg";

const AdminNavbar = () => {
 

  return (
    <div>
        {/*<div className="navbar">
              <Link to="/Admintourdiscription"><span>Home</span></Link>
              <Link to="/Admintourlist"><span>All Booking of packages</span></Link>
              <Link to="/AdmintourAccept"><span>Accept List</span></Link>
              <Link to="/Admintourrejected"><span>Reject List</span></Link>
              <span>Canceled Booking</span>
            </div>
      */}

<nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
  <img src={image12} style={{ width: "50px", height: "50px", borderRadius: "50%", marginRight:"200px" }} alt="Logo" />
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
      <Link to="/Admintourdiscription"><span>Home</span></Link>
      <Link to="/Admintourlist"><span>All Booking of packages</span></Link>
              <Link to="/AdmintourAccept"><span>Accept List</span></Link>
              <Link to="/Admintourrejected"><span>Reject List</span></Link>
              <span>Canceled Booking</span>
      </div>
    </div>
  </div>
</nav>
    </div>
  );
};

export default AdminNavbar;
