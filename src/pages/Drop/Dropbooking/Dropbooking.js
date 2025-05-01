import React from "react";
import "./dropbooking.css";
import { Link } from 'react-router-dom';

const PreDesignBookingForm = () => {
  return (
    <div className="dropbooking-container">
      <div className="booking-card">
        <h2 className="title">Booking Details</h2>
        <div className="details">
          <div className="row">
            <div className="col-4">
            <span className="label">Name</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="Chamod" readOnly />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Contact No</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="0716485723" readOnly />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Date</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="2025.10.10" readOnly />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Arrival Time</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="09.09 A.M" readOnly />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Your Vehicle</span>
            </div>
            <div className="col-8">
            <img src="https://via.placeholder.com/80" alt="Vehicle" className="vehicle-img" />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Event</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="Village Tour Event" readOnly />
            </div>
          </div>
          <div className="row">
            <div className="col-4">
            <span className="label">Total Cost</span>
            </div>
            <div className="col-8">
            <input type="text" className="input" value="200$" readOnly />
            </div>
          </div>
        </div>
        <div className="book-buttons">
        <Link to="/Bookingpending"><button className="book-btn">Book</button></Link>
        <Link to="/DropService"><button className="cancel-btn">Cancel</button></Link>
        </div>
      </div>
    </div>
  );
};

export default PreDesignBookingForm;
