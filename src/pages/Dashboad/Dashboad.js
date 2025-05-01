import React from "react";
import Sidebar from "../../compornents/Sidebar"; // Import the sidebar
import "./dashboad.css"; // Import styles

const HomePage = () => {
  return (
    <div className="home-container">
      <Sidebar />
      <div className="main-content">
        {/* Profile Section */}
        <div className="profile-section">
          <img 
            src="https://p7.hiclipart.com/preview/481/915/760/computer-icons-user-avatar-woman-avatar.jpg" 
            alt="Profile Avatar" 
            className="profile-avatar"
          />
          <div className="profile-details">
            <h2>Experiences:</h2>
            <p>Multilingual Support <br /> Personalized Service <br /> Memory Maker</p>
            <h2>Languages:</h2>
            <p>Sinhala <br /> English <br /> Tamil</p>
          </div>
        </div>

        {/* Image Gallery */}
        <div className="image-gallery">
          <img src="https://i.pinimg.com/236x/e6/5f/84/e65f84d23cbbab2560502a1d5b390b73.jpg" alt="Waterfall" />
          <img src="https://i.pinimg.com/736x/c9/de/89/c9de897da5a4c27ca2d48764cf5697a5.jpg" alt="Mountain" />
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMUB1A8qS0QRcPuNvyM1OpcAqEmvtlQ1Cytg&s" alt="Historical Place" />
          <img src="https://static.saltinourhair.com/wp-content/uploads/2017/04/23155119/Things-To-Do-Mirissa-Sri-Lanka-secret-beach-sunset.jpg" alt="Landscape" />
        </div>
      </div>
    </div>
  );
};

export default HomePage;
