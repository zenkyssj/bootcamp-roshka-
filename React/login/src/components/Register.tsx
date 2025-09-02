import React, {useState} from 'react';
import type { FormEvent } from 'react';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';
import '../styles/Form.css';


interface RegistroForm{
    nombre: string;
    email: string;
    contrasena: string;
}

export const RedirectLogin: React.FC = () => {
    
    const navigate = useNavigate();



    return (
        <>
            <div className='redirect-container'>
                <p className='redirect-text' onClick={() => navigate('/login')}>¿Ya tenes una cuenta? Click aqui</p>
            </div>
  
        </>

    )
}

export const RegistroForm: React.FC = () => {
    const navigate = useNavigate();
    const [isLoading, setIsLoading] = useState(false);
    const [formData, setFormData] = useState<RegistroForm>({

        nombre: '',
        email: '',
        contrasena: ''
    });

    const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value,
        }));
    };

    const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setIsLoading(true);

        console.log('Datos del formulario:', formData);
        localStorage.setItem('formData', JSON.stringify(formData));
        
        toast.success('Registro exitoso! Redirigiendo...', {
            position: "top-center",
            autoClose: 2500,
            onClose: () => {
                setIsLoading(false);
                navigate('/login');
            }
        });
    };

    return (
        <>
            <div className='form-container'>
                <h2 className='form-title'>Registro</h2>
                <form onSubmit={handleSubmit}>
                    <div className='form-group'>
                        <label>Nombre:</label>
                        <input
                            type="text"
                            name="nombre"
                            value={formData.nombre}
                            onChange={handleChange}
                            required
                            disabled={isLoading}
                            placeholder="Ingrese su nombre"
                        />
                    </div>
                    <div className='form-group'>
                        <label>Email:</label>
                        <input
                            type="email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            required
                            disabled={isLoading}
                            placeholder="Ingrese su correo"
                        />
                    </div>
                    <div className='form-group'>
                        <label>Contrasena:</label>
                        <input
                            type="password"
                            name="contrasena"
                            value={formData.contrasena}
                            onChange={handleChange}
                            required
                            disabled={isLoading}
                            placeholder="Ingrese su contraseña"
                        />
                    </div>

                    <button
                        type="submit"
                        disabled={isLoading}
                        className='form-button'
                    >
                        {isLoading ? 'Registrando...' : 'Registrarse'}
                    </button>
                </form>

                <RedirectLogin  /> 
                <ToastContainer />
            </div>
        </>
    );
};