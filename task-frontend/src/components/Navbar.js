import React from "react";
import { Link, useLocation } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

const Navbar = () => {
  const { pathname } = useLocation();

  const handleLogout = () => {
    localStorage.removeItem("userToken");
    window.location.href = "/";
  };

  const isFormPage = pathname === "/form";
  const isReportPage = pathname === "/report";
  const isThankyouPage = pathname === "/Thankyou";

  return (
    <div className="navbar">
      <div className="logo">Task Management System</div>
      <div className="nav-items">
        {isFormPage && (
          <button className="btn btn-outline-light" onClick={handleLogout}>
            Logout
          </button>
        )}
        {isReportPage && (
          <button className="btn btn-outline-light" onClick={handleLogout}>
            Logout
          </button>
        )}
        {isThankyouPage && (
          <button className="btn btn-outline-light" onClick={handleLogout}>
            Logout
          </button>
        )}
      </div>
    </div>
  );
};

export default Navbar;
