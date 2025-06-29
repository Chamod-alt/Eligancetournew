import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./notification.css";

const Notifications = () => {
  const navigate = useNavigate();

  // Dummy notifications data (replace with real data later)
  const [notifications] = useState({
    preDesigned: [
      { id: 1, title: "Katunayaka to Sigiriya", details: "Booked by John Doe" },
      
    ],
    tourPlan: [
      { id: 3, title: "Custom 3-Day Tour 🏝️ PreDesigned Package", details: "Booked by Michael Brown" },
      { id: 4, title: "Colombo City Tour 🏕️ Tour Plan", details: "Booked by Sarah White" },
    ],
  });

  // Navigate to Notification Details Page
  const handleNotificationClick = (category, notification) => {
    if (category === "preDesigned" && notification.id === 1) {
      navigate(`/DropNotification`, { state: { DropName: notification.title } });
    }

    if (category === "tourPlan" && notification.id === 4) {
      navigate(`/TourPlanNotification`, { state: { tourName: notification.title } });
    }
  };

  return (
    <div className="notification_main">
    <div className="notifications-container">
      <h1 className="page-title">📢 Notifications</h1>

      {/* Pre-Designed Messages Section */}
      <div className="category-section">
        <h2 className="category-title">🌍 Drop</h2>
        <div className="notification-list">
          {notifications.preDesigned.map((notification) => (
            <div
              key={notification.id}
              className="notification-card clickable"
              onClick={() => handleNotificationClick("preDesigned", notification)}
            >
              <h3>{notification.title}</h3>
              <p>{notification.details}</p>
            </div>
          ))}
        </div>
      </div>

      {/* Tour Plan Section */}
      <div className="category-section">
        <h2 className="category-title">🗺️ Tour</h2>
        <div className="notification-list">
          {notifications.tourPlan.map((notification) => (
            <div
              key={notification.id}
              className="notification-card clickable"
              onClick={() => handleNotificationClick("tourPlan", notification)}
            >
              <h3>{notification.title}</h3>
              <p>{notification.details}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
    </div>
  );
};

export default Notifications;
