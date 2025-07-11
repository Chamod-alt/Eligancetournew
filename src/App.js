

import React from "react";
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from "react-router-dom";
import Login from "./pages/Login";
import Signup from "./pages/Signup"
import Homepage from "./pages/Homepage";
import Sidebar from"./compornents/Sidebar";
import Selectplaces from "./pages/selecttours/Selectplaces";
import Addtocart from "./pages/addtocart/Addtocart";
import Cart from "./pages/cart/Cart";
import Selectvehicle from "./pages/selectvehicle/Selectvehicle";
import Tourbooking from "./pages/tourbooking/Tourbooking";
import Bookingpending from "./pages/Bookingpending/Bookingpending";

import Adminvehicle from "./pages/Admin/Adminvehicle";
import Admintourlist from "./pages/Admin/Admintourlist/Admintourlist";
import Admintourrejected from "./pages/Admin/Admintourrejected/Admintourrejected";
import AdmintourAccept from "./pages/Admin/AdmintourAcceptlist/AdmintourAccept";
import Admintourdiscription from "./pages/Admin/Admintourdiscription/Admintourdiscription";
import Admintourplaces from "./pages/Admin/Admintourrplaces/Admintourplaces";

import Dropservice from "./pages/Drop/components/DropService/DropService";
import Dropbooking from "./pages/Drop/Dropbooking/Dropbooking";

import Dashboad from "./pages/Dashboad/Dashboad";
import Tourcatagory from "./pages/Tourcatagory/Tourcatagory";
import Predesign from "./pages/Selectsesion/Predesign";
import Userprofile from "./pages/Profile/Userprofile";
import Notification from "./pages/Notification/Notification";



//import About from "./About";

function App() {
  return (
    <Router>
     
      <Routes>
        <Route path="/" element={<Homepage />} />
        <Route path="/Signup" element={<Signup />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/Homepage" element={<Homepage />} />
        <Route path="/Selectplaces" element={<Selectplaces />} />
        <Route path='/Addtocart' element={<Addtocart />} />
        <Route path='/Cart' element={<Cart />} />
        <Route path="/Selectvehicle" element={<Selectvehicle />} />
        <Route path ="/Tourbooking" element={<Tourbooking />} />
        <Route path="/Bookingpending" element={<Bookingpending />} />

        <Route path="/Adminvehicle" element={<Adminvehicle />} />
        <Route path="/Admintourlist" element={<Admintourlist />} />
        <Route path="/Admintourrejected" element={<Admintourrejected />} />
        <Route path="/AdmintourAccept" element={<AdmintourAccept />} />
        <Route path="/Admintourdiscription" element={<Admintourdiscription />} />
        <Route path="/Admintourplaces" element={<Admintourplaces />} />

        <Route path="/Dropservice" element={<Dropservice />} />
        <Route path="/Dropbooking"  element={<Dropbooking />} />

        <Route path="/Dashboad" element={<Dashboad />} />
        <Route path="/Tourcatagory" element={<Tourcatagory />} />
        <Route path="/Predesign" element={<Predesign />} />
        <Route path="/Userprofile"  element={<Userprofile />} />
        <Route path="/Notification" element={<Notification />} />
      </Routes>
      
    </Router> 
    
  );
}

export default App;
