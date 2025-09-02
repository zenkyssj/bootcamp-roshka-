import '../styles/Footer.css';
import { FaFacebook, FaLinkedin, FaTwitter } from 'react-icons/fa';

export const Footer = () => {
    return (
        <footer className="footer">
            <div className="footer-content">
                <div className="footer-section">
                    <h3>Products</h3>
                    <ul>
                        <li><a href="#icm">ICM</a></li>
                        <li><a href="#dms">DMS</a></li>
                        <li><a href="#crm">CRM</a></li>
                    </ul>
                </div>

                <div className="footer-section">
                    <h3>Resources</h3>
                    <ul>
                        <li><a href="#case-studies">Case Studies</a></li>
                        <li><a href="#faqs">FAQ's</a></li>
                        <li><a href="#newsletter">Newsletter</a></li>
                        <li><a href="#release-notes">Release Notes</a></li>
                        <li><a href="#developers-guide">Developer's Guide</a></li>
                    </ul>
                </div>

                <div className="footer-section">
                    <h3>Company</h3>
                    <ul>
                        <li><a href="#about">About</a></li>
                        <li><a href="#experts">Our Experts</a></li>
                        <li><a href="#terms">Terms & Conditions</a></li>
                        <li><a href="#schedule">Schedule a Demo</a></li>
                        <li><a href="#privacy">Privacy Policy</a></li>
                    </ul>
                </div>

                <div className="footer-section">
                    <h3>Contact Us</h3>
                    <div className="social-icons">
                        <a href="#facebook" aria-label="Facebook">
                            <FaFacebook />
                        </a>
                        <a href="#linkedin" aria-label="LinkedIn">
                            <FaLinkedin />
                        </a>
                        <a href="#twitter" aria-label="Twitter">
                            <FaTwitter />
                        </a>
                    </div>
                </div>
            </div>
            <div className="footer-bottom">
                <p>© 2025. All Rights Reserved.</p>
            </div>
        </footer>
    );
};