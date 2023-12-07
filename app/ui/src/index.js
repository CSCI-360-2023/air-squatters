import React, { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import LogInPage from './LogIn.js';
import SignUpPage from './SignUp.js';
import MainPage from './Main.js';
import ProfilePage from './Profile.js';

const root = createRoot(document.getElementById("root"));
root.render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<LogInPage/>}/>
        <Route path='/signup' element={<SignUpPage/>}/>
        <Route path='/main' element={<MainPage/>}/>
        <Route path='/profile' element={<ProfilePage/>}/>
      </Routes>
    </BrowserRouter>
  </StrictMode>
);