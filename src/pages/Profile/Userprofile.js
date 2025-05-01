import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './userprofile.css';
import defaultProfilePic from '../../images/default-profile.png';
import { FaBell } from 'react-icons/fa'; // Notification Icon
import  Sidebar from '../../compornents/Sidebar';

const Profile = () => {
  const [user, setUser] = useState({
    username: 'JohnDoe',
    email: 'john.doe@example.com',
    phoneNumber: '+1 (555) 123-4567',
    profilePicture: defaultProfilePic,
  });

  const [isEditing, setIsEditing] = useState(false);
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/login');
  };

  const handleSave = () => {
    setIsEditing(false);
    alert('Profile updated successfully!');
  };

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setUser((prev) => ({ ...prev, [name]: value }));
  };


  const handleClick = () => {
    navigate("/Notification"); // Navigate to tour plan page
  };

  const handleImageChange = (e) => {
    if (e.target.files && e.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (event) => {
        setUser((prev) => ({ ...prev, profilePicture: event.target.result }));
      };
      reader.readAsDataURL(e.target.files[0]);
    }
  };

  return (
    <div>
        <Sidebar />
        <div className='profile_main'>
    <div className="profile-container-profile">
      {/* Notification Icon */}
      <div className="notification-icon" onClick={handleClick}>
        <FaBell />
      </div>

      <div className="profile-card">
        <h2 className="profile-title">My Profile</h2>

        {/* Profile Picture */}
        <div className="profile-pic">
          <img 
            src={user.profilePicture} 
            alt="Profile" 
            className="profile-img"
            onError={(e) => {
              e.target.onerror = null; 
              e.target.src = defaultProfilePic;
            }}
          />
          {isEditing && (
            <label htmlFor="profile-picture-upload" className="edit-icon">
              📷
            </label>
          )}
          <input
            id="profile-picture-upload"
            type="file"
            accept="image/*"
            onChange={handleImageChange}
            style={{ display: 'none' }}
          />
        </div>

        {/* Profile Details */}
        <div className="profile-info">
          <div className="input-group">
            <label>Username</label>
            <input 
              type="text" 
              name="username" 
              value={user.username} 
              onChange={handleInputChange} 
              disabled={!isEditing} 
            />
          </div>

          <div className="input-group">
            <label>Email</label>
            <input 
              type="email" 
              name="email" 
              value={user.email} 
              onChange={handleInputChange} 
              disabled={!isEditing} 
            />
          </div>

          <div className="input-group">
            <label>Phone</label>
            <input 
              type="tel" 
              name="phoneNumber" 
              value={user.phoneNumber} 
              onChange={handleInputChange} 
              disabled={!isEditing} 
            />
          </div>
        </div>

        {/* Buttons */}
        <div className="button-group">
          {isEditing ? (
            <button className="save-btn" onClick={handleSave}>Save</button>
          ) : (
            <button className="edit-btn" onClick={() => setIsEditing(true)}>Edit</button>
          )}
        </div>
      </div>
    </div>
    </div>
    </div>
  );
};

export default Profile;
