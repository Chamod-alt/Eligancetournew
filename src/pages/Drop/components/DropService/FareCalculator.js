import React from 'react';
import PropTypes from 'prop-types';
import './FareCalculator.css';
import { useNavigate } from "react-router-dom";

const FareCalculator = ({ distance = 0, vehicle = {}, onBack, onRequest }) => {

  const navigate = useNavigate();
  const safeVehicle = {
    name: vehicle?.name || 'No vehicle selected',
    pricePerKm: vehicle?.pricePerKm || 0,
    capacity: vehicle?.capacity || 0
  };

  const baseFare = 100;
  const calculatedFare = distance * safeVehicle.pricePerKm;
  const totalFare = Math.max(baseFare, calculatedFare);

  const formatCurrency = (amount) => {
    return `$${amount.toFixed(2).replace(/\B(?=(\d{3})+(?!\d))/g, ",")}`;
  };

  const handleRequest = () => {
   /* onRequest({
      vehicle: safeVehicle.name,
      distance: distance.toFixed(1),
      fare: totalFare.toFixed(2)
    });
    */
     navigate('/Dropbooking')
  };

  if (!vehicle || Object.keys(vehicle).length === 0) {
    return (
      <div className="fare-calculator-container">
        <h3>No Vehicle Selected</h3>
        <button onClick={onBack} className="action-button back">
          Back to Vehicles
        </button>
      </div>
    );
  }

  return (
    <div className="fare-calculator-container">
      <h3>Fare Details</h3>
      <div className="fare-details">
        <div className="fare-row">
          <span className="fare-label">Vehicle Type:</span>
          <span className="fare-value">{safeVehicle.name}</span>
        </div>
        <div className="fare-row">
          <span className="fare-label">Distance:</span>
          <span className="fare-value">{distance.toFixed(1)} km</span>
        </div>
        <div className="fare-row">
          <span className="fare-label">Rate:</span>
          <span className="fare-value">{formatCurrency(safeVehicle.pricePerKm)}/km</span>
        </div>
        <div className="fare-row total">
          <span className="fare-label">Total Fare:</span>
          <span className="fare-value">{formatCurrency(totalFare)}</span>
        </div>
      </div>
      
      <div className="action-buttons">
        <button onClick={onBack} className="action-button back">
          Back
        </button>
        <button onClick={handleRequest} className="action-button request">
          Request Vehicle
        </button>
      </div>
    </div>
  );
};

FareCalculator.propTypes = {
  distance: PropTypes.number,
  vehicle: PropTypes.object,
  onBack: PropTypes.func.isRequired,
  onRequest: PropTypes.func.isRequired
};

export default FareCalculator;