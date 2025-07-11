import React, { useState , useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { FaPlus, FaArrowLeft, FaTrash, FaEdit } from "react-icons/fa";
import "./adminvehicle.css";
import axios from "axios";
import { Link } from 'react-router-dom';
import AdminNavbar from "../../compornents/Adminnavbar";

const AdminVehicleManagement = () => {
  const [vehicles, setVehicles] = useState([
    { id: 1, image: require("../../images/Wagon R.jpeg"), price: "14000", passengers: "4" },
    { id: 2, image: require("../../images/Sedan1.jpeg"), price: "1100", passengers: "4" },
    { id: 3, image: require("../../images/Shuttle.jpeg"), price: "1600", passengers: "4" },
  ]);

  /*const handleRemove = (id) => {
    setVehicles(vehicles.filter((vehicle) => vehicle.id !== id));
  };*/

  const handleEdit = (id) => {
    const vehicleToEdit = vehicles.find(v => v.vehicle_id === id);
    if (vehicleToEdit) {
      setVehicle_name(vehicleToEdit.vehicle_name);
      setPrice(vehicleToEdit.price);
      setPassengerCount(vehicleToEdit.pacenger_count);
      setEditVehicleId(vehicleToEdit.vehicle_id);
      setIsEditing(true);
    }
  };
  


  const [vehicle, setVehicle] = useState([]);
  const [vehicle_name, setVehicle_name] = useState(""); 
  const [price, setPrice] = useState("");
  const [passengerCount, setPassengerCount] = useState("");
  const [image, setImage] = useState(null);


  const [isEditing, setIsEditing] = useState(false);
const [editVehicleId, setEditVehicleId] = useState(null);



  const handleImageChange = (e) => {
    setImage(e.target.files[0]); // Store the selected image
  };

 /* const handleSubmit = async (e) => {
    e.preventDefault();

    if (!price || !passengerCount || !image) {
      alert("Please fill in all fields!");
      return;
    }

    const formData = new FormData();
    formData.append("vehicle_name", vehicle_name)
    formData.append("price", price);
    formData.append("passenger_count", passengerCount);
    formData.append("vehicle_pic", image);

    try {
      const response = await axios.post("http://localhost:8080/api/vehicles/new", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });

      setVehicle([...vehicle, response.data]); // Update state with new vehicle
      setPrice("");
      setPassengerCount("");
      setImage(null);
      alert("Vehicle added successfully!");
    } catch (error) {
      console.error("Error adding vehicle:", error);
      alert("Failed to add vehicle.");
    }
  };
*/

const handleSubmit = async (e) => {
  e.preventDefault();

  const formData = new FormData();
  formData.append("vehicle_name", vehicle_name);
  formData.append("price", price);
  formData.append("passenger_count", passengerCount);
  if (image) formData.append("vehicle_pic", image);

  try {
    if (isEditing) {
      // PUT request for update
      await axios.put(`http://localhost:8080/api/vehicles/${editVehicleId}`, formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      alert("Vehicle updated successfully!");
    } else {
      // POST request to add
      const response = await axios.post("http://localhost:8080/api/vehicles/new", formData, {
        headers: {
          "Content-Type": "multipart/form-data",
        },
      });
      setVehicle([...vehicle, response.data]);
      alert("Vehicle added successfully!");
    }

    // Reset form
    setVehicle_name("");
    setPrice("");
    setPassengerCount("");
    setImage(null);
    setIsEditing(false);
    setEditVehicleId(null);

    // Refresh the list
    const updatedList = await axios.get("http://localhost:8080/api/vehicles");
    setVehicles(updatedList.data);

  } catch (error) {
    console.error("Error submitting form:", error);
    alert("Failed to submit.");
  }
};


  useEffect(() => {
    axios.get("http://localhost:8080/api/vehicles")
      .then((response) => {
        setVehicles(response.data);
      })
      .catch((error) => {
        console.error("Error fetching vehicles:", error);
      });
  }, []);



  const handleRemove = async (id) => {
    try {
      // Make DELETE request to backend
      await axios.delete(`http://localhost:8080/api/vehicles/${id}`);
  
      // Update local state after successful deletion
      setVehicles(vehicles.filter((vehicle) => vehicle.vehicle_id !== id));
  
      alert("Vehicle deleted successfully!");
    } catch (error) {
      console.error("Error deleting vehicle:", error);
      alert("Failed to delete vehicle.");
    }
  };
  

  return (
    <div className="admin-container-flud">
      <AdminNavbar />
      

     
      <h4 className="header"><b>6 Days 7 Nights</b></h4>

   
      <div className="form-section">
      <form onSubmit={handleSubmit}>
        <div className="row">

        <div className="col-sm-4">
        <label>Vehicle Name</label>
        </div>
        <div className="col-sm-5">
        <input type="text" className="form-control"  value={vehicle_name} onChange={(e) => setVehicle_name(e.target.value)}/>
        </div>
        </div>
        <div className="row">
            <div className="col-sm-4">
        <label>Price for day</label>
        </div>
        <div className="col-sm-5">
        <input type="text" className="form-control" value={price} onChange={(e) => setPrice(e.target.value)}/>
        </div>
        </div>
        <div className="row">
            <div className="col-sm-4">
        <label>Available Passenger Count</label>
        </div>
        <div className="col-sm-5">
        <input type="number" className="form-control"  value={passengerCount} onChange={(e) => setPassengerCount(e.target.value)} />
        </div>
        </div>
        <div className="row">

       <div className="col-sm-4">
        <label>Photo</label>
        </div>
        <div className="col-sm-5">
        <input type="file" accept="image/*"  onChange={handleImageChange} />
        <button className="btn-add">
        <FaPlus />
      </button>
     
        </div>
        
      </div>
      <button type="submit" className="adminvehicle_submit">Create</button>
      </form>
      </div>
      

      
      
     {/* <div className="vehicle-list">
        {vehicles.map((vehicle) => (
          <div key={vehicle.id} className="vehicle-card">
            <img src={vehicle.image} alt="Vehicle" />
            <h5>${vehicle.price}</h5>
            <div className="vehicle-buttons">
              <button className="btn-remove" onClick={() => handleRemove(vehicle.id)}>
                Remove
              </button>
              <button className="btn-edit" onClick={() => handleEdit(vehicle.id)}>
                Edit
              </button>
            </div>
          </div>
        ))}
      </div>
*/}

      <div className="vehicle-list">
        {vehicles.map((vehicle) => (
          <div key={vehicle.vehicle_id} className="vehicle-card">
            <img 
              src={`data:image/jpeg;base64,${vehicle.vehicle_pic}`} 
              alt="Vehicle" 
              className="vehicle-image"
            />
            <h5>${vehicle.price}</h5>
            <p>Passengers: {vehicle.pacenger_count}</p>
            <div className="vehicle-buttons">
              <button className="btn-remove" onClick={() => handleRemove(vehicle.vehicle_id)}>
                Remove
              </button>
              <button className="btn-edit" onClick={() => handleEdit(vehicle.vehicle_id)}>
                Edit
              </button>
            </div>
          </div>
        ))}
      </div>

      {/* Back Button */}
      <Link to="/Admintourlist"><button className="btn-back">
        <FaArrowLeft />
      </button>
      </Link>
    </div>
  );
};

export default AdminVehicleManagement;
