import '../styles/Navbar.css'
import logo from '../assets/logo.png' // Asegúrate de tener el logo en esta ruta
import React from 'react';

interface NavbarProps {
    onLogin?: () => void;
    onBookDemo?: () => void;
}

export const Navbar: React.FC<NavbarProps> = ({ onLogin, onBookDemo }) => {
    return (
        <nav className="navbar">
            <div className="navbar-left">
                <img src={logo} alt="Logo" className="navbar-logo" />
            </div>
            
            <div className="navbar-center">
                <ul className="nav-links">
                    <li><a href="#products">Products</a></li>
                    <li><a href="#resources">Resources</a></li>
                    <li><a href="#about">About Us</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                </ul>
            </div>
            
            <div className="navbar-right">
                <button className="login-btn" onClick={onLogin}>
                    Login
                </button>
                <button className="demo-btn" onClick={onBookDemo}>
                    Book a Demo
                </button>
            </div>
        </nav>
    )
}