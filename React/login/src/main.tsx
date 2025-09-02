import React, { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import { ProtectedRoute } from './components/ProtectedRoute.tsx';

// Rutas
import { LoginForm } from './components/Login';
import { RegistroForm } from './components/Register.tsx'
import { Home } from './components/Home.tsx'

import './index.css'

const handleLogin = (credentials: { email: string, password: string }) => {
    console.log('Login attempt:', credentials);
  };

const router = createBrowserRouter([
  {
    path: '', 
    element: (
      <ProtectedRoute>
        <Home />
      </ProtectedRoute>
    )
  },
  {path: 'login', element: <LoginForm onLogin={handleLogin}/>},
  {path: 'register', element: <RegistroForm />},
  {
    path: 'home',
    element: (
      <ProtectedRoute>
        <Home />
      </ProtectedRoute>
    )
  }
])

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
  
