import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

interface LoginFormProps {
    onLogin: (credentials: 
        {
            email: string,
            password: string
        }) => void
}

export const RedirectRegister: React.FC = () => {
    const navigate = useNavigate();

    return (
        <>
            <div className="redirect-container">
                <p className="redirect-text" onClick={() => navigate('/register')}>Click aqui si no tenes una cuenta</p>
            </div>
        </>
    )
}

export const LoginForm: React.FC<LoginFormProps> = ({ onLogin }) => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError ] = useState('');
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false);

    const handleSubmit = (e: React.FormEvent) => {
        e.preventDefault();
        setIsLoading(true);

        const storedData = localStorage.getItem('formData');

        if (!storedData) {
            setError('No hay datos almacenados');
            toast.error('No hay datos almacenados', {
                position: "top-center",
                autoClose: 1500,
                onClose: () => {
                    setIsLoading(false);
                }
            });
            return;
        }

        const userData = JSON.parse(storedData);

        if (userData.email === email && userData.contrasena === password) {
            localStorage.setItem('isAuthenticated', 'true');
            onLogin({ email, password });
            toast.success('Login exitoso! Redirigiendo...', {
                position: "top-center",
                autoClose: 1500,
                onClose: () => {
                    setIsLoading(false);
                    navigate('/home');
                }
            });
        } else {
            setError('Credenciales inválidas');
            toast.error('Credenciales invalidas', {
                position: "top-center",
                autoClose: 1500,
                onClose: () => {
                    setIsLoading(false);
                }
            });
        }     

     
    }

    return (
        <>
            <div className="form-container">
                <h2 className="form-title">Login</h2>
                <form onSubmit={handleSubmit}>
                    <div className="form-group">
                        <label htmlFor="email">Email:</label>
                        <input
                            type="email"
                            id="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                            disabled={isLoading}
                            placeholder="Ingrese su correo"
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="password">Password:</label>
                        <input
                            type="password"
                            id="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            required
                            disabled={isLoading}
                            placeholder="Ingrese su contraseña"
                        />
                    </div>
                    <button 
                        type="submit"
                        disabled={isLoading}
                        className="form-button"
                    >
                        {isLoading ? 'Iniciando sesion...' : 'Login'}
                    </button>
                </form>

                <RedirectRegister />
                <ToastContainer />         
            </div>
        </>
    );
};

